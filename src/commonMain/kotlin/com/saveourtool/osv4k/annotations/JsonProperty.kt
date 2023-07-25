package com.saveourtool.osv4k.annotations

expect annotation class JsonProperty(
    val value: String,
    val namespace: String,
    val required: Boolean,
    val index: Int,
    val defaultValue: String,
    val access: Access,
)
expect enum class Access {
    AUTO,
    READ_ONLY,
    WRITE_ONLY,
    READ_WRITE,
    ;
}
