@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE")

package com.saveourtool.osv4k.jackson

import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>()
actual class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>()
