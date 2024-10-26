package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Extend extends Entity {

	private final List<Field> fields;

	public Extend(QualifiedName name, List<Field> fields) {
		super(name);
		this.fields = fields;
	}

	public List<Field> getFields() {
		return fields;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitExtend(this, context);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Extend))
			return false;
		Extend extend = (Extend) o;
		return Objects.equals(name, extend.name) && Objects.equals(fields, extend.fields);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, fields);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Extend.class.getSimpleName() + "[", "]").add("name=" + name)
			.add("fields=" + fields)
			.toString();
	}

}
