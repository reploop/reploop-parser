package org.reploop.parser.thrift.tree;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Thrift program. A thrift file will finally be parsed to this program.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 14
 */
public class ThriftProgram extends Node {

	Path file;

	List<String> comments;

	List<Header> headers;

	List<Entity> entities;

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitProgram(this, context);
	}

	public Path getFile() {
		return file;
	}

	public void setFile(Path file) {
		this.file = file;
	}

	public ThriftProgram(List<Header> headers, List<Entity> entities) {
		this(Collections.emptyList(), headers, entities);
	}

	public ThriftProgram(List<String> comments, List<Header> headers, List<Entity> entities) {
		this.file = file;
		this.comments = comments;
		this.headers = headers;
		this.entities = entities;
	}

	public List<String> getComments() {
		return comments;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ThriftProgram that = (ThriftProgram) o;
		return Objects.equals(file, that.file) && Objects.equals(headers, that.headers)
				&& Objects.equals(entities, that.entities);
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, headers, entities);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("entities", entities)
			.append("file", file)
			.append("headers", headers)
			.toString();
	}

}
