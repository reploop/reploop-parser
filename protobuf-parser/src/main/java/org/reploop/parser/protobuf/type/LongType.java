package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class LongType extends FieldType implements IntegerType {

	public LongType() {
		super("Long");
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitLongType(this, context);
	}

	@Override
	public int bits() {
		return 64;
	}

}
