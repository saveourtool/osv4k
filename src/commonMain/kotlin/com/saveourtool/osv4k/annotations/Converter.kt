package com.saveourtool.osv4k.annotations

expect interface Converter<IN, OUT>
expect abstract class ConverterNone : Converter<Any, Any>
