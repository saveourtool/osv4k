package com.saveourtool.osv4k.annotations

actual annotation class JsonProperty actual constructor(
    actual val value: String,
    actual val namespace: String,
    actual val required: Boolean,
    actual val index: Int,
    actual val defaultValue: String,
    actual val access: JsonPropertyAccess
)

actual enum class JsonPropertyAccess {
    AUTO,
    ;
}
