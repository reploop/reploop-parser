package org.reploop.parser.protobuf.type;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.Node;

import java.util.Objects;

/**
 * Protobuf field type.
 *
 * @author George Cao(georgecao@outlook.com)
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
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FieldType fieldType = (FieldType) o;
		return Objects.equals(name, fieldType.name);
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
