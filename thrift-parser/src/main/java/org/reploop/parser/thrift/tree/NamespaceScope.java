package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;

import java.util.EnumSet;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 16
 */
public class NamespaceScope extends Node {
    EnumSet<Lang> scopes;

    public NamespaceScope(EnumSet<Lang> scopes) {
        this.scopes = scopes;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNamespaceScope(this, context);
    }

    public EnumSet<Lang> getScopes() {
        return scopes;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public boolean support(Lang lang) {
        return null != scopes && scopes.contains(lang);
    }

    @Override
    public String toString() {
        String sb = "NamespaceScope{" + "scopes=" + scopes +
            '}';
        return sb;
    }
}
