package org.reploop.translator.json.bean;

import java.util.Set;

public class Support {
    public static final String pattern = "[%d]";

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
