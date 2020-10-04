package org.reploop.translator.json.bean;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.support.Constants;
import org.reploop.translator.json.support.NameFormat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Rename all packages and classes names.
 */
public class JsonNameResolver extends AstVisitor<Node, JsonMessageContext> {

    private static final String ANNOTATION = "@JsonProperty(\"%s\")";
    private static final QualifiedName IMPORT_JSON_PROPERTY = QualifiedName.of("com.fasterxml.jackson.annotation.JsonProperty");
    private static final QualifiedName IMPORT_LIST = QualifiedName.of("java.util.List");
    private static final QualifiedName IMPORT_SET = QualifiedName.of("java.util.Set");
    private static final QualifiedName IMPORT_MAP = QualifiedName.of("java.util.Map");
    private static final List<QualifiedName> AUTO_IMPORTS = List.of(IMPORT_LIST, IMPORT_JSON_PROPERTY, IMPORT_MAP, IMPORT_SET);
    private final NameFormat format = new NameFormat();

    @Override
    public Node visitNode(Node node, JsonMessageContext context) {
        return node;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, JsonMessageContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        if (key.equals(Constants.EXTENDS_ATTR)) {
            if (value instanceof StringValue) {
                String fqn = ((StringValue) value).getValue();
                QualifiedName qn = rewriteQualifiedName(QualifiedName.of(fqn), context);
                return new CommonPair(key, new StringValue(qn.toString()));
            }
        }
        return node;
    }

    @Override
    public Option visitOption(Option option, JsonMessageContext context) {
        return (Option) process(option, context);
    }

    @Override
    public ListType visitListType(ListType listType, JsonMessageContext context) {
        context.addDependency(IMPORT_LIST);
        FieldType eleType = visitFieldType(listType.getElementType(), context);
        return new ListType(eleType);
    }

    @Override
    public SetType visitSetType(SetType setType, JsonMessageContext context) {
        context.addDependency(IMPORT_SET);
        FieldType eleType = visitFieldType(setType.getElementType(), context);
        return new SetType(eleType);
    }

    @Override
    public MapType visitMapType(MapType mapType, JsonMessageContext context) {
        context.addDependency(IMPORT_MAP);
        FieldType keyType = visitFieldType(mapType.getKeyType(), context);
        FieldType valType = visitFieldType(mapType.getValueType(), context);
        return new MapType(keyType, valType);
    }

    @Override
    public StructType visitStructType(StructType structType, JsonMessageContext context) {
        QualifiedName qn = rewriteQualifiedName(structType.getName(), context);
        return new StructType(qn);
    }

    private QualifiedName rewriteQualifiedName(QualifiedName qualifiedName, JsonMessageContext context) {
        QualifiedName qn = toUpperCamel(qualifiedName);
        Optional<QualifiedName> oqn = qn.prefix();
        if (oqn.isPresent()) {
            String suffix = qn.suffix();
            QualifiedName sqn = QualifiedName.of(suffix);
            boolean conflict = false;
            for (QualifiedName name : AUTO_IMPORTS) {
                if (name.endsWith(sqn)) {
                    conflict = true;
                    break;
                }
            }
            QualifiedName fqn = qn;
            if (conflict) {
                QualifiedName prefix = oqn.get();
                // When conflicts, add prefix's last name to the full name.
                suffix = prefix.suffix() + Constants.UNDERSCORE + qn.suffix();
                // The new full qualified name
                fqn = toUpperCamel(QualifiedName.of(prefix, suffix));
                context.addIdentityName(qn, fqn);
            }
            // Add fqn to dependencies
            context.addDependency(fqn);
            qn = QualifiedName.of(fqn.suffix());
        }
        return qn;
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
            context.addDependency(IMPORT_JSON_PROPERTY);
            String annotation = String.format(ANNOTATION, node.getName());
            comments = ImmutableList.<String>builder().addAll(comments).add(annotation).build();
        }
        return new Field(node.getModifier(), node.getIndex(), name, ft, node.getValue(), comments);
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, JsonMessageContext context) {
        QualifiedName qn = node.getName();
        return new Enumeration(toUpperCamel(qn), node.getComments(), visitIfPresent(node.getFields(), f -> visitEnumField(f, context), EnumField.class));
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
        QualifiedName name = toUpperCamel(node.getName());
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context), Option.class);
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(), enumeration -> visitEnumeration(enumeration, context));
        List<String> deps = context.getDependencies().stream()
            .sorted()
            .filter(qn -> !qn.equals(name))
            .map(QualifiedName::toString)
            .map(s -> Constants.IMPORT + " " + s + "; ")
            .collect(Collectors.toList());
        List<String> comments = ImmutableList.<String>builder()
            .addAll(node.getComments())
            .addAll(deps)
            .add("@JsonIgnoreProperties(ignoreUnknown = true)")
            .build();
        return new Message(name, comments, fields, messages, enumerations, options);
    }
}
