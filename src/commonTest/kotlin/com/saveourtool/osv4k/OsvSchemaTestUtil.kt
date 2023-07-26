package com.saveourtool.osv4k

import kotlinx.serialization.ExperimentalSerializationApi
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
            Json.decodeFromString<RawOsvSchema>(originalContent)
        )
        assertEquals(originalContent, prettyJson.encodeToString(result))
    }
}