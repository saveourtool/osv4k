@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE", "MISSING_KDOC_TOP_LEVEL")

package com.saveourtool.osv4k.jackson

/**
 * @property mode
 */
expect annotation class JsonCreator(
    val mode: JsonCreatorMode,
)
expect enum class JsonCreatorMode {
    DEFAULT,
    PROPERTIES,
    ;
}
