package org.reploop.parser.json.tree;

import java.util.Objects;

public class Infinity extends Number {

	private final int sign;

	public Infinity() {
		this(-1);
	}

	public Infinity(int sign) {
		this.sign = sign;
	}

	@Override
	public int hashCode() {
		return Objects.hash(toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Infinity) {
			return Objects.equals(toString(), obj.toString());
		}
		return false;
	}

	@Override
	public String toString() {
		String s = "+";
		switch (sign) {
			case 1:
				s = "+";
				break;
			case -1:
				s = "-";
				break;
		}
		return s + "Infinity";
	}

}
