package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 10
 */
public class Service extends Node {

	private final QualifiedName name;

	private final List<Option> options;

	private final List<Function> functions;

	public Service(QualifiedName name, List<Option> options, List<Function> functions) {
		this.name = name;
		this.options = options;
		this.functions = functions;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitService(this, context);
	}

	public QualifiedName getName() {
		return name;
	}

	public List<Option> getOptions() {
		return options;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Service service = (Service) o;
		return Objects.equals(name, service.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		String sb = "Service{" + "name=" + name + ", options=" + options + ", functions=" + functions + '}';
		return sb;
	}

}
