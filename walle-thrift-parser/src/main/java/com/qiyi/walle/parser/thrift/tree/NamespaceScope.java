package com.qiyi.walle.parser.thrift.tree;

import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

import java.util.EnumSet;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
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
        final StringBuilder sb = new StringBuilder("NamespaceScope{");
        sb.append("scopes=").append(scopes);
        sb.append('}');
        return sb.toString();
    }
}
