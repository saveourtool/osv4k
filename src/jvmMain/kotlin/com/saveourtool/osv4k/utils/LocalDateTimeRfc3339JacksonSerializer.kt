package com.saveourtool.osv4k.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonSerializer : StdSerializer<LocalDateTime>(LocalDateTime::class.java) {
    override fun serialize(value: LocalDateTime, gen: JsonGenerator, provider: SerializerProvider) {
        gen.writeString(LocalDateTimeRfc3339Util.toString(value))
    }
}

actual class LocalDateTimeRfc3339JacksonDeserializer : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime =
            LocalDateTimeRfc3339Util.fromString(p.text)
}