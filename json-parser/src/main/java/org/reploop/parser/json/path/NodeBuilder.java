package org.reploop.parser.json.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NodeBuilder {
    private TreeNode parent;
    private String name;
    private String type;
    private List<TreeNode> children;

    public NodeBuilder parent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    public NodeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public NodeBuilder type(String type) {
        this.type = type;
        return this;
    }

    public NodeBuilder clear() {
        if (null != children) {
            children.clear();
        }
        return this;
    }

    public NodeBuilder children(List<TreeNode> elements) {
        if (null != elements) {
            if (null == children) {
                children = new ArrayList<>();
            }
            elements.stream()
                .filter(Objects::nonNull)
                .forEach(treeNode -> children.add(treeNode));
        }
        return this;
    }

    public NodeBuilder from(TreeNode node) {
        return name(node.getName()).type(node.getType()).parent(node.getParent()).children(node.getChildren());
    }

    public NodeBuilder child(TreeNode child) {
        return children(Collections.singletonList(child));
    }

    public TreeNode build() {
        return new TreeNode(parent, name, type, children);
    }
}
