package org.reploop.translator.json.util;

import java.util.*;

public class TreeNode {
    private final Map<Character, TreeNode> children = new TreeMap<>();
    private Character value;
    private boolean endOfAWord;

    public TreeNode(Character value) {
        this.value = value;
    }

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

    public TreeNode addIfChildAbsent(TreeNode c) {
        TreeNode tn = children.putIfAbsent(c.getValue(), c);
        return null != tn ? tn : c;
    }

    public boolean hasChild() {
        return children.size() > 0;
    }

    public List<TreeNode> getChildren() {
        return new ArrayList<>(children.values());
    }

    public Optional<TreeNode> findChildByValue(char val) {
        return Optional.ofNullable(children.get(val));
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "value=" + value +
            ", endOfAWord=" + endOfAWord +
            '}';
    }
}