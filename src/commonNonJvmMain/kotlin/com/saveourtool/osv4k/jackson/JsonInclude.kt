package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

actual annotation class JsonInclude(
    actual val value: JsonIncludeType,
    actual val content: JsonIncludeType,
    actual val valueFilter: KClass<*>,
    actual val contentFilter: KClass<*>,
)

actual enum class JsonIncludeType {
    ALWAYS,
    NON_NULL,
    ;
}