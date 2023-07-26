package com.saveourtool.osv4k.jackson

expect annotation class JsonCreator(
    val mode: JsonCreatorMode,
)
expect enum class JsonCreatorMode {
    DEFAULT,
    PROPERTIES,
    ;
}