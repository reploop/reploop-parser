package org.reploop.translator.json;

import com.google.common.base.CaseFormat;
import org.reploop.parser.QualifiedName;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

public class NameFormat {

    public static final char UNDER_SCORE = '_';
    public static final String UNDER_SCORE_TEXT = String.valueOf(UNDER_SCORE);

    private boolean isUpperCase(char c) {
        return isAlphabetic(c) && Character.isUpperCase(c);
    }

    private String newWord(StringBuilder sb) {
        String word = sb.toString();
        sb.setLength(0);
        return word;
    }

    private boolean isNumberOrAlphabetic(char c) {
        return isAlphabetic(c) || isDigit(c);
    }

    public String format(String org, CaseFormat to) {
        Stream<String> words = split(org);
        String lu = words.collect(Collectors.joining(UNDER_SCORE_TEXT));
        return CaseFormat.LOWER_UNDERSCORE.to(to, lu);

    }

    public String format(String org) {
        return format(org, CaseFormat.LOWER_UNDERSCORE);
    }

    public Stream<String> split(String org) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringCharacterIterator sci = new StringCharacterIterator(org);
        char prev = Character.MIN_VALUE;
        for (char c = sci.first(); c != CharacterIterator.DONE; prev = c, c = sci.next()) {
            // discard the sep like under score, and add the word
            if (!isNumberOrAlphabetic(c)) {
                words.add(newWord(sb));
                continue;
            }
            // AndIsTime2Go9
            if (!isUpperCase(prev) && isUpperCase(c)) {
                words.add(newWord(sb));
            }
            sb.append(c);
        }
        words.add(newWord(sb));

        return words.stream()
            .map(String::toLowerCase)
            .filter(s -> !s.isEmpty());
    }




}
