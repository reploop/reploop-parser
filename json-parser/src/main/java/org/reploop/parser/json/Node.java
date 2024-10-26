package org.reploop.parser.json;

/**
 * Root json element node.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-10-14 20
 */
public abstract class Node {

	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitNode(this, context);
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();

}
