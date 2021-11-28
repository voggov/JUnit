package ru.coderiders.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.coderiders.matcher.FileMatcher;
import ru.coderiders.matcher.PictureMatcher;
import ru.coderiders.scanner.DirectoryScanner;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class DirectoryScannerTest {

    Path directory;
    FileMatcher matcher;

    @BeforeEach
    void init() {
        directory = mock(Path.class);
        matcher = mock(PictureMatcher.class);
    }

    @Test
    public void scanCalls() {
        var directory = Path.of("just-targ");
        var matcher = new PictureMatcher();
        DirectoryScanner dir = spy(new DirectoryScanner(directory, matcher, true));
        var val = dir.scan();
        assertEquals(val.size(),2);

    }


    @Test
    void scanThrowIllegalStateException() {
        DirectoryScanner directoryScanner = new DirectoryScanner(directory, matcher, true);
        File file = spy(new File("just-targ"));
        when(directory.toFile()).thenReturn(file);
        IllegalStateException exception = assertThrows(IllegalStateException.class, (Executable) directoryScanner::scan);
    }
}