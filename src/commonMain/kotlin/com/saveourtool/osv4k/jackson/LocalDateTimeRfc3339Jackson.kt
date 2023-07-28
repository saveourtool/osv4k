@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

import kotlinx.datetime.LocalDateTime

expect class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>

expect class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>
