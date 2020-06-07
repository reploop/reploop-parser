package org.reploop.translator.json.bean;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.NameFormat;

import java.util.List;

public class JsonNameAdapter extends AstVisitor<Node, JsonMessageContext> {

    private static final String ANNOTATION = "@JsonProperty(\"%s\")";
    private final NameFormat format = new NameFormat();

    @Override
    public Node visitNode(Node node, JsonMessageContext context) {
        return node;
    }

    @Override
    public Namespace visitNamespace(Namespace node, JsonMessageContext context) {
        return node;
    }

    @Override
    public ListType visitListType(ListType listType, JsonMessageContext context) {
        FieldType eleType = visitFieldType(listType.getElementType(), context);
        return new ListType(eleType);
    }

    @Override
    public SetType visitSetType(SetType setType, JsonMessageContext context) {
        FieldType eleType = visitFieldType(setType.getElementType(), context);
        return new SetType(eleType);
    }

    @Override
    public MapType visitMapType(MapType mapType, JsonMessageContext context) {
        FieldType keyType = visitFieldType(mapType.getKeyType(), context);
        FieldType valType = visitFieldType(mapType.getValueType(), context);
        return new MapType(keyType, valType);
    }

    @Override
    public StructType visitStructType(StructType structType, JsonMessageContext context) {
        QualifiedName qn = structType.getName();
        QualifiedName fqn = context.getIdentityName(qn).orElse(qn);
        return new StructType(toUpperCamel(fqn));
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, JsonMessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, JsonMessageContext context) {
        FieldType ft = visitFieldType(node.getType(), context);
        String name = toLowerCamel(node.getName());
        List<String> comments = node.getComments();
        if (!name.equals(node.getName())) {
            String annotation = String.format(ANNOTATION, node.getName());
            comments = ImmutableList.<String>builder().addAll(comments).add(annotation).build();
        }
        return new Field(node.getModifier(), node.getIndex(), name, ft, node.getValue(), comments);
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, JsonMessageContext context) {
        QualifiedName qn = node.getName();
        qn = context.getIdentityName(qn).orElse(qn);
        return new Enumeration(toUpperCamel(qn), node.getComments(), visitIfPresent(node.getFields(), f -> visitEnumField(f, context), EnumField.class));
    }

    public QualifiedName toLowerCamel(QualifiedName qn) {
        return to(qn, CaseFormat.LOWER_CAMEL);
    }

    public String toLowerCamel(String qn) {
        return format.format(qn, CaseFormat.LOWER_CAMEL);
    }

    public QualifiedName to(QualifiedName qn, CaseFormat cf) {
        String clazz = format.format(qn.suffix(), cf);
        return qn.prefix().map(q -> QualifiedName.of(q, clazz)).orElse(QualifiedName.of(clazz));
    }

    public QualifiedName toUpperCamel(QualifiedName qn) {
        return to(qn, CaseFormat.UPPER_CAMEL);
    }

    @Override
    public Message visitMessage(Message node, JsonMessageContext context) {
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context), Option.class);
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(), enumeration -> visitEnumeration(enumeration, context));
        List<String> comments = ImmutableList.<String>builder()
            .addAll(node.getComments())
            .add("@JsonIgnoreProperties(ignoreUnknown = true)")
            .build();
        return new Message(toUpperCamel(node.getName()), comments, fields, messages, enumerations, options);
    }
}
