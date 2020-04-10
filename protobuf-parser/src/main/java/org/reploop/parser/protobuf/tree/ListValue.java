package org.reploop.parser.protobuf.tree;

import com.google.common.base.MoreObjects;
import com.qiyi.walle.parser.protobuf.Node;

import java.util.List;
import java.util.Objects;

public class ListValue extends Value {
    List<Node> values;

    public ListValue(List<Node> values) {
        this.values = values;
    }

    public List<Node> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListValue listValue = (ListValue) o;
        return Objects.equals(values, listValue.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("values", values)
                .toString();
    }
}
