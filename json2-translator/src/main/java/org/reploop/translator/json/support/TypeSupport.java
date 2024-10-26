package org.reploop.translator.json.support;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.NumberSpec;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.max;

public class TypeSupport {

	public static final String pattern = "[%d]";

	public static final Pattern LEGAL_JAVA_IDENTIFIER = Pattern.compile("[_$a-zA-Z][_$A-Za-z0-9]*");

	/**
	 * Find the most concrete field type. Usually its primitive types or user defined
	 * class.
	 * @param fieldType the type to probe
	 * @return the concrete type
	 */
	public static FieldType expandValueType(FieldType fieldType) {
		if (fieldType instanceof CollectionType) {
			return expandValueType(((CollectionType) fieldType).getElementType());
		}
		if (fieldType instanceof MapType) {
			return expandValueType(((MapType) fieldType).getValueType());
		}
		return fieldType;
	}

	/**
	 * If this filed type is user defined class
	 * @param type field type
	 * @return class qualified name if yes.
	 */
	public static Optional<QualifiedName> customTypeName(FieldType type) {
		if (type instanceof StructType) {
			return Optional.of(type.getName());
		}
		else if (type instanceof CollectionType) {
			return customTypeName(((CollectionType) type).getElementType());
		}
		else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			Optional<QualifiedName> key = customTypeName(mapType.getKeyType());
			Optional<QualifiedName> val = customTypeName(mapType.getValueType());
			if (key.isPresent()) {
				return Optional.empty();
			}
			return val;
		}
		return Optional.empty();
	}

	public static boolean isLegalIdentifier(String s) {
		return s != null && LEGAL_JAVA_IDENTIFIER.matcher(s).matches();
	}

	public static Optional<NumberSpec> fieldNumberSpec(Collection<Field> fields) {
		if (null != fields) {
			return typeNumberSpec(fields.stream().map(Field::getType).collect(Collectors.toList()));
		}
		return Optional.empty();
	}

	public static Optional<NumberSpec> typeNumberSpec(List<FieldType> types) {
		if (null != types) {
			boolean floating = false;
			int bits = 0;
			for (FieldType f : types) {
				FieldType fieldType = expandValueType(f);
				if (fieldType instanceof NumberType) {
					int n = ((NumberType) fieldType).bits();
					if (!floating && fieldType instanceof FloatingPointType) {
						floating = true;
					}
					bits = max(n, bits);
				}
			}
			if (bits > 0) {
				return Optional.of(new NumberSpec(floating, bits));
			}
		}
		return Optional.empty();
	}

	public static String itemName(int i) {
		return String.format(pattern, i);
	}

}
