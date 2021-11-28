package ru.coderiders.scanner;

import ru.coderiders.matcher.FileMatcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class DirectoryScanner {

    private final Path directory;
    private final FileMatcher matcher;
    private final boolean deepMode;

    public DirectoryScanner(Path directory, FileMatcher matcher, boolean deepMode) {
        this.directory = directory;
        this.matcher = matcher;
        this.deepMode = deepMode;
    }

    public List<Path> scan() {
        try {
            var targetPath = directory.toFile();
            if (!targetPath.exists()) {
                throw new IllegalArgumentException("Directory is not exists: " + directory);
            }
            if (targetPath.isFile()) {
                throw new IllegalArgumentException("Argument is not directory: " + directory);
            }
            return scanDir(directory.toFile());
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new IllegalStateException(e);
        }
    }

    List<Path> scanDir(File target) {
        var result = new LinkedList<Path>();
        if (target.isFile()) {
            if (matcher.match(target)) {
                result.add(target.toPath());
            }
        } else if (deepMode) {
            for (File file : target.listFiles()) {
                result.addAll(scanDir(file));
            }
        } else {
            for (File file : target.listFiles()) {
                if (matcher.match(file)) {
                    result.add(file.toPath());
                }
            }
        }
        return result;
    }
}
