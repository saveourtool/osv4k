@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

/**
 * @property value
 * @property namespace
 * @property required
 * @property index
 * @property defaultValue
 * @property access
 */
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
