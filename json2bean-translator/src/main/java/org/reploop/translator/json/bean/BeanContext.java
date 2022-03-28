package org.reploop.translator.json.bean;


import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class BeanContext {
    private QualifiedName root;
    private boolean abstractClass;
    private QualifiedName superClass;
    private final StringBuilder impl;
    private String expectedKey;
    private Map<QualifiedName, Message> deps;
    private int indent = 0;

    public BeanContext(QualifiedName root) {
        this(root, Collections.emptyMap());
    }

    public BeanContext(QualifiedName root, Map<QualifiedName, Message> deps) {
        this(root, new StringBuilder());
        this.deps = deps;
    }

    public BeanContext(QualifiedName root, StringBuilder impl) {
        this.root = root;
        this.impl = impl;
        push(root);
    }

    public Map<QualifiedName, Message> getDeps() {
        return deps;
    }

    public Optional<Message> dep(QualifiedName name) {
        if (null != name) {
            return Optional.ofNullable(deps.get(name));
        }
        return Optional.empty();
    }

    public void setDeps(Map<QualifiedName, Message> deps) {
        this.deps = deps;
    }

    private final Stack<QualifiedName> current = new Stack<>();

    public BeanContext push(QualifiedName name) {
        current.push(name);
        return this;
    }

    public QualifiedName pop() {
        return current.pop();
    }

    public BeanContext newLine() {
        impl.append(System.lineSeparator());
        for (int i = 0; i < indent; i++) {
            whitespace();
        }
        return this;
    }

    public BeanContext indent() {
        indent += 4;
        return this;
    }

    public BeanContext dedent() {
        indent -= 4;
        return this;
    }

    public QualifiedName getName() {
        return root;
    }

    public void setName(QualifiedName name) {
        this.root = name;
    }

    public BeanContext whitespace() {
        impl.append(" ");
        return this;
    }

    public BeanContext quote() {
        impl.append("\"");
        return this;
    }

    public BeanContext semicolon() {
        impl.append(";");
        return this;
    }

    public BeanContext comma() {
        impl.append(",");
        return this;
    }

    public BeanContext append(QualifiedName val) {
        impl.append(val.toString());
        return this;
    }

    public BeanContext append(String val) {
        impl.append(val);
        return this;
    }

    public BeanContext openParen() {
        impl.append("(");
        return this;
    }

    public BeanContext closeParen() {
        impl.append(")");
        return this;
    }

    public BeanContext openBrace() {
        impl.append("{");
        return this;
    }

    public BeanContext closeBrace() {
        impl.append("}");
        return this;
    }

    public boolean isAbstractClass() {
        return abstractClass;
    }

    public void setAbstractClass(boolean abstractClass) {
        this.abstractClass = abstractClass;
    }

    public QualifiedName getSuperClass() {
        return superClass;
    }

    public void setSuperClass(QualifiedName superClass) {
        this.superClass = superClass;
    }

    public String getExpectedKey() {
        return expectedKey;
    }

    public void setExpectedKey(String expectedKey) {
        this.expectedKey = expectedKey;
    }

    public void clearExpectedKey() {
        this.expectedKey = null;
    }

    @Override
    public String toString() {
        return impl.toString();
    }

}
