package org.reploop.parser.protobuf.tree;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 12
 */
public class BoolValue extends Value {
    Boolean value;

    public BoolValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoolValue boolValue = (BoolValue) o;
        return Objects.equals(value, boolValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "BoolValue{" +
                "value=" + value +
                '}';
    }
}
