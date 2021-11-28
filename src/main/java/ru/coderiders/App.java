package ru.coderiders;

import ru.coderiders.matcher.PictureMatcher;
import ru.coderiders.scanner.DirectoryScanner;

import java.nio.file.Path;

public class App {

    public static void main(String[] args) {
        var directory = Path.of("just-targ");
        var matcher = new PictureMatcher();
        var scanner = new DirectoryScanner(directory, matcher, true);
        var result = scanner.scan();
        System.out.println("Matched files count: " + result.size());
    }

}
