package org.reploop.parser.protobuf.tree;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 10
 */
public class Service extends Node {
    private QualifiedName name;
    private List<Option> options;
    private List<Function> functions;

    public Service(QualifiedName name, List<Option> options, List<Function> functions) {
        this.name = name;
        this.options = options;
        this.functions = functions;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitService(this, context);
    }

    public QualifiedName getName() {
        return name;
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(name, service.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append("name=").append(name);
        sb.append(", options=").append(options);
        sb.append(", functions=").append(functions);
        sb.append('}');
        return sb.toString();
    }
}
