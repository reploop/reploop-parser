package org.reploop.parser.protobuf.type;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public abstract class CollectionType extends FieldType {

	FieldType elementType;

	public CollectionType(FieldType elementType) {
		this("Collection", elementType);
	}

	public CollectionType(String name, FieldType elementType) {
		super(name);
		this.elementType = elementType;
	}

	public FieldType getElementType() {
		return elementType;
	}

	@Override
	public String toString() {
		return getName() + "<" + getElementType() + ">";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		CollectionType that = (CollectionType) o;
		return elementType.equals(that.elementType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), elementType);
	}

}
