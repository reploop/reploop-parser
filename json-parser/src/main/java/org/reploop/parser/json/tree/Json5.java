package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.Node;

import java.util.Objects;

import static java.util.Objects.isNull;

public class Json5 extends Node {

	private Value value;

	public Json5() {
	}

	public Json5(Value value) {
		this.value = value;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Json5) {
			return Objects.equals(this.getValue(), ((Json5) obj).getValue());
		}
		return false;
	}

	@Override
	public String toString() {
		return isNull(value) ? "" : value.toString();
	}

}
