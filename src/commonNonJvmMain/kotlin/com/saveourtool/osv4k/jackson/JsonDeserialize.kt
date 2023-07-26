package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

actual annotation class JsonDeserialize(
    actual val using: KClass<out JsonDeserializer<out Any>>,
    actual val contentUsing: KClass<out JsonDeserializer<out Any>>,
    actual val keyUsing: KClass<out KeyDeserializer>,
    actual val builder: KClass<*>,
    actual val converter: KClass<out Converter<Any, Any>>,
    actual val contentConverter: KClass<out Converter<Any, Any>>,
    actual val `as`: KClass<*>,
    actual val keyAs: KClass<*>,
    actual val contentAs: KClass<*>,
)