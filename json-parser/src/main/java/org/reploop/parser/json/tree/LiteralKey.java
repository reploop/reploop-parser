package org.reploop.parser.json.tree;

/**
 * True,false or null value.
 */
public class LiteralKey extends Key {
    private final Value value;

    public LiteralKey(Value value) {
        this.value = value;
    }
}
