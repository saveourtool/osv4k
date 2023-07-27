@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

/**
 * @property value
 * @property content
 * @property valueFilter
 * @property contentFilter
 */
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
