@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "GENERIC_NAME")

package com.saveourtool.osv4k.jackson

actual interface Converter<IN, OUT>
actual abstract class ConverterNone : Converter<Any, Any>
