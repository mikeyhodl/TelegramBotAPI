package com.github.insanusmokrassar.TelegramBotAPI.bot.Ktor

import com.github.insanusmokrassar.TelegramBotAPI.bot.BaseRequestsExecutor
import com.github.insanusmokrassar.TelegramBotAPI.bot.Ktor.base.MultipartRequestCallFactory
import com.github.insanusmokrassar.TelegramBotAPI.bot.Ktor.base.SimpleRequestCallFactory
import com.github.insanusmokrassar.TelegramBotAPI.bot.exceptions.newRequestException
import com.github.insanusmokrassar.TelegramBotAPI.bot.settings.limiters.EmptyLimiter
import com.github.insanusmokrassar.TelegramBotAPI.bot.settings.limiters.RequestLimiter
import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.Request
import com.github.insanusmokrassar.TelegramBotAPI.types.Response
import com.github.insanusmokrassar.TelegramBotAPI.types.RetryAfterError
import com.github.insanusmokrassar.TelegramBotAPI.utils.TelegramAPIUrlsKeeper
import io.ktor.client.HttpClient
import io.ktor.client.call.HttpClientCall
import io.ktor.client.call.receive
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

class KtorRequestsExecutor(
    telegramAPIUrlsKeeper: TelegramAPIUrlsKeeper,
    private val client: HttpClient = HttpClient(),
    callsFactories: List<KtorCallFactory> = emptyList(),
    excludeDefaultFactories: Boolean = false,
    private val requestsLimiter: RequestLimiter = EmptyLimiter,
    private val jsonFormatter: Json = Json.nonstrict
) : BaseRequestsExecutor(telegramAPIUrlsKeeper) {
    private val callsFactories: List<KtorCallFactory> = callsFactories.run {
        if (!excludeDefaultFactories) {
            asSequence().plus(SimpleRequestCallFactory()).plus(MultipartRequestCallFactory()).toList()
        } else {
            this
        }
    }

    override suspend fun <T : Any> execute(request: Request<T>): T {
        return requestsLimiter.limit {
            var call: HttpClientCall? = null
            for (factory in callsFactories) {
                call = factory.prepareCall(
                    client,
                    telegramAPIUrlsKeeper.commonAPIUrl,
                    request
                )
                if (call != null) {
                    break
                }
            }
            if (call == null) {
                throw IllegalArgumentException("Can't execute request: $request")
            }
            val content = call.response.receive<String>()
            val responseObject = jsonFormatter.parse(Response.serializer(), content)

            (responseObject.result ?.let {
                jsonFormatter.fromJson(request.resultDeserializer, it)
            } ?: responseObject.parameters ?.let {
                val error = it.error
                if (error is RetryAfterError) {
                    delay(error.leftToRetry)
                    execute(request)
                } else {
                    null
                }
            } ?: call.let {
                throw newRequestException(
                    responseObject,
                    content,
                    "Can't get result object from $content"
                )
            })
        }
    }

    override fun close() {
        client.close()
    }
}