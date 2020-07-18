package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;

import java.util.Objects;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Definition extends Node {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDefinition(this, context);
    }

    Optional<Service> service;
    Optional<Entity> entity;

    public Definition(Optional<Service> service, Optional<Entity> entity) {
        this.service = service;
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return Objects.equals(service, that.service) &&
                Objects.equals(entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, entity);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "service=" + service +
                ", entity=" + entity +
                '}';
    }
}
