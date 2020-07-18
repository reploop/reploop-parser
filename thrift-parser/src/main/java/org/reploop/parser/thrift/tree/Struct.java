package org.reploop.parser.thrift.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;

import java.util.Collections;
import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Struct extends Entity {
    private List<Field> fields;


    public Struct(List<String> comments, QualifiedName name, List<Field> fields) {
        super(name, comments);
        this.fields = fields;
    }

    public Struct(String name, List<String> comments, List<Field> fields) {
        super(name, comments);
        this.fields = fields;
    }

    public Struct(String name, List<Field> fields) {
        this(name, Collections.emptyList(), fields);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStruct(this, context);
    }


    public List<Field> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "fields=" + fields +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
