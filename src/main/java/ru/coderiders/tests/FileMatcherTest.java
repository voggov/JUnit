package ru.coderiders.tests;

import org.junit.jupiter.api.Test;
import ru.coderiders.matcher.FileMatcher;
import ru.coderiders.matcher.PdfMatcher;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileMatcherTest {
    @Test
    public void getExtensionCalls(){
        PdfMatcher dir = spy(new PdfMatcher());
        dir.getExtensions();
        verify(dir,times(1)).getExtensions();
    }
    @Test
    public void exceptionMatch(){
        PdfMatcher dir = spy(new PdfMatcher());
        IllegalArgumentException ex = new IllegalArgumentException();
        doThrow(ex).when(dir).match(null);

    }

}