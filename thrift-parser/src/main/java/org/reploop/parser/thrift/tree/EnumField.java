package org.reploop.parser.thrift.tree;

import com.google.common.base.MoreObjects;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 10
 */
public class EnumField extends Node {

	private String name;

	private Optional<Integer> index;

	private List<String> comments;

	public EnumField(String name, Optional<Integer> index) {
		this(name, index, Collections.emptyList());
	}

	public EnumField(String name, Optional<Integer> index, List<String> comments) {
		this.name = name;
		this.index = index;
		this.comments = comments;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitEnumField(this, context);
	}

	public List<String> getComments() {
		return comments;
	}

	public String getName() {
		return name;
	}

	public Optional<Integer> getIndex() {
		return index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EnumField enumField = (EnumField) o;
		return Objects.equals(name, enumField.name) && Objects.equals(index, enumField.index);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, index);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("name", name)
			.add("index", index)
			.add("comments", comments)
			.toString();
	}

}
