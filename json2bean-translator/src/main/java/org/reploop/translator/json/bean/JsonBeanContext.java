package org.reploop.translator.json.bean;


import org.reploop.parser.QualifiedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JsonBeanContext {
    private QualifiedName root;
    private final StringBuilder impl;

    private int indent = 0;

    public JsonBeanContext(QualifiedName root) {
        this(root, new StringBuilder());
    }

    public JsonBeanContext(QualifiedName root, StringBuilder impl) {
        this.root = root;
        this.impl = impl;
        push(root);
    }

    private final Stack<QualifiedName> current = new Stack<>();

    public QualifiedName fqn() {
        List<String> parts = new ArrayList<>();
        for (QualifiedName qn : current) {
            parts.addAll(qn.allParts());
        }
        return QualifiedName.of(parts);
    }

    public JsonBeanContext push(QualifiedName name) {
        current.push(name);
        return this;
    }

    public QualifiedName pop() {
        return current.pop();
    }

    public JsonBeanContext newLine() {
        impl.append("\r\n");
        for (int i = 0; i < indent; i++) {
            whitespace();
        }
        return this;
    }

    public JsonBeanContext indent() {
        indent += 4;
        return this;
    }

    public JsonBeanContext dedent() {
        indent -= 4;
        return this;
    }

    public QualifiedName getName() {
        return root;
    }

    public void setName(QualifiedName name) {
        this.root = name;
    }

    public JsonBeanContext whitespace() {
        impl.append(" ");
        return this;
    }

    public JsonBeanContext quote() {
        impl.append("\"");
        return this;
    }

    public JsonBeanContext comma() {
        impl.append(";");
        return this;
    }

    public JsonBeanContext append(QualifiedName val) {
        impl.append(val.toString());
        return this;
    }

    public JsonBeanContext append(String val) {
        impl.append(val);
        return this;
    }

    public JsonBeanContext openParen() {
        impl.append("(");
        return this;
    }

    public JsonBeanContext closeParen() {
        impl.append(")");
        return this;
    }

    public JsonBeanContext openBrace() {
        impl.append("{");
        return this;
    }

    public JsonBeanContext closeBrace() {
        impl.append("}");
        return this;
    }

    @Override
    public String toString() {
        return impl.toString();
    }

}
