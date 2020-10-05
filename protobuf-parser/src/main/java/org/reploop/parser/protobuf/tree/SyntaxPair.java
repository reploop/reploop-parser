package org.reploop.parser.protobuf.tree;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * Special pair for syntax.
 */
public class SyntaxPair extends Pair {
    public SyntaxPair(String value) {
        this(new StringValue(value));
    }

    public SyntaxPair(Value value) {
        super("syntax", value);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitSyntaxPair(this, context);
    }
}
