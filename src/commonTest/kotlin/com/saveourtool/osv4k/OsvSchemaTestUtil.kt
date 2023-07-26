package com.saveourtool.osv4k

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object OsvSchemaTestUtil {
    @OptIn(ExperimentalSerializationApi::class)
    private val prettyJson = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    fun doEncodeDecodeAndCompare(
        originalContent: String,
    ) {
        val result = assertNotNull(
            decode(originalContent)
        )
        assertEquals(originalContent, encode(result))
    }

    fun decode(content: String): RawOsvSchema = Json.decodeFromString(content)
    fun encode(value: RawOsvSchema): String = prettyJson.encodeToString(value)
}