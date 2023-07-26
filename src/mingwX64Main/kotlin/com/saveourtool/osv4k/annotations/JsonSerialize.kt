package com.saveourtool.osv4k.annotations

import kotlin.reflect.KClass


actual annotation class JsonSerialize(
    actual val using: KClass<out JsonSerializer<out Any>>,
    actual val contentUsing: KClass<out JsonSerializer<Any>>,

    actual val keyUsing: KClass<out JsonSerializer<Any>>,

    actual val nullsUsing: KClass<out JsonSerializer<Any>>,

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
actual class JavaVoid