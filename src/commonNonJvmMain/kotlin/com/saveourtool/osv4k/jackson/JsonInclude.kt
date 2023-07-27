@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE")

package com.saveourtool.osv4k.jackson

import kotlin.reflect.KClass

/**
 * @property value
 * @property content
 * @property valueFilter
 * @property contentFilter
 */
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
