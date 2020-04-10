package com.qiyi.walle.parser.thrift.tree;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.thrift.Node;

import java.util.Collections;
import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 10
 */
public abstract class Entity extends Node {
    protected final QualifiedName name;
    protected final List<String> comments;

    public Entity(String name, List<String> comments) {
        this(QualifiedName.of(name), comments);
    }

    public Entity(QualifiedName name, List<String> comments) {
        this.name = name;
        this.comments = comments;
    }

    public Entity(QualifiedName name) {
        this(name, Collections.emptyList());
    }

    public Entity(String name) {
        this(QualifiedName.of(name));
    }

    public QualifiedName getName() {
        return name;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name=" + name +
                ", comments=" + comments +
                "} ";
    }
}
