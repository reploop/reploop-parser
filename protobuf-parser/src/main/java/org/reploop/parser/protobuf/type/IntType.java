package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class IntType extends FieldType implements IntegerType {

	public IntType() {
		super("Integer");
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitIntType(this, context);
	}

	@Override
	public int bits() {
		return 32;
	}

}
