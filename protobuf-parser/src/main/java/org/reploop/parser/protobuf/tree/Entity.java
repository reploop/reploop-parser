package org.reploop.parser.protobuf.tree;


import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.Node;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-09-30 15
 */
public abstract class Entity extends Node {
    protected QualifiedName name;

    public Entity(QualifiedName name) {
        this.name = name;
    }

    public QualifiedName getName() {
        return name;
    }
}
