package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 17
 */
public class VoidType extends FunctionType {

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitVoidType(this, context);
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public String toString() {
		return "void";
	}

}
