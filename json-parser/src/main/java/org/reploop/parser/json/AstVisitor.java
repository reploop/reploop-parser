package org.reploop.parser.json;

import org.reploop.parser.ast.AbstractAstVisitor;
import org.reploop.parser.json.tree.Array;
import org.reploop.parser.json.tree.Bool;
import org.reploop.parser.json.tree.ByteVal;
import org.reploop.parser.json.tree.DoubleVal;
import org.reploop.parser.json.tree.Entity;
import org.reploop.parser.json.tree.FloatVal;
import org.reploop.parser.json.tree.IntVal;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.json.tree.LongVal;
import org.reploop.parser.json.tree.Null;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.Pair;
import org.reploop.parser.json.tree.ShortVal;
import org.reploop.parser.json.tree.Text;
import org.reploop.parser.json.tree.Value;

/**
 * JSON AST visitor.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-10-14 20
 */
public abstract class AstVisitor<R, C> extends AbstractAstVisitor<R, Node, C> {

    public abstract R visitNode(Node node, C context);

    public R process(Node node, C context) {
        return node.accept(this, context);
    }

    public R visitJson(Json json, C context) {
        return visitNode(json, context);
    }

    public R visitBool(Bool bool, C context) {
        return visitNode(bool, context);
    }

    public R visitFloat(FloatVal floatVal, C context) {
        return visitNode(floatVal, context);
    }

    public R visitByte(ByteVal bool, C context) {
        return visitNode(bool, context);
    }

    public R visitShort(ShortVal bool, C context) {
        return visitNode(bool, context);
    }

    public R visitInt(IntVal bool, C context) {
        return visitNode(bool, context);
    }

    public R visitDouble(DoubleVal value, C context) {
        return visitNode(value, context);
    }

    public R visitObject(Entity value, C context) {
        return visitNode(value, context);
    }

    public R visitLong(LongVal value, C context) {
        return visitNode(value, context);
    }

    public R visitNull(Null value, C context) {
        return visitNode(value, context);
    }

    public R visitNumber(Number value, C context) {
        return visitNode(value, context);
    }

    public R visitPair(Pair value, C context) {
        return visitNode(value, context);
    }

    public R visitText(Text value, C context) {
        return visitNode(value, context);
    }

    public R visitValue(Value value, C context) {
        return visitNode(value, context);
    }

    public R visitArray(Array array, C context) {
        return visitNode(array, context);
    }

}
