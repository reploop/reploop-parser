package org.reploop.translator.json.bean;

import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.Node;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.*;
import org.reploop.translator.json.type.JsonType;
import org.reploop.translator.json.type.ListType;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.strip;
import static org.reploop.translator.json.bean.Support.itemName;

public class JsonTypeTranslator extends AstVisitor<TreeNode, NodeBuilder> {

    @Override
    public TreeNode visitNode(Node node, NodeBuilder context) {
        return process(node, context);
    }

    public TreeNode visitJson(Json json) {
        return visitJson(json, null);
    }

    @Override
    public TreeNode visitJson(Json json, NodeBuilder context) {
        if (null == context) {
            context = TreeNode.newBuilder().parent(null).name("$");
        }
        return visitValue(json.getValue(), context);
    }

    @Override
    public TreeNode visitBool(Bool bool, NodeBuilder context) {
        return context.type(Boolean.class.getName()).build();
    }

    @Override
    public TreeNode visitFloat(FloatVal floatVal, NodeBuilder context) {
        return context.type(Float.class.getName()).build();
    }

    @Override
    public TreeNode visitByte(ByteVal bool, NodeBuilder context) {
        return context.type(Byte.class.getName()).build();
    }

    @Override
    public TreeNode visitShort(ShortVal bool, NodeBuilder context) {
        return context.type(Short.class.getName()).build();
    }

    @Override
    public TreeNode visitInt(IntVal bool, NodeBuilder context) {
        return context.type(Integer.class.getName()).build();
    }

    @Override
    public TreeNode visitDouble(DoubleVal value, NodeBuilder context) {
        return context.type(Double.class.getName()).build();
    }

    @Override
    public TreeNode visitObject(Entity value, NodeBuilder context) {
        List<Pair> pairs = value.getPairs();
        TreeNode parent = context.build();
        for (Pair pair : pairs) {
            TreeNode node = visitPair(pair, TreeNode.newBuilder().parent(parent));
            context.child(visitPair(pair, TreeNode.newBuilder()));
        }
        return parent;
    }

    @Override
    public TreeNode visitLong(LongVal value, NodeBuilder context) {
        return context.type(Long.class.getName()).build();
    }

    @Override
    public TreeNode visitNull(Null value, NodeBuilder context) {
        return context.type(Object.class.getName()).build();
    }

    @Override
    public TreeNode visitNumber(Number value, NodeBuilder context) {
        return process(value, context);
    }

    @Override
    public TreeNode visitPair(Pair pair, NodeBuilder context) {
        String key = strip(pair.getKey(), "\"");
        context.name(key);
        return visitValue(pair.getValue(), context);
    }

    @Override
    public TreeNode visitText(Text value, NodeBuilder context) {
        return context.type(String.class.getName()).build();
    }

    @Override
    public TreeNode visitValue(Value value, NodeBuilder context) {
        return process(value, context);
    }

    @Override
    public TreeNode visitArray(Array array, NodeBuilder context) {
        List<Value> values = array.getValues();
        for (int i = 0; i < values.size(); i++) {
            TreeNode node = visitValue(values.get(i), TreeNode.newBuilder().name(itemName(i)));
            if (node.isLeaf()) {
                JsonType type = node.getType();
                ListType listType = new ListType(type);
                context.type(listType);
                // Now clear all its children, this makes current array node's parent as leaf node.
                context.clear();
                break;
            }
            context.child(node);
        }
        return context.build();
    }
}
