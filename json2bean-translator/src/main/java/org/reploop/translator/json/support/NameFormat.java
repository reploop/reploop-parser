package org.reploop.translator.json.support;

import com.google.common.base.CaseFormat;
import org.reploop.translator.json.util.WordTree;

import java.util.List;

public class NameFormat {
    public static final char UNDER_SCORE = '_';
    public static final String UNDER_SCORE_TEXT = String.valueOf(UNDER_SCORE);
    private static final WordTree wordTree = new WordTree();
    private final NameSplitter nameSplitter = new DefaultNameSplitter();

    public String format(String org, CaseFormat to) {
        List<String> words = wordTree.parseWords(split(org));
        String lu = String.join(UNDER_SCORE_TEXT, words);
        return CaseFormat.LOWER_UNDERSCORE.to(to, lu);

    }

    public String format(String org) {
        return format(org, CaseFormat.LOWER_UNDERSCORE);
    }

    public List<String> split(String org) {
        return nameSplitter.split(org);
    }
}
