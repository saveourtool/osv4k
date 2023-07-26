package com.saveourtool.osv4k

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.intellij.lang.annotations.Language
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

object OsvSchemaJacksonTestUtil {
    private val objectMapper = ObjectMapper()
        .registerModule(JavaTimeModule())
        .registerKotlinModule()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    private val prettyWriter = objectMapper.writerWithDefaultPrettyPrinter()
        .with(DefaultPrettyPrinter().withoutSpacesInObjectEntries())

    fun doEncodeDecodeAndCompare(
        @Language("JSON") originalContent: String,
    ) {
        val result = assertNotNull(
            objectMapper.readValue(originalContent, OsvSchema::class.java),
        )
        assertEquals(originalContent, prettyWriter.writeValueAsString(result))
    }
}