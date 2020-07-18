package org.reploop.translator.json.type;

import java.util.Objects;

public class JsonType {
    private final String fqn;

    public JsonType(String fqn) {
        this.fqn = fqn;
    }

    public String getFqn() {
        return fqn;
    }

    @Override
    public String toString() {
        return fqn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonType jsonType = (JsonType) o;
        return Objects.equals(fqn, jsonType.fqn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fqn);
    }
}
