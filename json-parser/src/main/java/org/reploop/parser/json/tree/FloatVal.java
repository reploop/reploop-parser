package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.Objects;

public class FloatVal extends Number {

	private final float value;

	public FloatVal(float value) {
		this.value = value;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitFloat(this, context);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FloatVal floatVal = (FloatVal) o;
		return Float.compare(floatVal.value, value) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
