package com.github.insanusmokrassar.TelegramBotAPI.types.files

import com.github.insanusmokrassar.TelegramBotAPI.utils.TelegramAPIUrlsKeeper
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL

fun PathedFile.asStream(
        telegramAPIUrlsKeeper: TelegramAPIUrlsKeeper
): InputStream = URL(this.fullUrl(telegramAPIUrlsKeeper)).openStream()

fun PathedFile.asFile(
        telegramAPIUrlsKeeper: TelegramAPIUrlsKeeper,
        dest: File = File.createTempFile(this.fileUniqueId, this.filename),
        defaultBufferSize: Int = 1024
): File {
    this.asStream(telegramAPIUrlsKeeper).use { input ->
        FileOutputStream(dest).use { out ->
            input.copyTo(out, defaultBufferSize)
        }
    }
    return dest
}

fun PathedFile.asBytes(
        telegramAPIUrlsKeeper: TelegramAPIUrlsKeeper
): ByteArray {
    return this.asStream(telegramAPIUrlsKeeper).use { input ->
        input.readBytes()
    }
}
