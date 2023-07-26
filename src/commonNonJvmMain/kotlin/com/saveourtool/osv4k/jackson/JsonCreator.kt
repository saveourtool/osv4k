package com.saveourtool.osv4k.jackson

actual annotation class JsonCreator(
    actual val mode: JsonCreatorMode,
)

actual enum class JsonCreatorMode {
    DEFAULT,
    ;
}