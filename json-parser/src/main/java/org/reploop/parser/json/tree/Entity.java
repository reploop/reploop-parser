package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.List;
import java.util.Objects;

/**
 * A object entity contains multiple key-value pairs.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-10-14 20
 */
public class Entity extends Value {
  private final List<Pair> pairs;

  public Entity(List<Pair> pairs) {
    this.pairs = pairs;
  }

  public List<Pair> getPairs() {
    return pairs;
  }

  @Override
  public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
    return visitor.visitObject(this, context);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Entity entity = (Entity) o;
    return Objects.equals(pairs, entity.pairs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pairs);
  }

  @Override
  public String toString() {

    return "{" + "}";
  }
}
