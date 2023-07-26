package com.saveourtool.osv4k.jackson

expect interface Converter<IN, OUT>
expect abstract class ConverterNone : Converter<Any, Any>
