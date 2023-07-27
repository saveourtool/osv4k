/**
 * Alias for `com.fasterxml.jackson.databind.util.Converter<IN, OUT>` and `com.fasterxml.jackson.databind.util.Converter.None`
 */

@file:Suppress(
    "HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE",
    "MISSING_KDOC_TOP_LEVEL",
    "GENERIC",
)

package com.saveourtool.osv4k.jackson

@Suppress("GENERIC_NAME")
expect interface Converter<IN, OUT>
expect abstract class ConverterNone : Converter<Any, Any>
