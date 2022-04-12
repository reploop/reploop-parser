package org.reploop.translator.json.support;

import java.util.List;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public interface NameSplitter {

    default String newWord(StringBuilder sb) {
        String word = sb.toString().toLowerCase();
        sb.setLength(0);
        return word;
    }

    default void newWordThenReset(List<String> words, StringBuilder sb) {
        String word;
        if (!(word = newWord(sb)).isEmpty()) {
            words.add(word);
        }
    }

    default boolean isUpperCase(char c) {
        return isAlphabetic(c) && Character.isUpperCase(c);
    }

    default boolean isLowerCase(char c) {
        return isAlphabetic(c) && Character.isLowerCase(c);
    }

    default boolean isNonNumberAndAlphabetic(char c) {
        return !isAlphabetic(c) && !isDigit(c);
    }

    List<String> split(String text);
}
