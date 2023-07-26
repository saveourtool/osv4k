package com.saveourtool.osv4k;

import org.intellij.lang.annotations.Language;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class OsvSchemaJavaTestUtil {

    @SuppressWarnings("rawtypes")
    static void doEncodeDecodeAndCompare(
        final @Language("JSON") String originalContent
    ) {
        final OsvSchema result = OsvSchemaTestUtil.INSTANCE.decode(originalContent);
        assertNotNull(result);
        assertEquals(originalContent, OsvSchemaTestUtil.INSTANCE.encode(result));
    }
}