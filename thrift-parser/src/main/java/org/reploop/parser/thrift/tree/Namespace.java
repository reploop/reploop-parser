package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Namespace extends Header {
    NamespaceScope scope;
    String namespace;

    public Namespace(NamespaceScope scope, String namespace) {
        this.scope = scope;
        this.namespace = namespace;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNamespace(this, context);
    }

    public String getNamespace() {
        return namespace;
    }

    public NamespaceScope getScope() {
        return scope;
    }

    @Override
    public String toString() {
        String sb = "Namespace{" + "scope=" + scope +
            ", namespace='" + namespace + '\'' +
            '}';
        return sb;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Namespace namespace1 = (Namespace) o;
        return Objects.equals(scope, namespace1.scope) &&
                Objects.equals(namespace, namespace1.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, namespace);
    }
}
