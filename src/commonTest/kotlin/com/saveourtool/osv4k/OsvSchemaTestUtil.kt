package com.saveourtool.osv4k

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object OsvSchemaTestUtil {
    @OptIn(ExperimentalSerializationApi::class)
    private val prettyJson = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    /**
     * @param originalContent
     */
    fun doEncodeDecodeAndCompare(
        originalContent: String,
    ) {
        val result = assertNotNull(
            decode(originalContent)
        )
        assertEquals(originalContent, encode(result))
    }

    /**
     * @param content
     * @return decoded schema
     */
    fun decode(content: String): RawOsvSchema = Json.decodeFromString(content)

    /**
     * @param value
     * @return encoded schema
     */
    fun encode(value: RawOsvSchema): String = prettyJson.encodeToString(value)
}
