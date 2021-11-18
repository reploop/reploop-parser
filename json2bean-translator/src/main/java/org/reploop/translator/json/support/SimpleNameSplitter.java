package org.reploop.translator.json.support;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.MIN_VALUE;
import static java.lang.Character.isDigit;
import static java.text.CharacterIterator.DONE;
import static org.reploop.translator.json.util.WordTree.DOLLAR;

public class SimpleNameSplitter implements NameSplitter {
    @Override
    public List<String> split(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringCharacterIterator sci = new StringCharacterIterator(text);
        char prev = MIN_VALUE;
        for (char c = sci.first(); c != DONE; prev = c, c = sci.next()) {
            // discard the sep like underscore, and add the word
            if (isNonNumberAndAlphabetic(c)) {
                newWordThenReset(words, sb);
                continue;
            }
            // _39ele;
            if (isNonNumberAndAlphabetic(prev) && isDigit(c) && words.size() == 0) {
                sb.append(DOLLAR);
            }
            // AndIsTime2Go9
            if (!isUpperCase(prev) && isUpperCase(c)) {
                newWordThenReset(words, sb);
            }
            sb.append(c);
        }
        newWordThenReset(words, sb);
        return words;
    }
}
