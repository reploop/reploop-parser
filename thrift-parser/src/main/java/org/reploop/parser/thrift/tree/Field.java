package org.reploop.parser.thrift.tree;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;
import com.qiyi.walle.parser.thrift.type.FieldType;

import java.util.List;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 00
 */
public class Field extends Node {
    Integer filedId;
    boolean required;
    List<String> comments;
    QualifiedName name;
    FieldType fieldType;
    Optional<Value> value;

    public Field(List<String> comments, FieldType fieldType, Integer filedId, String name, boolean required) {
        this(comments, fieldType, filedId, QualifiedName.of(name), required);
    }

    public Field(List<String> comments, FieldType fieldType, Integer filedId, String name, boolean required, Optional<Value> value) {
        this(comments, fieldType, filedId, QualifiedName.of(name), required, value);
    }

    public Field(List<String> comments, FieldType fieldType, Integer filedId, QualifiedName name, boolean required) {
        this(comments, fieldType, filedId, name, required, Optional.empty());
    }

    public Field(List<String> comments, FieldType fieldType, Integer filedId, QualifiedName name, boolean required, Optional<Value> value) {
        this.comments = comments;
        this.fieldType = fieldType;
        this.filedId = filedId;
        this.name = name;
        this.required = required;
        this.value = value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitField(this, context);
    }

    public List<String> getComments() {
        return comments;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public Integer getFiledId() {
        return filedId;
    }

    public QualifiedName getName() {
        return name;
    }

    public boolean isRequired() {
        return required;
    }

    public Optional<Value> getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Field{");
        sb.append("filedId=").append(filedId);
        sb.append(", required=").append(required);
        sb.append(", comments=").append(comments);
        sb.append(", name='").append(name).append('\'');
        sb.append(", fieldType=").append(fieldType);
        sb.append('}');
        return sb.toString();
    }
}
