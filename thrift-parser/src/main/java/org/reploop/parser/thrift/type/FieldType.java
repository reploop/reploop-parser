package org.reploop.parser.thrift.type;

import com.qiyi.walle.parser.thrift.Node;
import com.qiyi.walle.parser.QualifiedName;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 10
 */
public abstract class FieldType extends Node {
    protected final QualifiedName name;

    public FieldType(String name) {
        this(QualifiedName.of(name));
    }

    public FieldType(QualifiedName name) {
        this.name = name;
    }

    public QualifiedName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldType fieldType = (FieldType) o;
        return Objects.equals(name, fieldType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FieldType{" +
                "name='" + name + '\'' +
                '}';
    }
}
