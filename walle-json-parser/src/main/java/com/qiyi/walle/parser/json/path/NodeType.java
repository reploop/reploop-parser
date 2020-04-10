package com.qiyi.walle.parser.json.path;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;

public class NodeType {
    private Set<Type> fqn;


    public NodeType add(Type type) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeType nodeType = (NodeType) o;
        return Objects.equals(fqn, nodeType.fqn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fqn);
    }

    @Override
    public String toString() {
        return "NodeType{" +
            "fqn=" + fqn +
            '}';
    }
}
