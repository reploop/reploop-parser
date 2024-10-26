package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.Node;

import java.util.Objects;

/**
 * Key-value pair.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-10-14 20
 */
public class Pair extends Node implements Comparable<Pair> {

	private final String key;

	private final Value value;

	public Pair(String key, Value value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitPair(this, context);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair = (Pair) o;
		return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return key + ": " + value;
	}

	@Override
	public int compareTo(Pair o) {
		return key.compareTo(o.getKey());
	}

}
