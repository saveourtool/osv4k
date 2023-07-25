package com.saveourtool.osv4k.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.enums.EnumEntries

abstract class EnumAsValueSerializer<E : Enum<E>>(
    private val serialName: String,
    private val valueGetter: (E) -> String,
    private val entries: EnumEntries<E>,
): KSerializer<E> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(serialName, PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): E = decoder.decodeString().let { value ->
        entries.find { valueGetter(it) == value } ?: throw IllegalArgumentException("$serialName could not parse: $value")
    }

    override fun serialize(encoder: Encoder, value: E) = encoder.encodeString(valueGetter(value))
}