@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE")

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
actual annotation class JsonSerialize(
    actual val using: KClass<out JsonSerializer<out Any>>,
    actual val contentUsing: KClass<out JsonSerializer<out Any>>,
    actual val keyUsing: KClass<out JsonSerializer<out Any>>,
    actual val nullsUsing: KClass<out JsonSerializer<out Any>>,
    actual val `as`: KClass<*>,
    actual val keyAs: KClass<*>,
    actual val contentAs: KClass<*>,
    actual val typing: JsonSerializeTyping,
    actual val converter: KClass<out Converter<Any, Any>>,
    actual val contentConverter: KClass<out Converter<Any, Any>>,
    actual val include: JsonSerializeInclusion,
)
actual enum class JsonSerializeTyping {
    DEFAULT_TYPING,
    ;
}
actual enum class JsonSerializeInclusion {
    DEFAULT_INCLUSION,
    ;
}
