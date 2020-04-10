package org.reploop.parser.json.path;

import org.stringtemplate.v4.ST;

import java.util.List;
import java.util.stream.Collectors;

public class Json2Bean {
    private boolean isArrayType(List<TreeNode> nodes) {
        return isArrayType(nodes.get(0));
    }

    private boolean isArrayType(TreeNode node) {
        String name = node.getName();
        return name.startsWith("[") && name.endsWith("]");
    }

    public String execute(TreeNode parent, List<TreeNode> nodes) {
        if (parent.isLeaf()) {
            return parent.getType().toString();
        } else {
            if (isArrayType(nodes)) {
                List<TreeNode> children = nodes.stream().flatMap(TreeNode::children).collect(Collectors.toList());
                String type;
                if (children.isEmpty()) {
                    // List<Object>;
                    type = "Object";
                } else {
                    // List<Type>;
                    type = execute(parent, children);
                }
                return "List<" + type + ">";
            } else {
                ST st = new ST("public class <name> { }");
                st.render();
                String className = "public class " + parent.getName();
                for (TreeNode node : nodes) {
                    String type = execute(node, node.getChildren());
                    System.out.printf("private %s %s;%n", type, node.getName());
                }
            }
        }
        return "";
    }

    public String execute(TreeNode root) {
        return execute(root, root.getChildren());
    }

    public String execute0(TreeNode root) {
        String name = root.getName();
        if (!root.isLeaf()) {
            List<TreeNode> children = root.getChildren();
            if (isArrayType(children)) {
                List<TreeNode> elements = children.stream()
                    .flatMap(TreeNode::children)
                    .collect(Collectors.toList());
                if (elements.isEmpty()) {
                    // Object
                } else {
                    // class
                    for (TreeNode element : elements) {
                        String type = execute(element);
                    }
                }
            }

        } else {
            return "";
        }
        return name;
    }
}
