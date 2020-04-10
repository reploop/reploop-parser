package org.reploop.parser.json.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonTree {
    private TreeNode root;

    private boolean isArrayType(List<TreeNode> nodes) {
        return isArrayType(nodes.get(0));
    }

    private boolean isArrayType(TreeNode node) {
        String name = node.getName();
        return name.startsWith("[") && name.endsWith("]");
    }

    private TreeNode reduce(List<TreeNode> nodes) {
        if (nodes.size() == 1) {
            return nodes.get(0);
        } else {
            for (TreeNode node : nodes) {
                String type = node.getType();
                if (type.contains(Double.class.getSimpleName())) {
                    return node;
                } else if (type.contains(Float.class.getSimpleName())) {
                    return node;
                }
            }
        }
        throw new IllegalStateException();
    }

    public List<TreeNode> merge(Set<TreeNode> nodes) {
        Map<String, List<TreeNode>> group = nodes.stream().collect(Collectors.groupingBy(TreeNode::getName));
        List<TreeNode> merged = new ArrayList<>(nodes.size());
        for (Map.Entry<String, List<TreeNode>> entry : group.entrySet()) {
            merged.add(reduce(entry.getValue()));
        }
        return merged;
    }

    public TreeNode merge(TreeNode root) {
        NodeBuilder tb = TreeNode.newBuilder().from(root).clear();
        if (!root.isLeaf()) {
            List<TreeNode> children = root.getChildren();
            TreeNode firstChild = children.get(0);
            if (isArrayType(firstChild)) {
                Set<TreeNode> all = children.stream().flatMap(TreeNode::children).collect(Collectors.toSet());
                TreeNode child = TreeNode.newBuilder().from(firstChild).clear().children(merge(all)).build();
                return tb.child(merge(child)).build();
            } else {
                for (TreeNode node : children) {
                    tb.child(merge(node));
                }
            }
        }
        return tb.build();
    }
}
