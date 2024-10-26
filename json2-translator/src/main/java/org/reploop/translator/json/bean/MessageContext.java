package org.reploop.translator.json.bean;

import com.google.common.base.CaseFormat;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.FieldType;

public class MessageContext {

	private static final Set<QualifiedName> JSON_RAW_VALUE_PATH = new HashSet<>();

	private static final Map<QualifiedName, String> DATE_FORMAT = new HashMap<>();

	private static final Map<QualifiedName, String> DATE_TIMEZONE = new HashMap<>();

	private final Map<QualifiedName, QualifiedName> identityNames = new HashMap<>();

	private final Set<QualifiedName> dependencies = new HashSet<>();

	/**
	 * Current message's full qualified name
	 */
	private QualifiedName name;

	private boolean abstractClass;

	private QualifiedName superClass;

	private TreeMap<QualifiedName, List<Message>> namedMessages;

	private FieldType fieldType;

	/**
	 * Filename format
	 */
	private CaseFormat format;

	/**
	 * Root directory path of the output source files
	 */
	private Path directory;

	public MessageContext(QualifiedName name, Path directory) {
		this.name = name;
		this.directory = directory;
	}

	public MessageContext(QualifiedName name) {
		this.name = name;
	}

	public MessageContext(String name, Path directory) {
		this(QualifiedName.of(name), directory);
	}

	public MessageContext(String name) {
		this(QualifiedName.of(name));
	}

	public MessageContext() {
	}

	public CaseFormat getFormat() {
		return format;
	}

	public void setFormat(CaseFormat format) {
		this.format = format;
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

	public void setNamedMessages(TreeMap<QualifiedName, List<Message>> namedMessages) {
		this.namedMessages = namedMessages;
	}

	public MessageContext addNamedMessages(Map<QualifiedName, List<Message>> messageMap) {
		if (null != messageMap) {
			messageMap.forEach(this::addNamedMessage);
		}
		return this;
	}

	public MessageContext addMessages(List<Message> messages) {
		return addNamedMessage(name, messages);
	}

	public MessageContext addMessage(Message message) {
		return addMessages(Collections.singletonList(message));
	}

	public MessageContext addNamedMessage(QualifiedName name, Message message) {
		return addNamedMessage(name, Collections.singletonList(message));
	}

	public MessageContext addNamedMessage(QualifiedName name, List<Message> messages) {
		if (namedMessages == null) {
			namedMessages = new TreeMap<>();
		}
		namedMessages.computeIfAbsent(name, key -> new ArrayList<>()).addAll(messages);
		return this;
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

	public boolean isJsonRawValue(QualifiedName name) {
		if (null == name) {
			return false;
		}
		return name.tail().map(JSON_RAW_VALUE_PATH::contains).orElse(false);
	}

	public Optional<String> hasTimeZone() {
		return hasDateTimezone(name);
	}

	public Optional<String> hasDateFormat() {
		return hasDateFormat(name);
	}

	public Optional<String> hasDateFormat(QualifiedName fqn) {
		return fqn.tail().map(DATE_FORMAT::get);
	}

	public Optional<String> hasDateTimezone(QualifiedName fqn) {
		return fqn.tail().map(DATE_TIMEZONE::get);
	}

	public void configureDateFormat(String fqn, String pattern) {
		configureDateFormat(QualifiedName.of(fqn), pattern);
	}

	public void configureDateTimezone(String fqn, String timezone) {
		configureDateTimezone(QualifiedName.of(fqn), timezone);
	}

	public void configureDateFormat(QualifiedName fqn, String pattern) {
		fqn.tail().ifPresent(name -> DATE_FORMAT.put(name, pattern));
	}

	public void configureDateTimezone(QualifiedName fqn, String timezone) {
		fqn.tail().ifPresent(name -> DATE_TIMEZONE.put(name, timezone));
	}

	public void configureJsonRawValue(String xpath) {
		configureJsonRawValue(QualifiedName.of(xpath));
	}

	public void configureJsonRawValue(QualifiedName fqn) {
		fqn.tail().ifPresent(JSON_RAW_VALUE_PATH::add);
	}

	public MessageContext addDependency(QualifiedName fqn) {
		dependencies.add(fqn);
		return this;
	}

	public Set<QualifiedName> getDependencies() {
		return dependencies;
	}

	public boolean isJsonRawValue() {
		return isJsonRawValue(name);
	}

	public QualifiedName replaceIfPresent(QualifiedName name) {
		Optional<QualifiedName> oq = getIdentityName(name);
		if (oq.isEmpty()) {
			return name;
		}
		else {
			return replaceIfPresent(oq.get());
		}
	}

}
