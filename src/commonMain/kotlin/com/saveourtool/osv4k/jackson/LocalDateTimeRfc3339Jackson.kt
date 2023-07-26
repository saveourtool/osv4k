package com.saveourtool.osv4k.jackson

import com.saveourtool.osv4k.jackson.JsonDeserializer
import com.saveourtool.osv4k.jackson.JsonSerializer
import kotlinx.datetime.LocalDateTime

expect class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>

expect class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>
