package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

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
