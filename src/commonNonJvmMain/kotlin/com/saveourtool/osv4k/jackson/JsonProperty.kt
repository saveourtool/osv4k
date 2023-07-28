@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE")

package com.saveourtool.osv4k.jackson

/**
 * @property value
 * @property namespace
 * @property required
 * @property index
 * @property defaultValue
 * @property access
 */
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
