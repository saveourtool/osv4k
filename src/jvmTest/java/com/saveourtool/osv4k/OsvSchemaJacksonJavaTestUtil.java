package com.saveourtool.osv4k;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import org.intellij.lang.annotations.Language;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class OsvSchemaJacksonJavaTestUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new KotlinModule.Builder().build())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private static final ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter()
        .with(new DefaultPrettyPrinter().withoutSpacesInObjectEntries());

    @SuppressWarnings("rawtypes")
    static void doEncodeDecodeAndCompare(
        final @Language("JSON") String originalContent
    ) throws JsonProcessingException {
        final OsvSchema result = objectMapper.readValue(originalContent, OsvSchema.class);
        assertNotNull(result);
        compareJsonContent(originalContent, prettyWriter.writeValueAsString(result));
    }

    private static void compareJsonContent(
        final String contentExpected,
        final String contentActual
    ) throws JsonProcessingException {
        assertEquals(objectMapper.readTree(contentExpected), objectMapper.readTree(contentActual));
    }
}