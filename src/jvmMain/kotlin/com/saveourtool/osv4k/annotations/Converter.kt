package com.saveourtool.osv4k.annotations

actual typealias Converter<IN, OUT> = com.fasterxml.jackson.databind.util.Converter<IN, OUT>

actual typealias ConverterNone = com.fasterxml.jackson.databind.util.Converter.None