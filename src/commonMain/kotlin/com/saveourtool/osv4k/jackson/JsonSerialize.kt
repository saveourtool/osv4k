package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

@Suppress("LongParameterList")
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
