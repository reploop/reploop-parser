package org.reploop.parser.protobuf.tree;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 12
 */
public class IntValue extends Value {
    Integer value;

    public IntValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntValue intValue = (IntValue) o;
        return Objects.equals(value, intValue.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "IntValue{" +
                "value=" + value +
                '}';
    }
}
