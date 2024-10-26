package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class BoolType extends FieldType {

	public BoolType() {
		super("Boolean");
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitBoolType(this, context);
	}

}
