package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 10
 */
public class Enumeration extends Entity {

	QualifiedName name;

	List<EnumField> fields;

	List<String> comments;

	public Enumeration(QualifiedName name, List<String> comments, List<EnumField> fields) {
		super(name);
		this.fields = fields;
		this.comments = comments;
	}

	public List<String> getComments() {
		return comments;
	}

	public List<EnumField> getFields() {
		return fields;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitEnumeration(this, context);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Enumeration that = (Enumeration) o;
		return Objects.equals(name, that.name) && Objects.equals(fields, that.fields);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, fields);
	}

	@Override
	public String toString() {
		return "Enumeration{" + "name='" + name + '\'' + ", fields=" + fields + '}';
	}

}
