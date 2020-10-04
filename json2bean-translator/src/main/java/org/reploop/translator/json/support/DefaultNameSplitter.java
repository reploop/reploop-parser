package org.reploop.translator.json.support;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.MIN_VALUE;
import static java.lang.Character.isDigit;
import static org.reploop.translator.json.util.WordTree.DOLLAR;

public class DefaultNameSplitter implements NameSplitter {
    @Override
    public List<String> split(String org) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int len = org.length();
        char curr;
        char prev = MIN_VALUE;
        for (int i = 0; i < len; prev = curr, i++) {
            curr = org.charAt(i);
            // discard the sep like under score, and add the word
            if (isNonNumberAndAlphabetic(curr)) {
                newWordThenReset(words, sb);
                continue;
            }
            // underscore starts,  e.g. _39ele
            if (isNonNumberAndAlphabetic(prev) && isDigit(curr) && words.size() == 0) {
                sb.append(DOLLAR);
            }

            boolean pc = isLowerCase(prev);
            boolean cc = isUpperCase(curr);
            boolean nc = cc;
            int nextIndex = i + 1;
            if (nextIndex < len) {
                char next = org.charAt(nextIndex);
                nc = isLowerCase(next);
            }
            // Before or after char has different case, consider as a new word. e.g. serverIPAddress
            if (pc && cc || cc && nc) {
                newWordThenReset(words, sb);
            }
            sb.append(curr);
        }
        newWordThenReset(words, sb);
        return words;
    }
}
