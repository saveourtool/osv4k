@file:Suppress("DEPRECATION")

package com.saveourtool.osv4k.jackson

import com.saveourtool.osv4k.utils.toRfc339String

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper
import com.fasterxml.jackson.databind.jsontype.TypeSerializer
import com.fasterxml.jackson.databind.ser.PropertyWriter
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.databind.util.NameTransformer

import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>() {
    private val stdSerializer: StdSerializer<LocalDateTime> = object : StdSerializer<LocalDateTime>(LocalDateTime::class.java) {
        override fun serialize(
            value: LocalDateTime,
            gen: JsonGenerator,
            provider: SerializerProvider
        ) {
            gen.writeString(value.toRfc339String())
        }
    }

    override fun acceptJsonFormatVisitor(visitor: JsonFormatVisitorWrapper?, type: JavaType?) {
        stdSerializer.acceptJsonFormatVisitor(visitor, type)
    }

    override fun unwrappingSerializer(unwrapper: NameTransformer?): JsonSerializer<LocalDateTime> = stdSerializer.unwrappingSerializer(unwrapper)

    override fun replaceDelegatee(delegatee: JsonSerializer<*>?): JsonSerializer<LocalDateTime> = stdSerializer.replaceDelegatee(delegatee)

    override fun withFilterId(filterId: Any?): JsonSerializer<*> = stdSerializer.withFilterId(filterId)

    override fun serialize(
        value: LocalDateTime?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?
    ) = stdSerializer.serialize(value, gen, serializers)

    override fun serializeWithType(
        value: LocalDateTime?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?,
        typeSer: TypeSerializer?
    ) {
        stdSerializer.serializeWithType(value, gen, serializers, typeSer)
    }

    override fun handledType(): Class<LocalDateTime> = stdSerializer.handledType()

    @Suppress("OVERRIDE_DEPRECATION")
    override fun isEmpty(value: LocalDateTime?): Boolean = stdSerializer.isEmpty(value)

    override fun isEmpty(provider: SerializerProvider?, value: LocalDateTime?): Boolean =
            stdSerializer.isEmpty(provider, value)

    override fun usesObjectId(): Boolean = stdSerializer.usesObjectId()

    override fun isUnwrappingSerializer(): Boolean = stdSerializer.isUnwrappingSerializer

    override fun getDelegatee(): JsonSerializer<*> = stdSerializer.delegatee

    override fun properties(): MutableIterator<PropertyWriter> = stdSerializer.properties()
}
