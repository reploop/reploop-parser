package org.reploop.translator.json.util;

import org.reploop.translator.json.support.NameFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.stream.Collectors;

public class WordDict {
    public static final char DOLLAR = '$';
    private static final String WORD_FILE = "/words.txt";

    public static Set<String> load(String resource) throws IOException, URISyntaxException {
        return words(resource).stream()
            .map(String::toLowerCase)
            .filter(s -> s.length() > 2) // Skip single char
            .collect(Collectors.toUnmodifiableSet());
    }

    public static Set<String> words(String resource) throws URISyntaxException, IOException {
        // Read file as stream, so we can read it from any classpath location including file system, jar etc.
        InputStream input = NameFormat.class.getResourceAsStream(resource);
        if (null == input) {
            throw new IOException("Cannot load resource " + resource);
        }
        try (InputStreamReader isr = new InputStreamReader(input); BufferedReader reader = new BufferedReader(isr)) {
            return reader.lines().collect(Collectors.toSet());
        }
    }

    public static Set<String> defaultWords() throws URISyntaxException, IOException {
        return words(WORD_FILE);
    }

    public static Set<String> loadDefaultWords() throws URISyntaxException, IOException {
        return load(WORD_FILE);
    }
}
