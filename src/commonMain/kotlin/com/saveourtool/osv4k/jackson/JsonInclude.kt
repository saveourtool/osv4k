package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

expect annotation class JsonInclude(
    val value: JsonIncludeType,
    val content: JsonIncludeType,
    val valueFilter: KClass<*>,
    val contentFilter: KClass<*>,
)

expect enum class JsonIncludeType {
    ALWAYS,
    NON_NULL,
    ;
}
