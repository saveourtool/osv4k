package com.saveourtool.osv4k.utils

import kotlinx.datetime.LocalDateTime

object LocalDateTimeRfc3339Util {
    internal fun toString(value: LocalDateTime): String = value.toString() + "Z"
    internal fun fromString(value: String): LocalDateTime {
        require(value.endsWith("z", ignoreCase = true)) {
            "Support only RFC339 with 'Z' at the end"
        }
        return LocalDateTime.parse(value.replace("[t_ ]".toRegex(), "T").replace("[zZ]".toRegex(), ""))
    }
}
