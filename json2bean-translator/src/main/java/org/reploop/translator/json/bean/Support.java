package org.reploop.translator.json.bean;

import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.NumberSpec;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.max;

public class Support {
    public static final String pattern = "[%d]";
    public static final Pattern LEGAL_IDENTIFIER = Pattern.compile("[_$a-zA-Z][_$A-Za-z0-9]*");

    public static FieldType expandValueType(FieldType fieldType) {
        if (fieldType instanceof CollectionType) {
            return expandValueType(((CollectionType) fieldType).getElementType());
        }
        if (fieldType instanceof MapType) {
            return expandValueType(((MapType) fieldType).getValueType());
        }
        return fieldType;
    }

    public static boolean isLegalIdentifier(String s) {
        return s != null && LEGAL_IDENTIFIER.matcher(s).matches();
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

    public static String reduce(Set<String> values, String defVal) {
        for (String val : values) {
            if (val.contains(Double.class.getSimpleName())) {
                return val;
            } else if (val.contains(Long.class.getSimpleName())) {
                return val;
            } else if (val.contains(Float.class.getSimpleName())) {
                return val;
            } else if (val.contains(Integer.class.getSimpleName())) {
                return val;
            } else if (val.contains(Short.class.getSimpleName())) {
                return val;
            } else if (val.contains(Byte.class.getSimpleName())) {
                return val;
            } else if (val.contains(Boolean.class.getSimpleName())) {
                return val;
            }
        }
        return defVal;
    }
}
