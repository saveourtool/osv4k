package com.saveourtool.osv4k.annotations

expect abstract class JsonDeserializer<T>

expect abstract class JsonDeserializerNone: JsonDeserializer<Any>