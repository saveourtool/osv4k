package com.saveourtool.osv4k.utils

import com.saveourtool.osv4k.annotations.JsonSerializer
import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonSerializer: JsonSerializer<LocalDateTime>()
actual class LocalDateTimeRfc3339JacksonDeserializer