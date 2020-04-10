package org.reploop.parser.thrift.tree;


import org.reploop.parser.QualifiedName;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-12 14
 */
public class Import extends Header {
    private final QualifiedName name;

    public Import(QualifiedName name) {
        this.name = name;
    }

    public QualifiedName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Import anImport = (Import) o;
        return Objects.equals(name, anImport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Import{" +
                "name=" + name +
                '}';
    }
}
