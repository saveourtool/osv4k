package com.saveourtool.osv4k.utils

import com.saveourtool.osv4k.annotations.JsonDeserializer
import com.saveourtool.osv4k.annotations.JsonSerializer
import kotlinx.datetime.LocalDateTime

expect class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>

expect class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>
