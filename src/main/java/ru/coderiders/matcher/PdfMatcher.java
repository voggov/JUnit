package ru.coderiders.matcher;

import java.io.File;
import java.util.Set;

public class PdfMatcher implements FileMatcher{

    private final Set<String> pdfExtensions = Set.of(".pdf");

    @Override
    public Set<String> getExtensions() {
        return pdfExtensions;
    }
}
