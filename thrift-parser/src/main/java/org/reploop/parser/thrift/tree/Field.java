package org.reploop.parser.thrift.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;
import org.reploop.parser.thrift.type.FieldType;

import java.util.List;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Field extends Node {

	final Integer filedId;

	final boolean required;

	final List<String> comments;

	final QualifiedName name;

	final FieldType fieldType;

	final Optional<Value> value;

	public Field(List<String> comments, FieldType fieldType, Integer filedId, String name, boolean required) {
		this(comments, fieldType, filedId, QualifiedName.of(name), required);
	}

	public Field(List<String> comments, FieldType fieldType, Integer filedId, String name, boolean required,
			Optional<Value> value) {
		this(comments, fieldType, filedId, QualifiedName.of(name), required, value);
	}

	public Field(List<String> comments, FieldType fieldType, Integer filedId, QualifiedName name, boolean required) {
		this(comments, fieldType, filedId, name, required, Optional.empty());
	}

	public Field(List<String> comments, FieldType fieldType, Integer filedId, QualifiedName name, boolean required,
			Optional<Value> value) {
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
		String sb = "Field{" + "filedId=" + filedId + ", required=" + required + ", comments=" + comments + ", name='"
				+ name + '\'' + ", fieldType=" + fieldType + '}';
		return sb;
	}

}
