package org.reploop.translator.json;

import com.google.common.base.CaseFormat;
import org.reploop.translator.json.util.TreeNode;
import org.reploop.translator.json.util.WordTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Character.*;
import static java.text.CharacterIterator.DONE;
import static org.reploop.translator.json.util.WordTree.DOLLAR;

public class NameFormat {

    public static final char UNDER_SCORE = '_';
    public static final String UNDER_SCORE_TEXT = String.valueOf(UNDER_SCORE);
    private static final WordTree wordTree = new WordTree();

    private boolean isUpperCase(char c) {
        return isAlphabetic(c) && Character.isUpperCase(c);
    }

    private String newWord(StringBuilder sb) {
        String word = sb.toString().toLowerCase();
        sb.setLength(0);
        return word;
    }

    private boolean isNonNumberAndAlphabetic(char c) {
        return !isAlphabetic(c) && !isDigit(c);
    }

    public String format(String org, CaseFormat to) {
        List<String> words = wordTree.words(split(org));
        String lu = String.join(UNDER_SCORE_TEXT, words);
        return CaseFormat.LOWER_UNDERSCORE.to(to, lu);

    }

    public String format(String org) {
        return format(org, CaseFormat.LOWER_UNDERSCORE);
    }

    private void newWordThenReset(List<String> words, StringBuilder sb) {
        String word;
        if (!(word = newWord(sb)).isEmpty()) {
            words.add(word);
        }
    }

    public List<String> split(String org) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringCharacterIterator sci = new StringCharacterIterator(org);
        char prev = MIN_VALUE;
        for (char c = sci.first(); c != DONE; prev = c, c = sci.next()) {
            // discard the sep like under score, and add the word
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
