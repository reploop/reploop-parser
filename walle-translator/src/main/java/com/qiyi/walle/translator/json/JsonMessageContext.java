package com.qiyi.walle.translator.json;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.tree.Message;

import java.util.*;

public class JsonMessageContext {
    Map<QualifiedName, QualifiedName> dup = new HashMap<>();
    Map<QualifiedName, Message> messages = new TreeMap<>((o1, o2) -> {
        int r = o1.size() - o2.size();
        if (0 == r) {
            r = o1.compareTo(o2);
        }
        return -r;
    });

    QualifiedName namespace;
    Stack<QualifiedName> current = new Stack<>();


    public JsonMessageContext() {
    }

    public JsonMessageContext(QualifiedName name) {
        push(name);
    }

    public JsonMessageContext(QualifiedName namespace, QualifiedName name) {
        this.namespace = namespace;
        push(name);
    }

    public QualifiedName getNamespace() {
        return namespace;
    }

    public void setNamespace(QualifiedName namespace) {
        this.namespace = namespace;
    }

    public QualifiedName peek() {
        return current.peek();
    }

    public QualifiedName pop() {
        return current.pop();
    }

    public void push(QualifiedName name) {
        current.push(name);
    }

    public QualifiedName fqn() {
        List<String> parts = new ArrayList<>();
        for (QualifiedName name : current) {
            parts.addAll(name.allParts());
        }
        return QualifiedName.of(parts);
    }


    public void add(QualifiedName name, Message message) {
        messages.put(name, message);
    }


    public Map<QualifiedName, QualifiedName> getDup() {
        return dup;
    }

    public void dup(QualifiedName name, QualifiedName dup) {
        this.dup.put(name, dup);
    }

    public Optional<QualifiedName> dup(QualifiedName name) {
        return Optional.ofNullable(dup.get(name));
    }

    public void setDup(Map<QualifiedName, QualifiedName> dup) {
        this.dup = dup;
    }

    public Map<QualifiedName, Message> getMessages() {
        return messages;
    }

    public void setMessages(Map<QualifiedName, Message> messages) {
        this.messages = messages;
    }

    public Stack<QualifiedName> getCurrent() {
        return current;
    }

    public void setCurrent(Stack<QualifiedName> current) {
        this.current = current;
    }
}
