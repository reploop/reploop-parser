package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.type.FieldType;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-09-28 19
 */
public class Function extends Node {

	private QualifiedName name;

	private FieldType requestType;

	private FieldType responseType;

	private List<Option> options;

	public Function(QualifiedName name, FieldType requestType, FieldType responseType, List<Option> options) {
		this.name = name;
		this.requestType = requestType;
		this.responseType = responseType;
		this.options = options;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitFunction(this, context);
	}

	public List<Option> getOptions() {
		return options;
	}

	public QualifiedName getName() {
		return name;
	}

	public FieldType getRequestType() {
		return requestType;
	}

	public FieldType getResponseType() {
		return responseType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Function function = (Function) o;
		return Objects.equals(name, function.name) && Objects.equals(requestType, function.requestType)
				&& Objects.equals(responseType, function.responseType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, requestType, responseType);
	}

	@Override
	public String toString() {
		String sb = "Function{" + "name=" + name + ", requestType=" + requestType + ", responseType=" + responseType
				+ '}';
		return sb;
	}

}
