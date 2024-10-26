package org.reploop.parser.thrift.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Enum extends Entity {

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitEnum(this, context);
	}

	private final List<EnumField> fields;

	public Enum(String name, List<EnumField> fields) {
		this(name, Collections.emptyList(), fields);
	}

	public Enum(String name, List<String> comments, List<EnumField> fields) {
		super(name, comments);
		this.fields = fields;
	}

	public Enum(List<String> comments, QualifiedName name, List<EnumField> fields) {
		super(name, comments);
		this.fields = fields;
	}

	public List<EnumField> getFields() {
		return fields;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Enum anEnum = (Enum) o;
		return Objects.equals(fields, anEnum.fields);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fields);
	}

	@Override
	public String toString() {
		return "Enum{" + "fields=" + fields + '}';
	}

}
