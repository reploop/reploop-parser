package org.reploop.translator.json.util;

import org.reploop.translator.json.support.NameFormat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.text.CharacterIterator.DONE;

/**
 * Given a string, find most number of words.
 */
public class WordTree implements WordSplit {
    public static final char DOLLAR = '$';
    private static final String WORD_FILE = "/words.txt";
    private TreeNode tree;

    private void load(String resource) {
        TreeNode root;
        try {
            URL u = NameFormat.class.getResource(resource);
            Set<String> ws = Files.lines(Path.of(u.toURI()))
                .map(String::toLowerCase)
                .filter(s -> s.length() > 1) // Skip single char
                .collect(Collectors.toUnmodifiableSet());
            root = buildTree(ws);
        } catch (Exception ignored) {
            root = null;
        }
        tree = root;
    }

    public WordTree() {
        this(WORD_FILE);
    }

    public WordTree(String resource) {
        load(resource);
    }


    private List<String> parseWords(TreeNode root, String org) {
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
                if (node.isEndOfAWord()) {
                    startRangeMap.computeIfAbsent(startIndex, key -> new ArrayList<>()).add(new Range(startIndex, index));
                }
            } else {
                // start a fresh new BFS.
                node = root;
                startIndex = -1;
                // If this is the first mismatch after a match, we should re-search from root.
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
            if (startIndex != start) {
                words.add(org.substring(startIndex, start));
            }
            Optional<Range> or = entry.getValue().stream().max(Range::compareTo);
            if (or.isPresent()) {
                Range range = or.get();
                startIndex = range.getEnd() + 1;
                words.add(org.substring(range.getStart(), startIndex));
            }
        }
        if (startIndex != org.length()) {
            words.add(org.substring(startIndex));
        }
        return words;
    }


    public List<String> parseWords(String... words) {
        return Stream.of(words).map(this::parseWords).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<String> parseWords(List<String> words) {
        return words.stream().map(this::parseWords).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<String> parseWords(String org) {
        return parseWords(tree, org);
    }

    public TreeNode buildTree(String... words) {
        TreeNode root = new TreeNode(DOLLAR);
        return addWords(root, words);
    }

    public TreeNode addWords(TreeNode root, String... words) {
        Stream.of(words).forEach(word -> addWord(root, word));
        return root;
    }

    private TreeNode buildTree(Set<String> words) {
        TreeNode root = new TreeNode(DOLLAR);
        return addWords(root, words);
    }

    private TreeNode addWords(TreeNode root, Set<String> words) {
        words.forEach(word -> addWord(root, word));
        return root;
    }

    private void addWord(TreeNode root, String word) {
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

    public void print() throws IOException {
        StringWriter sw = new StringWriter();
        print(tree, sw);
        System.out.println(sw);
    }

    public void print(TreeNode tree, Writer out) throws IOException {
        try (BufferedWriter writer = new BufferedWriter((out))) {
            writer.write("digraph tree {");
            writer.newLine();
            travel(tree, new Stack<>(), writer);
            writer.newLine();
            writer.write("}");
        }
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
}
