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
import java.util.Set;
import java.util.stream.Collectors;

import static org.reploop.translator.json.support.Constants.*;

/**
 * Rename all packages and classes names.
 */
public class NameResolver extends AstVisitor<Node, MessageContext> {

    static final String ANNOTATION = "@JsonProperty(\"%s\")";
    static final QualifiedName IMPORT_JSON_PROPERTY = QualifiedName.of("com.fasterxml.jackson.annotation.JsonProperty");
    static final QualifiedName IMPORT_LIST = QualifiedName.of("java.util.List");
    static final QualifiedName IMPORT_SET = QualifiedName.of("java.util.Set");
    static final QualifiedName IMPORT_MAP = QualifiedName.of("java.util.Map");
    static final QualifiedName JAVA_OBJECT = QualifiedName.of("Object");
    static final QualifiedName JAVA_OBJECT_FQN = QualifiedName.of("java.lang.Object");
    private final NameFormat format = new NameFormat();

    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        if (key.equals(Constants.EXTENDS_ATTR)) {
            if (value instanceof StringValue) {
                String fqn = ((StringValue) value).getValue();
                QualifiedName qualified = QualifiedName.of(fqn);
                QualifiedName qn = rewriteQualifiedName(qualified, context);
                context.setSuperClass(qn);
                return new CommonPair(key, new StringValue(qn.toString()));
            }
        } else if (key.equals(Constants.ABSTRACT_ATTR)) {
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
        QualifiedName qn = rewriteQualifiedName(structType.getName(), context);
        return new StructType(qn);
    }

    private QualifiedName rewriteQualifiedName(QualifiedName qualifiedName, MessageContext context) {
        QualifiedName qn = toUpperCamel(qualifiedName);
        QualifiedName fqn = qn;
        Optional<QualifiedName> oqn = qn.prefix();
        if (oqn.isPresent()) {
            if (hasNameConflict(qn, context) || hasNameConflict(qn, context.getName())) {
                QualifiedName prefix = oqn.get();
                // When conflicts, add prefix's last name to the full name.
                String suffix = prefix.suffix() + Constants.UNDERSCORE + qn.suffix();
                // The new full qualified name
                fqn = toUpperCamel(QualifiedName.of(prefix, suffix));
                // Rewrite fqn later.
                context.addIdentityName(qn, fqn);
            }
            qn = QualifiedName.of(fqn.suffix());
        }
        // Add fqn to dependencies
        context.addDependency(fqn);
        return fqn;
    }

    private boolean hasNameConflict(QualifiedName qn1, QualifiedName qn2) {
        if (null == qn1 || null == qn2) {
            return false;
        }
        return !qn1.equals(qn2) && qn1.endsWith(qn2.suffix());
    }

    private boolean hasNameConflict(QualifiedName qn, MessageContext context) {
        boolean conflict = false;
        // Current deps
        Set<QualifiedName> deps = context.getDependencies();
        for (QualifiedName name : deps) {
            if (hasNameConflict(name, qn)) {
                conflict = true;
                break;
            }
        }
        return conflict;
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


    private boolean shouldExplicitImport(QualifiedName qn1, QualifiedName qn2) {
        // #0 First, java.lang.object can ignore safely
        if (qn1.equals(JAVA_OBJECT) || qn1.equals(JAVA_OBJECT_FQN)) {
            return false;
        }
        // #1 Then make sure they are not same
        if (qn1.equals(qn2)) {
            return false;
        }
        // #2 Test if same package but different class name
        int c = Integer.compare(qn1.size(), qn2.size());
        // #3 They are of same size.
        if (0 == c) {
            int s = qn1.size() - 1;
            for (int i = 0; i < s; i++) {
                String p1 = qn1.partAt(i);
                String p2 = qn2.partAt(i);
                if (!p1.equals(p2)) {
                    // #4 They are in different packages, so need import explicitly.
                    return true;
                }
            }
            // #5 Now we can tell the two in the same package, so do not need to import explicitly.
            return false;
        }
        return true;
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
        List<String> deps = context.getDependencies().stream()
                .filter(qn -> shouldExplicitImport(qn, name))
                .map(QualifiedName::toString)
                .map(s -> IMPORT + WHITESPACE + s + SEMICOLON + WHITESPACE)
                .collect(Collectors.toList());
        List<String> comments = ImmutableList.<String>builder()
                .addAll(node.getComments())
                .addAll(deps)
                .add("@JsonIgnoreProperties(ignoreUnknown = true)")
                .build();
        return new Message(name, node.getComments(), fields, messages, enumerations, services, options);
    }
}
