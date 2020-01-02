package com.github.insanusmokrassar.TelegramBotAPI.types.MessageEntity.textsources

import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.TextSource
import com.github.insanusmokrassar.TelegramBotAPI.utils.strikethroughHTML
import com.github.insanusmokrassar.TelegramBotAPI.utils.strikethroughMarkdown

class StrikethroughTextSource(
    override val rawSource: String
) : TextSource {
    override val asHtmlSource: String
        get() = rawSource.strikethroughHTML()
    override val asMarkdownSource: String
        get() = rawSource.strikethroughMarkdown()
}