package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * Say something?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 5/9/13 4:19 PM
 */
public class StringType extends FieldType {

	public StringType() {
		super("String");
	}

	@Override
	public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
		return visitor.visitStringType(this, context);
	}

}
