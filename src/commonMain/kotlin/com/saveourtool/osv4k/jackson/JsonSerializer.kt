@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

expect abstract class JsonSerializer<T>

expect abstract class JsonSerializerNone : JsonSerializer<Any>
