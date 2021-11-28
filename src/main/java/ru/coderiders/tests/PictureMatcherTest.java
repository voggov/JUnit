package ru.coderiders.tests;

import org.junit.jupiter.api.Test;
import ru.coderiders.matcher.PictureMatcher;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PictureMatcherTest {
    @Test
    void getExtensions() {
        PictureMatcher pictureMatcher = new PictureMatcher();
        Set<String> extensions = pictureMatcher.getExtensions();
        assertNotNull(extensions);
        assertEquals(3, extensions.size());
        assertTrue(extensions.contains(".png"));
        assertTrue(extensions.contains(".jpg"));
        assertTrue(extensions.contains(".jpeg"));
    }


}