package org.reploop.translator.json;

import com.google.common.base.CaseFormat;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Character.*;
import static java.text.CharacterIterator.DONE;

public class NameFormat {

    public static final char UNDER_SCORE = '_';
    public static final char DOLLAR = '$';
    public static final String UNDER_SCORE_TEXT = String.valueOf(UNDER_SCORE);

    private boolean isUpperCase(char c) {
        return isAlphabetic(c) && Character.isUpperCase(c);
    }

    private String newWord(StringBuilder sb) {
        String word = sb.toString().toLowerCase();
        sb.setLength(0);
        return word;
    }

    private boolean isNumberOrAlphabetic(char c) {
        return isAlphabetic(c) || isDigit(c);
    }

    public String format(String org, CaseFormat to) {
        List<String> words = split(org);
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
            if (!isNumberOrAlphabetic(c)) {
                newWordThenReset(words, sb);
                continue;
            }
            // _39ele;
            if (!isNumberOrAlphabetic(prev) && isDigit(c) && words.size() == 0) {
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


    private static final Set<String> words;
    private static final String WORD_FILE = "/words.txt";
    private static final TreeNode tree;

    static {
        Set<String> ws;
        TreeNode root;
        try {
            URL u = NameFormat.class.getResource(WORD_FILE);
            ws = Files.lines(Path.of(u.toURI()))
                .map(String::toLowerCase)
                .collect(Collectors.toUnmodifiableSet());
            root = tree(ws);
        } catch (Exception ignored) {
            ws = Collections.emptySet();
            root = null;
        }
        tree = root;
        words = ws;
    }

    //
    private void sub(List<String> elements) {
        for (String w : elements) {
            if (words.contains(w)) {
                continue;
            }

            // thankyouandyou => thank you and you
        }
    }

    public void print() {
        print(tree);
    }

    public void print(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.getValue());
            List<TreeNode> children = tree.children;
            if (null != children) {
                for (TreeNode node : children) {
                    print(node);
                }
            }
        }
    }

    private static Optional<TreeNode> findChild(TreeNode parent, char c) {
        return find(parent.children, c);
    }

    private static Optional<TreeNode> find(List<TreeNode> children, char c) {
        if (null != children) {
            return children.stream().filter(tn -> tn.getValue() == c).findFirst();
        }
        return Optional.empty();
    }

    private static TreeNode tree(Set<String> words) {
        TreeNode root = new TreeNode();
        root.setValue(DOLLAR);
        for (String word : words) {
            StringCharacterIterator it = new StringCharacterIterator(word);
            TreeNode parent = root;
            TreeNode tn = null;
            char c = MIN_VALUE;
            for (c = it.first(); c != DONE; parent = tn, c = it.next()) {
                Optional<TreeNode> otn = findChild(parent, c);
                if (otn.isPresent()) {
                    tn = otn.get();
                    continue;
                }
                tn = new TreeNode();
                tn.setValue(c);
                parent.addChild(tn);
            }
            if (null != tn) {
                tn.setEndOfAWord(true);
            }
        }
        return root;
    }

    private static class TreeNode {
        private List<TreeNode> children;
        private Character value;
        private boolean endOfAWord;

        public boolean isEndOfAWord() {
            return endOfAWord;
        }

        public Character getValue() {
            return value;
        }

        public void setValue(Character value) {
            this.value = value;
        }

        public void setEndOfAWord(boolean endOfAWord) {
            this.endOfAWord = endOfAWord;
        }

        public TreeNode addChild(TreeNode c) {
            if (null == children) {
                children = new ArrayList<>();
            }
            children.add(c);
            return this;
        }


        @Override
        public String toString() {
            return "TreeNode{" +
                ", children=" + children +
                ", endOfAWord=" + endOfAWord +
                '}';
        }
    }
}
