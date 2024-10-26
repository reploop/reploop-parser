package org.reploop.translator.json.bean;

import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.support.Constants;

import java.util.List;

import static org.reploop.translator.json.support.Constants.EXTENDS_ATTR;
import static org.reploop.translator.json.support.Constants.IMPORT;

/**
 * Resolve type. Replace same types.
 */
public class DupTypeResolver extends AstVisitor<Node, MessageContext> {

	@Override
	public Node visitNode(Node node, MessageContext context) {
		return node;
	}

	@Override
	public ListType visitListType(ListType listType, MessageContext context) {
		FieldType eleType = visitFieldType(listType.getElementType(), context);
		return new ListType(eleType);
	}

	@Override
	public SetType visitSetType(SetType setType, MessageContext context) {
		FieldType eleType = visitFieldType(setType.getElementType(), context);
		return new SetType(eleType);
	}

	@Override
	public MapType visitMapType(MapType mapType, MessageContext context) {
		FieldType keyType = visitFieldType(mapType.getKeyType(), context);
		FieldType valType = visitFieldType(mapType.getValueType(), context);
		return new MapType(keyType, valType);
	}

	private QualifiedName replaceIfPresent(QualifiedName name, MessageContext context) {
		return context.replaceIfPresent(name);
	}

	@Override
	public StructType visitStructType(StructType structType, MessageContext context) {
		QualifiedName fqn = replaceIfPresent(structType.getName(), context);
		context.addDependency(fqn);
		return new StructType(fqn);
	}

	@Override
	public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
		return (FieldType) process(fieldType, context);
	}

	@Override
	public Field visitField(Field node, MessageContext context) {
		FieldType ft = visitFieldType(node.getType(), context);
		var options = node.getOptions();
		if (null != options && ft instanceof StringType) {
			for (Option option : options) {
				if (option instanceof CommonPair && Constants.DATE_PATTERN.equals(((CommonPair) option).getKey())) {
					Value val = ((CommonPair) option).getValue();
					if (val instanceof StringValue && StringUtils.isNotEmpty(((StringValue) val).getValue())) {
						ft = new StructType("java.time.LocalDateTime");
					}
				}
			}
		}
		return new Field(node.getModifier(), node.getIndex(), node.getName(), ft, node.getValue(), node.getComments(),
				options);
	}

	@Override
	public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
		String key = node.getKey();
		if (EXTENDS_ATTR.equals(key) || IMPORT.equals(key)) {
			Value value = node.getValue();
			if (value instanceof StringValue) {
				QualifiedName qn = QualifiedName.of(((StringValue) value).getValue());
				QualifiedName fqn = replaceIfPresent(qn, context);
				return new CommonPair(key, new StringValue(fqn.toString()));
			}
		}
		return node;
	}

	@Override
	public DefaultPair visitDefaultPair(DefaultPair node, MessageContext context) {
		return node;
	}

	@Override
	public OptionPair visitOptionPair(OptionPair node, MessageContext context) {
		return node;
	}

	@Override
	public Option visitOption(Option option, MessageContext context) {
		return (Option) process(option, context);
	}

	@Override
	public Function visitFunction(Function node, MessageContext context) {
		var responseType = visitFieldType(node.getResponseType(), context);
		var requestType = visitFieldType(node.getRequestType(), context);
		List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		return new Function(node.getName(), requestType, responseType, options);
	}

	@Override
	public Service visitService(Service node, MessageContext context) {
		List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		List<Function> functions = visitIfPresent(node.getFunctions(), function -> visitFunction(function, context));
		return new Service(node.getName(), options, functions);
	}

	@Override
	public Message visitMessage(Message node, MessageContext context) {
		QualifiedName fqn = replaceIfPresent(node.getName(), context);
		List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
		List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
		List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		List<Service> services = visitIfPresent(node.getServices(), service -> visitService(service, context));
		return new Message(fqn, node.getComments(), fields, messages, node.getEnumerations(), services, options);
	}

}
