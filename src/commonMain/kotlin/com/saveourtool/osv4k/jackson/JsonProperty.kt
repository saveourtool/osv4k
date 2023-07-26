package com.saveourtool.osv4k.jackson

expect annotation class JsonProperty(
    val value: String,
    val namespace: String,
    val required: Boolean,
    val index: Int,
    val defaultValue: String,
    val access: JsonPropertyAccess,
)
expect enum class JsonPropertyAccess {
    AUTO,
    ;
}
