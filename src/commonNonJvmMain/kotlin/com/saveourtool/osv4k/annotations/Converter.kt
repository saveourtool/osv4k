package com.saveourtool.osv4k.annotations

actual interface Converter<IN, OUT>
actual abstract class ConverterNone : Converter<Any, Any>