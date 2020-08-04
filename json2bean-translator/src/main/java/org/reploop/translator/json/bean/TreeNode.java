package org.reploop.translator.json.bean;

import org.reploop.translator.json.type.JsonType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TreeNode {
    private final TreeNode parent;
    private final String name;
    private final JsonType type;
    private final List<TreeNode> children;

    public TreeNode(TreeNode parent, String name, JsonType type, List<TreeNode> children) {
        this.parent = parent;
        this.name = name;
        this.type = type;
        this.children = children;
    }

    public boolean hasValue() {
        return null != type;
    }

    public boolean isLeaf() {
        return null == children || children.size() == 0;
    }

    public boolean hasParent() {
        return null != parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public JsonType getType() {
        return type;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public Stream<TreeNode> children() {
        if (isLeaf()) {
            return Stream.empty();
        }
        return children.stream();
    }


    @Override
    public String toString() {
        return "Node{" +
            "parent=" + parent +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", children=" + children +
            '}';
    }

    public static NodeBuilder newBuilder() {
        return new NodeBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        return Objects.equals(parent, node.parent) &&
            Objects.equals(name, node.name) &&
            Objects.equals(type, node.type) &&
            Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name, type, children);
    }

}
