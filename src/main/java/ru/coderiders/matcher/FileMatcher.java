package ru.coderiders.matcher;

import java.io.File;
import java.util.Set;

public interface FileMatcher {

    /**
     * @return Множество расширений файлов, например ".mkv"
     */
    Set<String> getExtensions();

    /**
     * @return true, если аргумент существует и является файлом с расширением из списка
     *  ru.coderiders.matcher.FileMatcher#getExtensions(), иначе - false
     */
    default Boolean match(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("File not exists: " + file.getName());
        }
        if (file.isDirectory()) {
            return false;
        }
        for (String ext : getExtensions()) {
            if (file.getName().toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
}
