package ru.coderiders.matcher;

import java.io.File;
import java.util.Set;

public class PictureMatcher implements FileMatcher {

    private final Set<String> pictureExtensions = Set.of(
            ".png", ".jpg", ".jpeg"
    );

    @Override
    public Set<String> getExtensions() {
        return pictureExtensions;
    }
}
