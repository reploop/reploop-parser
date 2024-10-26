package org.reploop.parser.thrift.type;

import org.reploop.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class ByteType extends FieldType {

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitByteType(this, context);
	}

	public ByteType() {
		super("byte");
	}

}
