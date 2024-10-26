package org.reploop.translator.json.driver;

import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.bean.MessageContext;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.reploop.translator.json.support.Constants.*;
import static org.reploop.translator.json.support.NameSupport.*;

/**
 * When finished, class names are unique in the message.
 */
public class BeanRenameResolver extends AstVisitor<Node, MessageContext> {

	@Override
	public Node visitNode(Node node, MessageContext context) {
		return node;
	}

	@Override
	public ListType visitListType(ListType listType, MessageContext context) {
		context.addDependency(IMPORT_LIST);
		FieldType eleType = visitFieldType(listType.getElementType(), context);
		return new ListType(eleType);
	}

	@Override
	public SetType visitSetType(SetType setType, MessageContext context) {
		context.addDependency(IMPORT_SET);
		FieldType eleType = visitFieldType(setType.getElementType(), context);
		return new SetType(eleType);
	}

	@Override
	public MapType visitMapType(MapType mapType, MessageContext context) {
		context.addDependency(IMPORT_MAP);
		FieldType keyType = visitFieldType(mapType.getKeyType(), context);
		FieldType valType = visitFieldType(mapType.getValueType(), context);
		return new MapType(keyType, valType);
	}

	@Override
	public StructType visitStructType(StructType structType, MessageContext context) {
		QualifiedName qn = renameQualifiedName(structType.getName(), context);
		return new StructType(qn);
	}

	private QualifiedName renameQualifiedName(QualifiedName qn, MessageContext context) {
		QualifiedName fqn = qn;
		Optional<QualifiedName> oqn = qn.prefix();
		if (oqn.isPresent()) {
			if (hasNameConflict(qn, context.getDependencies()) || hasNameConflict(qn, context.getName())) {
				QualifiedName prefix = oqn.get();
				// When conflicts, add prefix's last name to the full name.
				// Sort first so the name are constant.
				String suffix = Stream.of(prefix.suffix(), qn.suffix())
					.sorted()
					.collect(Collectors.joining(UNDERSCORE));
				// The new full qualified name
				fqn = toUpperCamel(QualifiedName.of(prefix, suffix));
				// Rewrite fqn later.
				context.addIdentityName(qn, fqn);
			}
		}
		// Add fqn to dependencies
		context.addDependency(fqn);
		return fqn;
	}

	@Override
	public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
		String key = node.getKey();
		if (EXTENDS_ATTR.equals(key)) {
			Value value = node.getValue();
			if (value instanceof StringValue) {
				QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
				QualifiedName qn = renameQualifiedName(fqn, context);
				context.setSuperClass(qn);
				return new CommonPair(EXTENDS_ATTR, new StringValue(qn.toString()));
			}
		}
		else if (ORIGINAL_NAME.equals(key)) {
			context.addDependency(IMPORT_JSON_PROPERTY);
		}
		else if (DATE_PATTERN.equals(key)) {
			context.addDependency(IMPORT_JSON_FORMAT);
		}
		return node;
	}

	@Override
	public Option visitOption(Option option, MessageContext context) {
		return (Option) process(option, context);
	}

	@Override
	public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
		return (FieldType) process(fieldType, context);
	}

	@Override
	public Field visitField(Field node, MessageContext context) {
		FieldType ft = visitFieldType(node.getType(), context);
		List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		return new Field(node.getModifier(), node.getIndex(), node.getName(), ft, node.getValue(), node.getComments(),
				options);
	}

	@Override
	public Enumeration visitEnumeration(Enumeration node, MessageContext context) {
		return (Enumeration) super.visitEnumeration(node, context);
	}

	@Override
	public Service visitService(Service node, MessageContext context) {
		return (Service) super.visitService(node, context);
	}

	@Override
	public Message visitMessage(Message node, MessageContext context) {
		QualifiedName name = node.getName();
		context.setName(name);
		// These are support by default.
		context.addDependency(IMPORT_SERIALIZABLE);
		context.addDependency(IMPORT_JSON_IGNORE);
		context.addDependency(IMPORT_MORE_OBJECTS);
		// Fields
		List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
		List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
		List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(),
				enumeration -> visitEnumeration(enumeration, context));
		List<Service> services = visitIfPresent(node.getServices(), service -> visitService(service, context));

		List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		context.getDependencies()
			.stream()
			.filter(qn -> !autoImported(qn))
			.map(QualifiedName::toString)
			.map(dep -> new CommonPair(IMPORT, new StringValue(dep)))
			.forEach(options::add);
		List<String> comments = ImmutableList.<String>builder()
			.addAll(node.getComments())
			.add("@JsonIgnoreProperties(ignoreUnknown = true)")
			.build();
		return new Message(name, comments, fields, messages, enumerations, services, options);
	}

}
