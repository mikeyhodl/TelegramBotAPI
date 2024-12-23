package dev.inmo.tgbotapi.types.message.textsources

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.chat.CommonUser
import dev.inmo.tgbotapi.types.chat.User
import dev.inmo.tgbotapi.utils.RiskFeature
import dev.inmo.tgbotapi.utils.extensions.makeString
import dev.inmo.tgbotapi.utils.internal.*
import kotlinx.serialization.Serializable

/**
 * @see mention
 */
@Serializable
data class TextMentionTextSource @RiskFeature(DirectInvocationOfTextSourceConstructor) constructor (
    override val source: String,
    val user: User,
    override val subsources: TextSourcesList
) : MultilevelTextSource {
    override val markdown: String by lazy { source.textMentionMarkdown(user.id) }
    override val markdownV2: String by lazy { textMentionMarkdownV2(user.id) }
    override val html: String by lazy { textMentionHTML(user.id) }
}

inline fun mention(parts: TextSourcesList, user: User) = TextMentionTextSource(parts.makeString(), user, parts)
inline fun User.mention(parts: TextSourcesList) = mention(parts, this)
inline fun mention(parts: TextSourcesList, userId: UserId) = mention(parts, CommonUser(userId, ""))
inline fun UserId.mention(parts: TextSourcesList) = mention(parts, this)
inline fun mention(parts: TextSourcesList, id: RawChatId) = mention(parts, UserId(id))
inline fun RawChatId.mention(parts: TextSourcesList) = mention(parts, this)
inline fun mention(user: User, vararg parts: TextSource) = mention(
    textSourcesOrElseTextSource(parts.toList()) {
        RegularTextSource("${user.lastName} ${user.firstName}")
    },
    user
)
inline fun mention(text: String, user: User) = mention(user, regular(text))
inline fun User.mention(text: String) = mention(this, regular(text))
inline fun mention(text: String, userId: UserId) = mention(text, CommonUser(userId, ""))
inline fun UserId.mention(text: String) = mention(text, this)
inline fun mention(text: String, id: RawChatId) = mention(text, UserId(id))
inline fun RawChatId.mention(text: String) = mention(text, this)
