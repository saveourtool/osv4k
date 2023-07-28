@file:Suppress("HEADER_MISSING_IN_NON_SINGLE_CLASS_FILE")

package com.saveourtool.osv4k.jackson

/**
 * @property mode
 */
actual annotation class JsonCreator(
    actual val mode: JsonCreatorMode,
)

actual enum class JsonCreatorMode {
    DEFAULT,
    PROPERTIES,
    ;
}
