package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

public class IntVal extends Number {

	private final int value;

	public IntVal(int value) {
		this.value = value;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitInt(this, context);
	}

	@Override
	public int hashCode() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		IntVal intVal = (IntVal) o;
		return value == intVal.value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
