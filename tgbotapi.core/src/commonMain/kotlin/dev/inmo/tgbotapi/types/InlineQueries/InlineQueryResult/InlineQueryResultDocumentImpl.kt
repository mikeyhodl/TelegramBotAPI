package dev.inmo.tgbotapi.types.InlineQueries.InlineQueryResult

import dev.inmo.tgbotapi.CommonAbstracts.*
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.InlineQueries.InlineQueryResult.abstracts.results.document.InlineQueryResultDocument
import dev.inmo.tgbotapi.types.InlineQueries.InlineQueryResult.abstracts.results.document.inlineQueryResultDocumentType
import dev.inmo.tgbotapi.types.InlineQueries.abstracts.InputMessageContent
import dev.inmo.tgbotapi.types.MessageEntity.*
import dev.inmo.tgbotapi.types.MessageEntity.RawMessageEntity
import dev.inmo.tgbotapi.types.MessageEntity.asTextParts
import dev.inmo.tgbotapi.types.ParseMode.ParseMode
import dev.inmo.tgbotapi.types.ParseMode.parseModeField
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardMarkup
import dev.inmo.tgbotapi.types.files.abstracts.mimeTypeField
import dev.inmo.tgbotapi.utils.MimeType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

fun InlineQueryResultDocumentImpl(
    id: InlineQueryIdentifier,
    url: String,
    title: String,
    mimeType: MimeType,
    thumbUrl: String? = null,
    thumbWidth: Int? = null,
    thumbHeight: Int? = null,
    description: String? = null,
    text: String? = null,
    parseMode: ParseMode? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    inputMessageContent: InputMessageContent? = null
) = InlineQueryResultDocumentImpl(id, url, title, mimeType, thumbUrl, thumbWidth, thumbHeight, description, text, parseMode, null, replyMarkup, inputMessageContent)

fun InlineQueryResultDocumentImpl(
    id: InlineQueryIdentifier,
    url: String,
    title: String,
    mimeType: MimeType,
    thumbUrl: String? = null,
    thumbWidth: Int? = null,
    thumbHeight: Int? = null,
    description: String? = null,
    entities: List<TextSource>,
    replyMarkup: InlineKeyboardMarkup? = null,
    inputMessageContent: InputMessageContent? = null
) = InlineQueryResultDocumentImpl(id, url, title, mimeType, thumbUrl, thumbWidth, thumbHeight, description, entities.makeString(), null, entities.toRawMessageEntities(), replyMarkup, inputMessageContent)

@Serializable
data class InlineQueryResultDocumentImpl internal constructor(
    @SerialName(idField)
    override val id: InlineQueryIdentifier,
    @SerialName(documentUrlField)
    override val url: String,
    @SerialName(titleField)
    override val title: String,
    @SerialName(mimeTypeField)
    override val mimeType: MimeType,
    @SerialName(thumbUrlField)
    override val thumbUrl: String? = null,
    @SerialName(thumbWidthField)
    override val thumbWidth: Int? = null,
    @SerialName(thumbHeightField)
    override val thumbHeight: Int? = null,
    @SerialName(descriptionField)
    override val description: String? = null,
    @SerialName(captionField)
    override val text: String? = null,
    @SerialName(parseModeField)
    override val parseMode: ParseMode? = null,
    @SerialName(captionEntitiesField)
    private val rawEntities: List<RawMessageEntity>? = null,
    @SerialName(replyMarkupField)
    override val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName(inputMessageContentField)
    override val inputMessageContent: InputMessageContent? = null
) : InlineQueryResultDocument {
    override val type: String = inlineQueryResultDocumentType
    override val entities: List<TextSource>? by lazy {
        rawEntities ?.asTextParts(text ?: return@lazy null) ?.justTextSources()
    }
}
