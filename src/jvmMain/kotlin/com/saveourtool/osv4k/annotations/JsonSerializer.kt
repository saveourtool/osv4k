package com.saveourtool.osv4k.annotations

actual typealias JsonSerializer<T> = com.fasterxml.jackson.databind.JsonSerializer<T>

actual typealias JsonSerializerNone = com.fasterxml.jackson.databind.JsonSerializer.None