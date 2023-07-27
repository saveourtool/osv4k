package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

/**
 * @property using
 * @property contentUsing
 * @property keyUsing
 * @property builder
 * @property converter
 * @property contentConverter
 * @property `as`
 * @property keyAs
 * @property contentAs
 */
@Suppress(
    "LongParameterList",
    "KDOC_NO_CONSTRUCTOR_PROPERTY",
    "BACKTICKS_PROHIBITED",
    "TYPE_ALIAS",
)
expect annotation class JsonDeserialize(
    val using: KClass<out JsonDeserializer<out Any>>,
    val contentUsing: KClass<out JsonDeserializer<out Any>>,
    val keyUsing: KClass<out KeyDeserializer>,
    val builder: KClass<*>,
    val converter: KClass<out Converter<Any, Any>>,
    val contentConverter: KClass<out Converter<Any, Any>>,
    val `as`: KClass<*>,
    val keyAs: KClass<*>,
    val contentAs: KClass<*>,
)
