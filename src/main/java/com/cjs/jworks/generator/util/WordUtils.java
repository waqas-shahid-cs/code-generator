package com.cjs.jworks.generator.util;

public final class WordUtils extends org.apache.commons.lang.WordUtils {
    private WordUtils() {
    }

    public static String getCamelCase(final String str) {
        return initials(str).toLowerCase() + str.substring(1);
    }
}
