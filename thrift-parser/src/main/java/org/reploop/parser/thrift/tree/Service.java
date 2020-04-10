package org.reploop.parser.thrift.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 00
 */
public class Service extends Entity {
    Optional<QualifiedName> parent;
    List<Function> functions;

    public Service(QualifiedName name, List<String> comments, List<Function> functions) {
        this(Optional.empty(), name, comments, functions);
    }

    public Service(String name, List<String> comments, List<Function> functions) {
        this(Optional.empty(), name, comments, functions);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitService(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(getName(), service.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public Service(Optional<QualifiedName> parent, String name, List<Function> functions) {
        this(parent, QualifiedName.of(name), Collections.emptyList(), functions);
    }

    public Service(Optional<QualifiedName> parent, String name, List<String> comments, List<Function> functions) {
        this(parent, QualifiedName.of(name), comments, functions);
    }

    public Service(Optional<QualifiedName> parent, QualifiedName name, List<String> comments, List<Function> functions) {
        super(name, comments);
        this.parent = parent;
        this.functions = functions;
    }

    public Optional<QualifiedName> getParent() {
        return parent;
    }

    public List<Function> getFunctions() {
        return functions;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append(super.toString());
        sb.append("parent=").append(parent);
        sb.append(", functions=").append(functions);
        sb.append('}');
        return sb.toString();
    }
}
