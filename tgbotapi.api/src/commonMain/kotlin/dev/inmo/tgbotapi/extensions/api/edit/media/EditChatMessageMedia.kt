package dev.inmo.tgbotapi.extensions.api.edit.media

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.edit.media.EditChatMessageMedia
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.media.TelegramMedia
import dev.inmo.tgbotapi.types.MessageId
import dev.inmo.tgbotapi.types.businessConnectionId
import dev.inmo.tgbotapi.types.business_connection.BusinessConnectionId
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardMarkup
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.content.MediaContent

/**
 * @param replyMarkup Some [InlineKeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard]
 * as a builder for that
 */
suspend fun TelegramBot.editMessageMedia(
    chatId: ChatIdentifier,
    messageId: MessageId,
    media: TelegramMedia,
    businessConnectionId: BusinessConnectionId? = chatId.businessConnectionId,
    replyMarkup: InlineKeyboardMarkup? = null
) = execute(
    EditChatMessageMedia(chatId, messageId, media, businessConnectionId, replyMarkup)
)

/**
 * @param replyMarkup Some [InlineKeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard]
 * as a builder for that
 */
suspend fun TelegramBot.editMessageMedia(
    chat: Chat,
    messageId: MessageId,
    media: TelegramMedia,
    businessConnectionId: BusinessConnectionId? = chat.id.businessConnectionId,
    replyMarkup: InlineKeyboardMarkup? = null
) = editMessageMedia(chat.id, messageId, media, businessConnectionId, replyMarkup)

/**
 * @param replyMarkup Some [InlineKeyboardMarkup]. See [dev.inmo.tgbotapi.extensions.utils.types.buttons.inlineKeyboard]
 * as a builder for that
 */
suspend fun TelegramBot.editMessageMedia(
    message: ContentMessage<out MediaContent>,
    media: TelegramMedia,
    businessConnectionId: BusinessConnectionId? = message.chat.id.businessConnectionId,
    replyMarkup: InlineKeyboardMarkup? = null
) = editMessageMedia(message.chat.id, message.messageId, media, businessConnectionId, replyMarkup)
