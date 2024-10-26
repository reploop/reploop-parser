package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 12
 */
public class FloatType extends FieldType implements FloatingPointType {

	public FloatType() {
		super("Float");
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitFloatType(this, context);
	}

	@Override
	public int bits() {
		return 32;
	}

}
