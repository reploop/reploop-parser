package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.FieldType;

import java.nio.file.Path;
import java.util.*;

public class JsonMessageContext {
    private QualifiedName name;
    private boolean abstractClass;
    private QualifiedName superClass;
    private TreeMap<QualifiedName, List<Message>> namedMessages;
    private final Map<QualifiedName, QualifiedName> identityNames = new HashMap<>();
    private final Set<QualifiedName> dependencies = new HashSet<>();
    private FieldType fieldType;
    /**
     * Root directory path of the output source files
     */
    private Path directory;

    public JsonMessageContext(QualifiedName name, Path directory) {
        this.name = name;
        this.directory = directory;
    }

    public JsonMessageContext(QualifiedName name) {
        this.name = name;
    }

    public JsonMessageContext(String name, Path directory) {
        this(QualifiedName.of(name), directory);
    }

    public JsonMessageContext(String name) {
        this(QualifiedName.of(name));
    }

    public JsonMessageContext() {
    }

    public Path getDirectory() {
        return directory;
    }

    public void setDirectory(Path directory) {
        this.directory = directory;
    }

    public QualifiedName getSuperClass() {
        return superClass;
    }

    public void setSuperClass(QualifiedName superClass) {
        this.superClass = superClass;
    }

    public boolean isAbstractClass() {
        return abstractClass;
    }

    public void setAbstractClass(boolean abstractClass) {
        this.abstractClass = abstractClass;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public QualifiedName getName() {
        return name;
    }

    public void setName(String name) {
        setName(QualifiedName.of(name));
    }

    public void setName(QualifiedName name) {
        this.name = name;
    }

    public Map<QualifiedName, List<Message>> getNamedMessages() {
        return namedMessages;
    }

    public JsonMessageContext addNamedMessages(Map<QualifiedName, List<Message>> messageMap) {
        if (null != messageMap) {
            messageMap.forEach(this::addNamedMessage);
        }
        return this;
    }

    public JsonMessageContext addMessages(List<Message> messages) {
        return addNamedMessage(name, messages);
    }

    public JsonMessageContext addMessage(Message message) {
        return addMessages(Collections.singletonList(message));
    }

    public JsonMessageContext addNamedMessage(QualifiedName name, Message message) {
        return addNamedMessage(name, Collections.singletonList(message));
    }

    public JsonMessageContext addNamedMessage(QualifiedName name, List<Message> messages) {
        if (namedMessages == null) {
            namedMessages = new TreeMap<>();
        }
        namedMessages.computeIfAbsent(name, key -> new ArrayList<>()).addAll(messages);
        return this;
    }

    public void setNamedMessages(TreeMap<QualifiedName, List<Message>> namedMessages) {
        this.namedMessages = namedMessages;
    }

    public Map<QualifiedName, QualifiedName> getIdentityNames() {
        return identityNames;
    }

    public Optional<QualifiedName> getIdentityName(QualifiedName qn) {
        return Optional.ofNullable(identityNames.get(qn));
    }

    public List<Message> getMessages(QualifiedName name) {
        if (null == namedMessages) {
            return Collections.emptyList();
        }
        return namedMessages.get(name);
    }

    public void addIdentityName(QualifiedName a, QualifiedName b) {
        identityNames.put(a, b);
    }

    public void addIdentityNames(Map<QualifiedName, QualifiedName> identityNames) {
        if (null != identityNames) {
            this.identityNames.putAll(identityNames);
        }
    }

    private static final Set<QualifiedName> JSON_RAW_VALUE_PATH = new HashSet<>();

    public boolean isJsonRawValue(QualifiedName name) {
        if (null == name) {
            return false;
        }
        return name.tail().map(JSON_RAW_VALUE_PATH::contains).orElse(false);
    }

    public Optional<String> hasDateFormat() {
        return hasDateFormat(name);
    }

    public Optional<String> hasDateFormat(QualifiedName fqn) {
        return fqn.tail().map(DATE_FORMAT::get);
    }

    private static final Map<QualifiedName, String> DATE_FORMAT = new HashMap<>();

    public void configureDateFormat(String fqn, String pattern) {
        configureDateFormat(QualifiedName.of(fqn), pattern);
    }

    public void configureDateFormat(QualifiedName fqn, String pattern) {
        fqn.tail().ifPresent(name -> DATE_FORMAT.put(name, pattern));
    }

    public void configureJsonRawValue(String xpath) {
        configureJsonRawValue(QualifiedName.of(xpath));
    }

    public void configureJsonRawValue(QualifiedName fqn) {
        fqn.tail().ifPresent(JSON_RAW_VALUE_PATH::add);
    }

    public JsonMessageContext addDependency(QualifiedName fqn) {
        dependencies.add(fqn);
        return this;
    }

    public Set<QualifiedName> getDependencies() {
        return dependencies;
    }

    public boolean isJsonRawValue() {
        return isJsonRawValue(name);
    }
}
