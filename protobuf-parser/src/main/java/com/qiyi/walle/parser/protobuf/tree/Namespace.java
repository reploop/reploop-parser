package com.qiyi.walle.parser.protobuf.tree;

import com.qiyi.walle.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * Protobuf package.
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 11
 */
public class Namespace extends Header {
    String name;

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNamespace(this, context);
    }

    public Namespace(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Namespace namespace = (Namespace) o;
        return Objects.equals(name, namespace.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Namespace{" +
                "name='" + name + '\'' +
                '}';
    }
}
