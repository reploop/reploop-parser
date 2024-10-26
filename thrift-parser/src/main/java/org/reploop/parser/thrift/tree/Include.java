package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;

import java.util.Objects;

/**
 * Included files are looked up in the current directory and by searching relative to any
 * paths specified with the -I compiler flag.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Include extends Header {

	String file;

	public Include(String file) {
		this.file = file;
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitInclude(this, context);
	}

	public String getFile() {
		return file;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Include include = (Include) o;
		return Objects.equals(file, include.file);
	}

	@Override
	public int hashCode() {
		return Objects.hash(file);
	}

	@Override
	public String toString() {
		return "Include{" + "file='" + file + '\'' + '}';
	}

}
