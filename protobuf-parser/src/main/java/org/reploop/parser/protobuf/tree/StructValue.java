package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;

import java.util.Objects;

/**
 * Struct value.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 12
 */
public class StructValue extends Value {

	final QualifiedName name;

	public StructValue(String name) {
		this(QualifiedName.of(name));
	}

	public StructValue(QualifiedName name) {
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
		StructValue that = (StructValue) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "StructValue{" + "name='" + name + '\'' + '}';
	}

}
