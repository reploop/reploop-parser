package org.reploop.parser.json.tree;

import com.google.common.base.MoreObjects;
import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.Node;


import java.lang.*;
import java.lang.Object;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-14 20
 */
public class Json extends Node {
    private Value value;

    public Json(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitJson(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Json json = (Json) o;
        return Objects.equals(value, json.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("value", value)
            .toString();
    }
}

