package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.support.NameSupport;

import java.util.ArrayList;
import java.util.List;

import static org.reploop.translator.json.support.Constants.IMPORT;
import static org.reploop.translator.json.support.Constants.PARENT_DIR;

public class RelativePathResolver extends AstVisitor<Node, MessageContext> {

	@Override
	public Node visitNode(Node node, MessageContext context) {
		return node;
	}

	@Override
	public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
		return (FieldType) process(fieldType, context);
	}

	@Override
	public StructType visitStructType(StructType structType, MessageContext context) {
		QualifiedName fqn = structType.getName();
		if (NameSupport.autoImported(fqn)) {
			return structType;
		}
		String suffix = fqn.suffix();
		QualifiedName name = QualifiedName.of(suffix);
		QualifiedName rp = toRelativePath(context.getName(), fqn);
		// They are not the same;
		if (rp.size() != 0) {
			// Thrift way to ref a struct in another file is filename.struct
			name = QualifiedName.of(QualifiedName.of(format(suffix, context)), suffix);
		}
		return new StructType(name);
	}

	@Override
	public Option visitOption(Option option, MessageContext context) {
		return (Option) process(option, context);
	}

	/**
	 * Convert from absolute path to relative path.
	 * @param base the base name, that is the {@code name} is included from this file.
	 * @param name the file be included.
	 * @return if base is same as name, an empty name will be returned.
	 */
	private QualifiedName toRelativePath(QualifiedName base, QualifiedName name) {
		int baseSize = base.size();
		int nameSize = name.size();
		int idx = 0;
		for (; idx < baseSize && idx < nameSize; idx++) {
			String p1 = base.partAt(idx);
			String p2 = name.partAt(idx);
			// The deepest branch
			if (!p1.equals(p2)) {
				break;
			}
		}
		// To the deepest common directory in the path
		idx -= 1;
		int count = baseSize - idx - 1 - 1;
		List<String> relatives = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			relatives.add(PARENT_DIR);
		}
		// Copy the different paths
		idx += 1;
		if (idx < nameSize) {
			List<String> parts = name.allParts();
			relatives.addAll(parts.subList(idx, nameSize));
		}
		return QualifiedName.of(relatives);
	}

	private String format(String name, MessageContext context) {
		return CaseFormat.UPPER_CAMEL.to(context.getFormat(), name);
	}

	@Override
	public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
		String key = node.getKey();
		if (IMPORT.equals(key)) {
			Value value = node.getValue();
			// Current message package
			QualifiedName name = context.getName();
			// The import message package
			QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
			// Package path that is relative to the current message package.
			QualifiedName qn = toRelativePath(name, fqn);
			// They are the same, just ignore
			if (qn.size() == 0) {
				return null;
			}
			qn = QualifiedName.of(qn.prefix(), format(qn.suffix(), context));
			return new CommonPair(IMPORT, new StringValue(qn.toString()));
		}
		return node;
	}

	@Override
	public ListType visitListType(ListType listType, MessageContext context) {
		FieldType fieldType = visitFieldType(listType.getElementType(), context);
		return new ListType(fieldType);
	}

	@Override
	public MapType visitMapType(MapType mapType, MessageContext context) {
		FieldType keyType = visitFieldType(mapType.getKeyType(), context);
		FieldType valType = visitFieldType(mapType.getValueType(), context);
		return new MapType(keyType, valType);
	}

	@Override
	public SetType visitSetType(SetType setType, MessageContext context) {
		FieldType fieldType = visitFieldType(setType.getElementType(), context);
		return new SetType(fieldType);
	}

	@Override
	public Field visitField(Field node, MessageContext context) {
		FieldType fieldType = visitFieldType(node.getType(), context);
		return new Field(node.getModifier(), node.getIndex(), node.getName(), fieldType, node.getValue(),
				node.getComments(), node.getOptions());
	}

	@Override
	public Message visitMessage(Message node, MessageContext context) {
		context.setName(node.getName());
		var options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
		var fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
		var messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
		return new Message(node.getName(), node.getComments(), fields, messages, node.getEnumerations(),
				node.getServices(), options);
	}

}
