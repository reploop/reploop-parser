package org.reploop.parser.json.tree;

import java.util.Objects;

public class Infinity extends Number {
  @Override
  public int hashCode() {
    return Objects.hash(toString());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Infinity) {
      return Objects.equals(toString(), obj.toString());
    }
    return false;
  }

  @Override
  public String toString() {
    return "Infinity";
  }
}
