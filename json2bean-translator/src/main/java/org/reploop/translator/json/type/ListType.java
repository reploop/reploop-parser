package org.reploop.translator.json.type;

import java.util.Objects;

public class ListType extends JsonType {
    private final JsonType elementType;

    public ListType(JsonType elementType) {
        this("List", elementType);
    }

    public ListType(String fqn, JsonType elementType) {
        super(fqn);
        this.elementType = elementType;
    }

    public JsonType getElementType() {
        return elementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListType listType = (ListType) o;
        return Objects.equals(elementType, listType.elementType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), elementType);
    }

    @Override
    public String toString() {
        return getFqn() + "<" + elementType + ">";
    }
}
