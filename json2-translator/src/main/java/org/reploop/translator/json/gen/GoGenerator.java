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

public class GoGenerator extends AstVisitor<Node, BeanContext> {

	private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

	private static final Logger LOG = LoggerFactory.getLogger(GoGenerator.class);

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
		context.append(node.getValue());
		return node;
	}

	@Override
	public Value visitValue(Value node, BeanContext context) {
		return (Value) process(node, context);
	}

	@Override
	public BoolType visitBoolType(BoolType boolType, BeanContext context) {
		context.append("bool");
		return boolType;
	}

	@Override
	public Node visitByteStringType(ByteStringType byteStringType, BeanContext context) {
		return super.visitByteStringType(byteStringType, context);
	}

	@Override
	public ByteType visitByteType(ByteType byteType, BeanContext context) {
		context.append("byte");
		return byteType;
	}

	@Override
	public DoubleType visitDoubleType(DoubleType doubleType, BeanContext context) {
		context.append("float64");
		return doubleType;
	}

	@Override
	public FloatType visitFloatType(FloatType floatType, BeanContext context) {
		context.append("float32");
		return floatType;
	}

	@Override
	public IntType visitIntType(IntType intType, BeanContext context) {
		context.append("int32");
		return intType;
	}

	@Override
	public StructType visitStructType(StructType structType, BeanContext context) {
		QualifiedName name = structType.getName();
		if (isObject(name)) {
			context.append("string");
		}
		else {
			context.append(name);
		}
		return structType;
	}

	@Override
	public ListType visitListType(ListType listType, BeanContext context) {
		context.openSquare().closeSquare();
		visitFieldType(listType.getElementType(), context);
		return listType;
	}

	@Override
	public LongType visitLongType(LongType longType, BeanContext context) {
		context.append("int64");
		return longType;
	}

	@Override
	public MapType visitMapType(MapType mapType, BeanContext context) {
		context.append("map");
		context.openSquare();
		visitFieldType(mapType.getKeyType(), context);
		context.closeSquare();
		visitFieldType(mapType.getValueType(), context);
		return mapType;
	}

	@Override
	public SetType visitSetType(SetType setType, BeanContext context) {
		context.openSquare().closeSquare();
		visitFieldType(setType.getElementType(), context);
		return setType;
	}

	@Override
	public ShortType visitShortType(ShortType shortType, BeanContext context) {
		context.append("int16");
		return shortType;
	}

	@Override
	public StringType visitStringType(StringType stringType, BeanContext context) {
		context.append("string");
		return stringType;
	}

	@Override
	public CommonPair visitCommonPair(CommonPair node, BeanContext context) {
		String key = node.getKey();
		Value value = node.getValue();
		String expected = context.getExpectedKey();
		if (key.equals(expected)) {
			switch (key) {
				case IMPORT:
					visitImport(context, key, value);
					break;
				case EXTENDS_ATTR:
					visitExtendsAttr(context, value);
					break;
				case ABSTRACT_ATTR:
					visitAbstractAttr(context, value);
					break;
			}
		}
		return node;
	}

	private void visitImport(BeanContext context, String key, Value value) {
		QualifiedName name = QualifiedName.of(((StringValue) value).getValue());
		context.append(key).whitespace().quote();
		context.append(name.join(SEP)).quote().newLine();
	}

	private void visitAbstractAttr(BeanContext context, Value value) {
		if (value instanceof BoolValue) {
			Boolean isAbstract = ((BoolValue) value).getValue();
			if (isAbstract) {
				context.append(ABSTRACT_ATTR).whitespace();
			}
		}
	}

	private void visitExtendsAttr(BeanContext context, Value value) {
		if (value instanceof StringValue) {
			context.append(EXTENDS_ATTR).whitespace();
			visitValue(value, context);
			context.whitespace();
		}
	}

	@Override
	public Field visitField(Field node, BeanContext context) {
		String name = node.getName();
		comments(node.getComments(), context);
		context.append(LC_UC.convert(name)).whitespace();
		visitFieldType(node.getType(), context);
		context.whitespace().backtick().append("json").colon().quote();
		List<Option> options = node.getOptions();
		for (Option option : options) {
			if (option instanceof CommonPair && ORIGINAL_NAME.equals(((CommonPair) option).getKey())) {
				Value value = ((CommonPair) option).getValue();
				if (value instanceof StringValue) {
					name = ((StringValue) value).getValue();
				}
			}
		}
		context.append(name).quote().backtick().newLine();
		return node;
	}

	@Override
	public Message visitMessage(Message node, BeanContext context) {
		QualifiedName name = node.getName();
		String ns = name.prefix().map(QualifiedName::suffix).orElse("main");
		context.append("package").whitespace().append(ns).newLine().newLine();
		// Options
		context.setExpectedKey(IMPORT);
		visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		context.clearExpectedKey();
		context.append("type")
			.whitespace()
			.append(name.suffix())
			.whitespace()
			.append("struct")
			.whitespace()
			.openBrace()
			.indent()
			.newLine();
		var fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
		context.dedent().newLine().closeBrace().newLine();
		return new Message(name, node.getComments(), fields, node.getMessages(), node.getEnumerations(), null,
				node.getOptions());
	}

}
