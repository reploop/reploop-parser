package com.qiyi.walle.parser.protobuf.tree;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-14 00
 */
public class FloatValue extends Value {
    float value;

    public FloatValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FloatValue)) return false;
        FloatValue that = (FloatValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
