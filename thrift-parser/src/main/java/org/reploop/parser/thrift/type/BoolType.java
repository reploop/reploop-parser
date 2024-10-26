package org.reploop.parser.thrift.type;

import org.reploop.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class BoolType extends FieldType {

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitBoolType(this, context);
	}

	public BoolType() {
		super("boolean");
	}

}
