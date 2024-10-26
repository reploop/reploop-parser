package org.reploop.translator.json.gen;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.bean.BeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.reploop.translator.json.support.Constants.*;
import static org.reploop.translator.json.support.NameSupport.isObject;

public class AvroGenerator extends AstVisitor<Node, BeanContext> {

	private static final Logger LOG = LoggerFactory.getLogger(AvroGenerator.class);

	private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

	private <N extends Node> List<N> visit(List<N> nodes, Function<N, N> visit) {
		return nodes.stream().map(visit).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public Node visitNode(Node node, BeanContext context) {
		return node;
	}

	@Override
	public FieldType visitFieldType(FieldType fieldType, BeanContext context) {
		return (FieldType) process(fieldType, context);
	}

	private void comments(List<String> comments, BeanContext context) {
		if (null != comments && !comments.isEmpty()) {
			comments.forEach(c -> context.append(c).newLine());
		}
	}

	@Override
	public Option visitOption(Option option, BeanContext context) {
		return (Option) process(option, context);
	}

	@Override
	public StringValue visitStringValue(StringValue node, BeanContext context) {
		quoteString(node.getValue(), context);
		return node;
	}

	public AvroGenerator quoteString(String value, BeanContext context) {
		context.quote().append(value).quote();
		return this;
	}

	@Override
	public Value visitValue(Value node, BeanContext context) {
		return (Value) process(node, context);
	}

	@Override
	public CommonPair visitCommonPair(CommonPair node, BeanContext context) {
		String key = node.getKey();
		Value value = node.getValue();
		String expected = context.getExpectedKey();
		if (key.equals(expected)) {
			switch (key) {
				case IMPORT:
					break;
				case ABSTRACT_ATTR:
					visitAbstractAttr(context, value);
					break;
			}
		}
		return node;
	}

	private void visitImport(BeanContext context, String key, Value value) {
		context.append(key).whitespace();
		visitValue(value, context);
		context.semicolon().newLine();
	}

	private void visitAbstractAttr(BeanContext context, Value value) {
		if (value instanceof BoolValue) {
			Boolean isAbstract = ((BoolValue) value).getValue();
			if (isAbstract) {
				context.append(ABSTRACT_ATTR).whitespace();
			}
		}
	}

	@Override
	public BoolType visitBoolType(BoolType boolType, BeanContext context) {
		quoteString("boolean", context);
		return boolType;
	}

	@Override
	public ByteStringType visitByteStringType(ByteStringType byteStringType, BeanContext context) {
		quoteString("bytes", context);
		return byteStringType;
	}

	@Override
	public Node visitByteType(ByteType byteType, BeanContext context) {
		quoteString("int", context);
		return byteType;
	}

	@Override
	public DoubleType visitDoubleType(DoubleType doubleType, BeanContext context) {
		quoteString("double", context);
		return doubleType;
	}

	@Override
	public FloatType visitFloatType(FloatType floatType, BeanContext context) {
		quoteString("float", context);
		return floatType;
	}

	@Override
	public Node visitIntType(IntType intType, BeanContext context) {
		quoteString("int", context);
		return intType;
	}

	@Override
	public ListType visitListType(ListType listType, BeanContext context) {
		context.openBrace().indent().newLine();
		context.quote().append("type").quote().colon().whitespace().quote().append("array").quote().comma().newLine();
		context.quote().append("items").quote().colon().whitespace();
		visitFieldType(listType.getElementType(), context);
		context.comma().newLine();
		context.quote().append("default").quote().colon().whitespace().openSquare().closeSquare();
		context.dedent().newLine().closeBrace();
		return listType;
	}

	@Override
	public LongType visitLongType(LongType longType, BeanContext context) {
		quoteString("long", context);
		return longType;
	}

	@Override
	public MapType visitMapType(MapType mapType, BeanContext context) {
		context.openBrace().indent().newLine();
		// Type
		quoteString("type", context);
		context.colon().whitespace();
		quoteString("map", context);
		context.comma().newLine();
		// Values
		quoteString("values", context);
		context.colon().whitespace();
		visitFieldType(mapType.getValueType(), context);
		context.comma().newLine();
		// Default
		quoteString("default", context);
		context.colon().whitespace().openBrace().closeBrace();
		context.dedent().newLine().closeBrace();
		return mapType;
	}

	@Override
	public SetType visitSetType(SetType setType, BeanContext context) {
		visitListType(new ListType(setType.getElementType()), context);
		return setType;
	}

	@Override
	public ShortType visitShortType(ShortType shortType, BeanContext context) {
		quoteString("int", context);
		return shortType;
	}

	@Override
	public StringType visitStringType(StringType stringType, BeanContext context) {
		quoteString("string", context);
		return stringType;
	}

	@Override
	public StructType visitStructType(StructType structType, BeanContext context) {
		QualifiedName fqn = structType.getName();
		if (isObject(fqn)) {
			quoteString("string", context);
		}
		else {
			quoteString(structType.getName().toString(), context);
		}
		return structType;
	}

	@Override
	public Field visitField(Field node, BeanContext context) {
		if (!context.isHead()) {
			context.comma().newLine();
		}
		String name = node.getName();
		var options = node.getOptions();
		for (Option option : options) {
			if (option instanceof CommonPair && ORIGINAL_NAME.equals(((CommonPair) option).getKey())) {
				Value value = ((CommonPair) option).getValue();
				if (value instanceof StringValue) {
					name = ((StringValue) value).getValue();
				}
			}
		}
		comments(node.getComments(), context);
		context.openBrace().indent().newLine();
		context.quote().append("name").quote().colon().whitespace().quote().append(name).quote().comma().newLine();
		context.quote().append("type").quote().colon().whitespace();
		visitFieldType(node.getType(), context);
		context.dedent().newLine().closeBrace();
		if (context.isHead()) {
			context.setHead(false);
		}
		return node;
	}

	@Override
	public Message visitMessage(Message node, BeanContext context) {
		QualifiedName name = node.getName();
		// Options
		comments(node.getComments(), context);
		context.openBrace().indent().newLine();
		context.quote().append("type").quote().colon().whitespace().quote().append("record").quote().comma().newLine();
		context.quote()
			.append("name")
			.quote()
			.colon()
			.whitespace()
			.quote()
			.append(name.suffix())
			.quote()
			.comma()
			.newLine();
		name.prefix()
			.ifPresent(prefix -> context.quote()
				.append("namespace")
				.quote()
				.colon()
				.whitespace()
				.quote()
				.append(prefix)
				.quote()
				.comma()
				.newLine());
		// Fields
		context.setHead(true);
		context.quote().append("fields").quote().colon().whitespace().openSquare().indent().newLine();
		List<Field> fields = visit(node.getFields(), n -> visitField(n, context));
		context.dedent().newLine().closeSquare();
		context.setHead(true);

		context.dedent().newLine().closeBrace();
		List<Message> messages = visit(node.getMessages(), m -> visitMessage(m, context));
		return new Message(name, node.getComments(), fields, messages, node.getEnumerations(), null, node.getOptions());
	}

}
