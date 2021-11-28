package ru.coderiders.tests;

import org.junit.jupiter.api.Test;
import ru.coderiders.matcher.PdfMatcher;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PdfMatcherTest {

    @Test
    void getExtensions() {
        PdfMatcher pdfMatcher = new PdfMatcher();
        Set<String> extensions = pdfMatcher.getExtensions();
        assertNotNull(extensions);
        assertEquals(1, extensions.size());
        assertTrue(extensions.contains(".pdf"));
    }


}