package org.reploop.translator.json.bean;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.support.NameFormat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.reploop.translator.json.support.Constants.*;
import static org.reploop.translator.json.support.NameSupport.*;

/**
 * Rename all packages and classes names to Upper Camel Style.
 * When finished, class names are unique in the message.
 */
public class RenameResolver extends AstVisitor<Node, MessageContext> {

    private final NameFormat format = new NameFormat();

    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        if (key.equals(EXTENDS_ATTR)) {
            if (value instanceof StringValue) {
                String fqn = ((StringValue) value).getValue();
                QualifiedName qualified = QualifiedName.of(fqn);
                QualifiedName qn = rewriteQualifiedName(qualified, context);
                context.setSuperClass(qn);
                return new CommonPair(key, new StringValue(qn.toString()));
            }
        } else if (key.equals(ABSTRACT_ATTR)) {
            if (value instanceof BoolValue) {
                boolean isAbstract = ((BoolValue) value).getValue();
                context.setAbstractClass(isAbstract);
            }
        }
        return node;
    }

    @Override
    public Option visitOption(Option option, MessageContext context) {
        return (Option) process(option, context);
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

    @Override
    public StructType visitStructType(StructType structType, MessageContext context) {
        QualifiedName qn = rewriteQualifiedName(structType.getName(), context);
        return new StructType(qn);
    }

    private QualifiedName rewriteQualifiedName(QualifiedName qualifiedName, MessageContext context) {
        QualifiedName qn = toUpperCamel(qualifiedName);
        QualifiedName fqn = qn;
        Optional<QualifiedName> oqn = qn.prefix();
        if (oqn.isPresent()) {
            if (hasNameConflict(qn, context.getDependencies()) || hasNameConflict(qn, context.getName())) {
                QualifiedName prefix = oqn.get();
                // When conflicts, add prefix's last name to the full name.
                // Sort first so the name are constant.
                String suffix = Stream.of(prefix.suffix(), qn.suffix()).sorted().collect(Collectors.joining(UNDERSCORE));
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
    public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, MessageContext context) {
        FieldType ft = visitFieldType(node.getType(), context);
        String name = toLowerCamel(node.getName());
        List<Option> options = node.getOptions();
        var obs = ImmutableList.<Option>builder();
        if (null != options) {
            obs.addAll(options);
            if (ft instanceof StringType) {
                for (Option option : options) {
                    if (option instanceof CommonPair && DATE_PATTERN.equals(((CommonPair) option).getKey())) {
                        Value val = ((CommonPair) option).getValue();
                        if (val instanceof StringValue && StringUtils.isNotEmpty(((StringValue) val).getValue())) {
                            ft = new StructType(IMPORT_LOCAL_DATETIME);
                        }
                    }
                }
            }
        }
        if (!name.equals(node.getName())) {
            CommonPair pair = new CommonPair(ORIGINAL_NAME, new StringValue(node.getName()));
            obs.add(pair);
        }
        return new Field(node.getModifier(), node.getIndex(), name, ft, node.getValue(), node.getComments(), obs.build());
    }

    @Override
    public Function visitFunction(Function function, MessageContext context) {
        var requestType = visitFieldType(function.getRequestType(), context);
        var responseType = visitFieldType(function.getResponseType(), context);
        List<Option> options = visitIfPresent(function.getOptions(), option -> visitOption(option, context));
        return new Function(function.getName(), requestType, responseType, options);
    }

    @Override
    public Service visitService(Service node, MessageContext context) {
        QualifiedName qn = rewriteQualifiedName(node.getName(), context);
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        List<Function> functions = visitIfPresent(node.getFunctions(), function -> visitFunction(function, context));
        return new Service(qn, options, functions);
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, MessageContext context) {
        QualifiedName qn = rewriteQualifiedName(node.getName(), context);
        return new Enumeration(qn, node.getComments(), visitIfPresent(node.getFields(), f -> visitEnumField(f, context), EnumField.class));
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
    public Message visitMessage(Message node, MessageContext context) {
        QualifiedName name = toUpperCamel(node.getName());
        context.setName(name);
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context), Option.class);
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(), enumeration -> visitEnumeration(enumeration, context));
        List<Service> services = visitIfPresent(node.getServices(), service -> visitService(service, context));
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
