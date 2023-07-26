package com.saveourtool.osv4k.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper
import com.fasterxml.jackson.databind.jsontype.TypeSerializer
import com.fasterxml.jackson.databind.ser.PropertyWriter
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.databind.util.NameTransformer
import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonSerializer : JsonSerializer<LocalDateTime>() {
    private val stdSerializer: StdSerializer<LocalDateTime> = object : StdSerializer<LocalDateTime>(LocalDateTime::class.java) {
        override fun serialize(value: LocalDateTime, gen: JsonGenerator, provider: SerializerProvider) {
            gen.writeString(LocalDateTimeRfc3339Util.toString(value))
        }
    }

    override fun acceptJsonFormatVisitor(visitor: JsonFormatVisitorWrapper?, type: JavaType?) {
        stdSerializer.acceptJsonFormatVisitor(visitor, type)
    }

    override fun unwrappingSerializer(unwrapper: NameTransformer?): JsonSerializer<LocalDateTime> {
        return stdSerializer.unwrappingSerializer(unwrapper)
    }

    override fun replaceDelegatee(delegatee: JsonSerializer<*>?): JsonSerializer<LocalDateTime> {
        return stdSerializer.replaceDelegatee(delegatee)
    }

    override fun withFilterId(filterId: Any?): JsonSerializer<*> {
        return stdSerializer.withFilterId(filterId)
    }

    override fun serialize(value: LocalDateTime?, gen: JsonGenerator?, serializers: SerializerProvider?) = stdSerializer.serialize(value, gen, serializers)

    override fun serializeWithType(
        value: LocalDateTime?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?,
        typeSer: TypeSerializer?
    ) {
        stdSerializer.serializeWithType(value, gen, serializers, typeSer)
    }

    override fun handledType(): Class<LocalDateTime> {
        return stdSerializer.handledType()
    }

    override fun isEmpty(value: LocalDateTime?): Boolean {
        return stdSerializer.isEmpty(value)
    }

    override fun isEmpty(provider: SerializerProvider?, value: LocalDateTime?): Boolean {
        return stdSerializer.isEmpty(provider, value)
    }

    override fun usesObjectId(): Boolean {
        return stdSerializer.usesObjectId()
    }

    override fun isUnwrappingSerializer(): Boolean {
        return stdSerializer.isUnwrappingSerializer()
    }

    override fun getDelegatee(): JsonSerializer<*> {
        return stdSerializer.getDelegatee()
    }

    override fun properties(): MutableIterator<PropertyWriter> {
        return stdSerializer.properties()
    }
}

actual class LocalDateTimeRfc3339JacksonDeserializer : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime =
            LocalDateTimeRfc3339Util.fromString(p.text)
}