@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

/**
 * @property using
 * @property contentUsing
 * @property keyUsing
 * @property nullsUsing
 * @property `as`
 * @property keyAs
 * @property contentAs
 * @property typing
 * @property converter
 * @property contentConverter
 * @property include
 */
@Suppress(
    "LongParameterList",
    "KDOC_NO_CONSTRUCTOR_PROPERTY",
    "BACKTICKS_PROHIBITED",
    "TYPE_ALIAS",
)
expect annotation class JsonSerialize(
    val using: KClass<out JsonSerializer<out Any>>,
    val contentUsing: KClass<out JsonSerializer<out Any>>,
    val keyUsing: KClass<out JsonSerializer<out Any>>,
    val nullsUsing: KClass<out JsonSerializer<out Any>>,
    val `as`: KClass<*>,
    val keyAs: KClass<*>,
    val contentAs: KClass<*>,
    val typing: JsonSerializeTyping,
    val converter: KClass<out Converter<Any, Any>>,
    val contentConverter: KClass<out Converter<Any, Any>>,
    val include: JsonSerializeInclusion,
)

expect enum class JsonSerializeTyping {
    DEFAULT_TYPING,
    ;
}
expect enum class JsonSerializeInclusion {
    DEFAULT_INCLUSION,
    ;
}
