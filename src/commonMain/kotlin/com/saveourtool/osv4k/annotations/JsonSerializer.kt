package com.saveourtool.osv4k.annotations

expect abstract class JsonSerializer<T>

expect abstract class JsonSerializerNone : JsonSerializer<Any>