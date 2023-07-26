package com.saveourtool.osv4k.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.SettableBeanProperty
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer
import com.fasterxml.jackson.databind.jsontype.TypeSerializer
import com.fasterxml.jackson.databind.ser.PropertyWriter
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fasterxml.jackson.databind.type.LogicalType
import com.fasterxml.jackson.databind.util.AccessPattern
import com.fasterxml.jackson.databind.util.NameTransformer
import com.saveourtool.osv4k.annotations.JsonDeserializer
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
        return stdSerializer.isUnwrappingSerializer
    }

    override fun getDelegatee(): JsonSerializer<*> {
        return stdSerializer.delegatee
    }

    override fun properties(): MutableIterator<PropertyWriter> {
        return stdSerializer.properties()
    }
}

actual class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>() {
    private val stdDeserializer: StdDeserializer<LocalDateTime> = object : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {
        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): LocalDateTime =
            LocalDateTimeRfc3339Util.fromString(p.text)
    }

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): LocalDateTime =
            stdDeserializer.deserialize(p, ctxt)

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?, intoValue: LocalDateTime?): LocalDateTime =
            stdDeserializer.deserialize(p, ctxt, intoValue)

    override fun getNullValue(ctxt: DeserializationContext?): LocalDateTime = stdDeserializer.getNullValue(ctxt)

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getNullValue(): LocalDateTime = stdDeserializer.nullValue

    override fun getNullAccessPattern(): AccessPattern = stdDeserializer.nullAccessPattern

    override fun getAbsentValue(ctxt: DeserializationContext?): Any = stdDeserializer.getAbsentValue(ctxt)

    override fun deserializeWithType(
        p: JsonParser?,
        ctxt: DeserializationContext?,
        typeDeserializer: TypeDeserializer?
    ): Any = stdDeserializer.deserializeWithType(p, ctxt, typeDeserializer)

    override fun deserializeWithType(
        p: JsonParser?,
        ctxt: DeserializationContext?,
        typeDeserializer: TypeDeserializer?,
        intoValue: LocalDateTime?
    ): Any = stdDeserializer.deserializeWithType(p, ctxt, typeDeserializer, intoValue)

    override fun unwrappingDeserializer(unwrapper: NameTransformer?): com.fasterxml.jackson.databind.JsonDeserializer<LocalDateTime> =
            stdDeserializer.unwrappingDeserializer(unwrapper)

    override fun replaceDelegatee(delegatee: com.fasterxml.jackson.databind.JsonDeserializer<*>?): com.fasterxml.jackson.databind.JsonDeserializer<*> =
            stdDeserializer.replaceDelegatee(delegatee)

    override fun handledType(): Class<*> = stdDeserializer.handledType()

    override fun logicalType(): LogicalType = stdDeserializer.logicalType()

    override fun isCachable(): Boolean = stdDeserializer.isCachable

    override fun getDelegatee(): com.fasterxml.jackson.databind.JsonDeserializer<*> = stdDeserializer.delegatee

    override fun getKnownPropertyNames(): MutableCollection<Any> = stdDeserializer.knownPropertyNames

    override fun getEmptyValue(ctxt: DeserializationContext?): Any = stdDeserializer.getEmptyValue(ctxt)

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getEmptyValue(): Any = stdDeserializer.emptyValue

    override fun getEmptyAccessPattern(): AccessPattern = stdDeserializer.emptyAccessPattern

    override fun getObjectIdReader(): ObjectIdReader? = stdDeserializer.objectIdReader

    override fun findBackReference(refName: String?): SettableBeanProperty = stdDeserializer.findBackReference(refName)

    override fun supportsUpdate(config: DeserializationConfig?): Boolean = stdDeserializer.supportsUpdate(config)
}