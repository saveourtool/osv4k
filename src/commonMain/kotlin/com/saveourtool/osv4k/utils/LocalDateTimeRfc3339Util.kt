/**
 * Utils method for [kotlinx.datetime.LocalDateTime]
 */

package com.saveourtool.osv4k.utils

import kotlinx.datetime.LocalDateTime

/**
 * @return [String] in RFC339 format
 */
internal fun LocalDateTime.toRfc339String(): String = "${this}Z"

/**
 * @param value
 * @return [LocalDateTime]
 */
internal fun fromRfc339String(value: String): LocalDateTime {
    require(value.endsWith("z", ignoreCase = true)) {
        "Support only RFC339 with 'Z' at the end"
    }
    return LocalDateTime.parse(value.replace("[t_ ]".toRegex(), "T").replace("[zZ]".toRegex(), ""))
}
