package org.reploop.translator.json.util;

import org.reploop.translator.json.support.NameFormat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordDict {
    public static final char DOLLAR = '$';
    private static final String WORD_FILE = "/words.txt";

    public static Set<String> load(String resource) throws IOException, URISyntaxException {
        return words(resource)
            .map(String::toLowerCase)
            .filter(s -> s.length() > 2) // Skip single char
            .collect(Collectors.toUnmodifiableSet());
    }

    public static Stream<String> words(String resource) throws URISyntaxException, IOException {
        URL u = NameFormat.class.getResource(resource);
        return Files.lines(Path.of(u.toURI()));
    }

    public static Stream<String> defaultWords() throws URISyntaxException, IOException {
        return words(WORD_FILE);
    }

    public static Set<String> loadDefaultWords() throws URISyntaxException, IOException {
        return load(WORD_FILE);
    }
}
