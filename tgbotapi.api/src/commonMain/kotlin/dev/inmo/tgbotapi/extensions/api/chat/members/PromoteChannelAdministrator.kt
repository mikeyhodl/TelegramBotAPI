package dev.inmo.tgbotapi.extensions.api.chat.members

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.chat.members.PromoteChannelAdministrator
import dev.inmo.tgbotapi.requests.chat.members.PromoteChatMember
import dev.inmo.tgbotapi.types.IdChatIdentifier
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.TelegramDate
import dev.inmo.tgbotapi.types.UserId
import dev.inmo.tgbotapi.types.chat.PublicChat
import dev.inmo.tgbotapi.types.chat.User

public suspend fun TelegramBot.promoteChannelAdministrator(
    chatId: ChatIdentifier,
    userId: UserId,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null,
    canPostStories: Boolean? = null,
    canEditStories: Boolean? = null,
    canDeleteStories: Boolean? = null
): Boolean = execute(
    PromoteChannelAdministrator(
        chatId = chatId,
        userId = userId,
        untilDate = untilDate,
        isAnonymous = isAnonymous,
        canChangeInfo = canChangeInfo,
        canPostMessages = canPostMessages,
        canEditMessages = canEditMessages,
        canDeleteMessages = canDeleteMessages,
        canInviteUsers = canInviteUsers,
        canRestrictMembers = canRestrictMembers,
        canPromoteMembers = canPromoteMembers,
        canManageVideoChats = canManageVideoChats,
        canManageChat = canManageChat,
        canPostStories = canPostStories,
        canEditStories = canEditStories,
        canDeleteStories = canDeleteStories
    )
)

public suspend fun TelegramBot.promoteChannelAdministrator(
    chat: PublicChat,
    userId: UserId,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null,
    canPostStories: Boolean? = null,
    canEditStories: Boolean? = null,
    canDeleteStories: Boolean? = null
): Boolean = promoteChannelAdministrator(
    chat.id,
    userId,
    untilDate = untilDate,
    isAnonymous = isAnonymous,
    canChangeInfo = canChangeInfo,
    canPostMessages = canPostMessages,
    canEditMessages = canEditMessages,
    canDeleteMessages = canDeleteMessages,
    canInviteUsers = canInviteUsers,
    canRestrictMembers = canRestrictMembers,
    canPromoteMembers = canPromoteMembers,
    canManageVideoChats = canManageVideoChats,
    canManageChat = canManageChat,
    canPostStories = canPostStories,
    canEditStories = canEditStories,
    canDeleteStories = canDeleteStories
)

public suspend fun TelegramBot.promoteChannelAdministrator(
    chatId: IdChatIdentifier,
    user: User,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null,
    canPostStories: Boolean? = null,
    canEditStories: Boolean? = null,
    canDeleteStories: Boolean? = null
): Boolean = promoteChannelAdministrator(
    chatId,
    user.id,
    untilDate = untilDate,
    isAnonymous = isAnonymous,
    canChangeInfo = canChangeInfo,
    canPostMessages = canPostMessages,
    canEditMessages = canEditMessages,
    canDeleteMessages = canDeleteMessages,
    canInviteUsers = canInviteUsers,
    canRestrictMembers = canRestrictMembers,
    canPromoteMembers = canPromoteMembers,
    canManageVideoChats = canManageVideoChats,
    canManageChat = canManageChat,
    canPostStories = canPostStories,
    canEditStories = canEditStories,
    canDeleteStories = canDeleteStories
)

public suspend fun TelegramBot.promoteChannelAdministrator(
    chat: PublicChat,
    user: User,
    untilDate: TelegramDate? = null,
    isAnonymous: Boolean? = null,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    canManageVideoChats: Boolean? = null,
    canManageChat: Boolean? = null,
    canPostStories: Boolean? = null,
    canEditStories: Boolean? = null,
    canDeleteStories: Boolean? = null
): Boolean = promoteChannelAdministrator(
    chat.id,
    user.id,
    untilDate = untilDate,
    isAnonymous = isAnonymous,
    canChangeInfo = canChangeInfo,
    canPostMessages = canPostMessages,
    canEditMessages = canEditMessages,
    canDeleteMessages = canDeleteMessages,
    canInviteUsers = canInviteUsers,
    canRestrictMembers = canRestrictMembers,
    canPromoteMembers = canPromoteMembers,
    canManageVideoChats = canManageVideoChats,
    canManageChat = canManageChat,
    canPostStories = canPostStories,
    canEditStories = canEditStories,
    canDeleteStories = canDeleteStories
)
