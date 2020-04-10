package org.reploop.parser.thrift.tree;


import org.reploop.parser.QualifiedName;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-11 10
 */
public class StructValue extends Value {
    QualifiedName name;

    public StructValue(QualifiedName name) {
        this.name = name;
    }

    public QualifiedName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructValue that = (StructValue) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
