package org.reploop.parser.protobuf.generator;

import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;

/**
 * Protobuf Schema AST visitor.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-09 11
 */
public abstract class ProtobufAstVisitor<R, C> extends AstVisitor<R, C> {

	@Override
	public R visitNode(Node node, C context) {
		return null;
	}

}
