package com.saveourtool.osv4k.jackson

expect abstract class JsonSerializer<T>

expect abstract class JsonSerializerNone : JsonSerializer<Any>