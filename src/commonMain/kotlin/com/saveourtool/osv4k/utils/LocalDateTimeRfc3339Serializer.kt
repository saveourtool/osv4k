package com.saveourtool.osv4k.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object LocalDateTimeRfc3339Serializer: KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDateTime = decoder.decodeString().let { value ->
        LocalDateTimeRfc3339Util.fromString(value)
    }


    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(LocalDateTimeRfc3339Util.toString(value))
    }
}