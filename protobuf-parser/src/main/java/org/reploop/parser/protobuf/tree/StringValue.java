package org.reploop.parser.protobuf.tree;

import org.reploop.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 12
 */
public class StringValue extends Value {

	String value;

	public StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitStringValue(this, context);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StringValue that = (StringValue) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "StringValue{" + "value='" + value + '\'' + '}';
	}

}
