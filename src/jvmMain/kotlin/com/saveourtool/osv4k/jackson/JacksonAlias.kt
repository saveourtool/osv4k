package com.saveourtool.osv4k.jackson


actual typealias Converter<IN, OUT> = com.fasterxml.jackson.databind.util.Converter<IN, OUT>
actual typealias ConverterNone = com.fasterxml.jackson.databind.util.Converter.None

actual typealias JsonDeserialize = com.fasterxml.jackson.databind.annotation.JsonDeserialize

actual typealias JsonDeserializer<T> = com.fasterxml.jackson.databind.JsonDeserializer<T>
actual typealias JsonDeserializerNone = com.fasterxml.jackson.databind.JsonDeserializer.None

actual typealias JsonProperty = com.fasterxml.jackson.annotation.JsonProperty
actual typealias JsonPropertyAccess = com.fasterxml.jackson.annotation.JsonProperty.Access

actual typealias JsonSerialize = com.fasterxml.jackson.databind.annotation.JsonSerialize

actual typealias JsonSerializeTyping = com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing
actual typealias JsonSerializeInclusion = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion

actual typealias JavaVoid = Void

actual typealias JsonSerializer<T> = com.fasterxml.jackson.databind.JsonSerializer<T>
actual typealias JsonSerializerNone = com.fasterxml.jackson.databind.JsonSerializer.None

actual typealias KeyDeserializer = com.fasterxml.jackson.databind.KeyDeserializer
actual typealias KeyDeserializerNone = com.fasterxml.jackson.databind.KeyDeserializer.None

actual typealias JsonInclude = com.fasterxml.jackson.annotation.JsonInclude
actual typealias JsonIncludeType = com.fasterxml.jackson.annotation.JsonInclude.Include

actual typealias JsonCreator = com.fasterxml.jackson.annotation.JsonCreator
actual typealias JsonCreatorMode = com.fasterxml.jackson.annotation.JsonCreator.Mode