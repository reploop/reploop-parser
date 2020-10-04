package org.reploop.translator.json.bean;


import org.reploop.parser.QualifiedName;

import java.util.Stack;

public class JsonBeanContext {
    private QualifiedName root;
    private final StringBuilder impl;
    private String expectedKey;

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

    public String getExpectedKey() {
        return expectedKey;
    }

    public void setExpectedKey(String expectedKey) {
        this.expectedKey = expectedKey;
    }

    @Override
    public String toString() {
        return impl.toString();
    }

}
