package org.reploop.translator.json;

import com.google.common.base.CaseFormat;
import org.reploop.translator.json.util.Range;
import org.reploop.translator.json.util.TreeNode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .filter(s -> s.length() > 1)
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

    public List<String> words(String org) {
        return words(tree, org);
    }


    private List<String> words(TreeNode root, String org) {
        TreeNode parent = root;
        TreeNode node;
        int startIndex = -1;
        boolean prevMatch = false;
        Map<Integer, List<Range>> startRangeMap = new TreeMap<>();
        StringCharacterIterator it = new StringCharacterIterator(org);
        for (char c = it.first(); c != DONE; parent = node) {
            int index = it.getIndex();
            Optional<TreeNode> ont = parent.findChildByValue(c);
            if (ont.isPresent()) {
                prevMatch = true;
                node = ont.get();
                if (startIndex == -1) {
                    startIndex = index;
                }
                // Find a match -> [index, endIndex]
                if (!node.hasChild()) {
                    startRangeMap.computeIfAbsent(startIndex, key -> new ArrayList<>()).add(new Range(startIndex, index));
                }
            } else {
                // start a fresh new BFS.
                node = root;
                startIndex = -1;
                if (prevMatch) {
                    prevMatch = false;
                    continue;
                }
            }
            c = it.next();
        }
        List<String> words = new ArrayList<>();
        startIndex = 0;
        for (Map.Entry<Integer, List<Range>> entry : startRangeMap.entrySet()) {
            Integer start = entry.getKey();
            Range range = entry.getValue().stream().max(Range::compareTo).get();
            if (startIndex != start) {
                words.add(org.substring(startIndex, start));
            }
            startIndex = range.getEnd() + 1;
            words.add(org.substring(range.getStart(), startIndex));
        }
        return words;
    }

    public void print() throws IOException {
        System.out.println(print(tree));
    }


    public String print(TreeNode tree) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("/tmp/word.tree"))) {
            writer.write("digraph tree {");
            writer.newLine();
            travel(tree, new Stack<>(), writer);
            writer.newLine();
            writer.write("}");
        }
        return sb.toString();
    }

    public void travel(TreeNode tree, Stack<Character> stack, BufferedWriter writer) throws IOException {
        if (tree != null) {
            char c = tree.getValue();
            if (c != DOLLAR) {
                stack.push(tree.getValue());
            } else {
                stack.push('_');
            }
            List<TreeNode> children = tree.getChildren();
            if (null != children && children.size() > 0) {
                for (TreeNode node : children) {
                    travel(node, stack, writer);
                    stack.pop();
                }
            } else {
                String text = stack.stream().map(String::valueOf).collect(Collectors.joining("->", "", ";"));
                writer.write(text);
                writer.newLine();
            }
        }
    }

    public static TreeNode tree(String... words) {
        TreeNode root = new TreeNode(DOLLAR);
        for (String word : words) {
            word(root, word);
        }
        return root;
    }

    private static TreeNode tree(Set<String> words) {
        TreeNode root = new TreeNode(DOLLAR);
        words.forEach(word -> word(root, word));
        return root;
    }

    private static void word(TreeNode root, String word) {
        StringCharacterIterator it = new StringCharacterIterator(word);
        TreeNode parent = root;
        TreeNode tn = null;
        char c;
        for (c = it.first(); c != DONE; parent = tn, c = it.next()) {
            tn = parent.addIfChildAbsent(new TreeNode(c));
        }
        if (null != tn) {
            tn.setEndOfAWord(true);
        }
    }
}
