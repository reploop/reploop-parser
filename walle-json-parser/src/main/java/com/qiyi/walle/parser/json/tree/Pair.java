package com.qiyi.walle.parser.json.tree;

import com.google.common.base.MoreObjects;

import com.qiyi.walle.parser.json.AstVisitor;
import com.qiyi.walle.parser.json.Node;

import java.lang.*;
import java.lang.Object;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-14 20
 */
public class Pair extends Node implements Comparable<Pair> {
    private String key;
    private Value value;

    public Pair(String key, Value value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitPair(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("value", value)
                .toString();
    }

    @Override
    public int compareTo(Pair o) {
        return key.compareTo(o.getKey());
    }
}
