package com.qiyi.walle.parser.thrift.tree;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 00
 */
public class Function extends Node implements Comparable<Function> {

    boolean oneWay = false;
    QualifiedName name;
    FunctionType returnType;
    List<Field> parameters;
    Optional<List<Field>> exceptions;
    List<String> comments;
    String body;


    public Function(QualifiedName name, FunctionType returnType, List<Field> parameters,
                    Optional<List<Field>> exceptions) {
        this(Collections.emptyList(), false, name, returnType, parameters, exceptions);
    }

    public Function(boolean oneWay,
                    QualifiedName name, FunctionType returnType, List<Field> parameters,
                    Optional<List<Field>> exceptions) {
        this(Collections.emptyList(), oneWay, name, returnType, parameters, exceptions);
    }

    public Function(List<String> comments, boolean oneWay,
                    QualifiedName name, FunctionType returnType, List<Field> parameters,
                    Optional<List<Field>> exceptions) {
        this.oneWay = oneWay;
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
        this.exceptions = exceptions;
        this.comments = comments;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFunction(this, context);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public QualifiedName getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public FunctionType getReturnType() {
        return returnType;
    }

    public List<Field> getParameters() {
        return parameters;
    }

    public Optional<List<Field>> getExceptions() {
        return exceptions;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Function{");
        sb.append("oneWay=").append(oneWay);
        sb.append(", name='").append(name).append('\'');
        sb.append(", returnType=").append(returnType);
        sb.append(", parameters=").append(parameters);
        sb.append(", exceptions=").append(exceptions);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Function o) {
        int result = this.getName().compareTo(o.getName());
        if (0 == result) {
            List<Field> f1 = getParameters();
            List<Field> f2 = o.getParameters();
            result = f1.size() - f2.size();
        }
        return result;
    }
}
