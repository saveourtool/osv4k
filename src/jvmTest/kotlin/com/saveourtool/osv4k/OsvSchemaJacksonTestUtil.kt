package com.saveourtool.osv4k

import com.fasterxml.jackson.databind.ObjectMapper
import org.intellij.lang.annotations.Language
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object OsvSchemaJacksonTestUtil {
    private val objectMapper = ObjectMapper()

    private val prettyWriter = objectMapper.writerWithDefaultPrettyPrinter()

    fun doEncodeDecodeAndCompare(
        @Language("JSON") originalContent: String,
    ) {
        val result = assertNotNull(
            objectMapper.readValue(originalContent, OsvSchema::class.java),
        )
        compareJsonContent(originalContent, prettyWriter.writeValueAsString(result))

        OsvSchemaJacksonJavaTestUtil.doEncodeDecodeAndCompare(originalContent)
        OsvSchemaJavaTestUtil.doEncodeDecodeAndCompare(originalContent)
    }

    private fun compareJsonContent(
        contentExpected: String,
        contentActual: String,
    ) {
        assertEquals(objectMapper.readTree(contentExpected), objectMapper.readTree(contentActual))
    }
}