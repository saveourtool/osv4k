@file:Suppress("DEPRECATION")

package com.saveourtool.osv4k.jackson

import com.saveourtool.osv4k.utils.fromRfc339String

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationConfig
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.SettableBeanProperty
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer
import com.fasterxml.jackson.databind.type.LogicalType
import com.fasterxml.jackson.databind.util.AccessPattern
import com.fasterxml.jackson.databind.util.NameTransformer

import kotlinx.datetime.LocalDateTime

actual class LocalDateTimeRfc3339JacksonDeserializer : JsonDeserializer<LocalDateTime>() {
    private val stdDeserializer: StdDeserializer<LocalDateTime> = object : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {
        override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): LocalDateTime =
                fromRfc339String(parser.text)
    }

    override fun deserialize(parser: JsonParser?, ctxt: DeserializationContext?): LocalDateTime? =
            stdDeserializer.deserialize(parser, ctxt)

    override fun deserialize(
        parser: JsonParser?,
        ctxt: DeserializationContext?,
        intoValue: LocalDateTime?
    ): LocalDateTime =
            stdDeserializer.deserialize(parser, ctxt, intoValue)

    override fun getNullValue(ctxt: DeserializationContext?): LocalDateTime = stdDeserializer.getNullValue(ctxt)

    @Suppress("OVERRIDE_DEPRECATION")
    override fun getNullValue(): LocalDateTime? = stdDeserializer.nullValue

    override fun getNullAccessPattern(): AccessPattern = stdDeserializer.nullAccessPattern

    override fun getAbsentValue(ctxt: DeserializationContext?): Any? = stdDeserializer.getAbsentValue(ctxt)

    override fun deserializeWithType(
        parser: JsonParser?,
        ctxt: DeserializationContext?,
        typeDeserializer: TypeDeserializer?
    ): Any? = stdDeserializer.deserializeWithType(parser, ctxt, typeDeserializer)

    override fun deserializeWithType(
        parser: JsonParser?,
        ctxt: DeserializationContext?,
        typeDeserializer: TypeDeserializer?,
        intoValue: LocalDateTime?
    ): Any = stdDeserializer.deserializeWithType(parser, ctxt, typeDeserializer, intoValue)

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
    override fun getEmptyValue(): Any? = stdDeserializer.emptyValue

    override fun getEmptyAccessPattern(): AccessPattern = stdDeserializer.emptyAccessPattern

    override fun getObjectIdReader(): ObjectIdReader? = stdDeserializer.objectIdReader

    override fun findBackReference(refName: String?): SettableBeanProperty = stdDeserializer.findBackReference(refName)

    override fun supportsUpdate(config: DeserializationConfig?): Boolean = stdDeserializer.supportsUpdate(config)
}
