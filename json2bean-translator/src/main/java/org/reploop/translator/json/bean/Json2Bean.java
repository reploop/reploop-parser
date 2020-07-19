package org.reploop.translator.json.bean;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.translator.json.ClassHierarchy;
import org.reploop.translator.json.type.FieldTypeComparator;
import org.reploop.translator.json.type.NumberSpec;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.nio.file.StandardOpenOption.*;
import static org.reploop.translator.json.bean.Support.fieldNumberSpec;

public class Json2Bean {
    private final JsonNumberTypeAdaptor numberTypeAdaptor;
    private final JsonParser parser;
    private final JsonMessageTranslator translator;
    private final Comparator<FieldType> typeComparator = new FieldTypeComparator();
    private final ClassHierarchy classHierarchy = new ClassHierarchy();
    private final JsonBeanGenerator beanGenerator = new JsonBeanGenerator();
    private final JsonNameResolver nameResolver = new JsonNameResolver();
    private final JsonFieldTypeResolver fieldTypeResolver = new JsonFieldTypeResolver();
    JsonMessageDependencyResolver dependencyResolver = new JsonMessageDependencyResolver();

    public Json2Bean() {
        this(new JsonNumberTypeAdaptor(), new JsonParser(), new JsonMessageTranslator());
    }

    public Json2Bean(JsonNumberTypeAdaptor numberTypeAdaptor, JsonParser parser, JsonMessageTranslator translator) {
        this.numberTypeAdaptor = numberTypeAdaptor;
        this.parser = parser;
        this.translator = translator;
    }

    public Field merge(Set<Field> fields) {
        int size = fields.size();
        if (0 == size) {
            return null;
        } else {
            Field field = fields.stream().max((f0, f1) -> typeComparator.compare(f0.getType(), f1.getType())).get();
            Optional<NumberSpec> spec = fieldNumberSpec(fields);
            if (spec.isPresent()) {
                FieldType ft = numberTypeAdaptor.visitFieldType(field.getType(), spec.get());
                return new Field(field.getModifier(), field.getIndex(), field.getName(), ft, field.getValue(), field.getComments());
            }
            return field;
        }
    }

    public Map<QualifiedName, Message> merge(JsonMessageContext context) {
        Map<QualifiedName, List<Message>> namedMessages = context.getNamedMessages();
        Map<QualifiedName, Message> messageMap = new TreeMap<>();
        if (null != namedMessages) {
            for (Map.Entry<QualifiedName, List<Message>> entry : namedMessages.entrySet()) {
                Map<String, Set<Field>> groups = entry.getValue().stream()
                    .map(Message::getFields)
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .collect(Collectors.groupingBy(Field::getName, Collectors.toSet()));

                List<Field> uniqueFields = groups.values().stream()
                    .map(this::merge)
                    .filter(Objects::nonNull)
                    .sorted(Comparator.comparing(Field::getName))
                    .collect(Collectors.toList());
                Message message = new Message(entry.getKey(), uniqueFields);
                messageMap.put(entry.getKey(), message);
            }
        }
        return messageMap;
    }

    public Map<QualifiedName, Message> execute(String json, JsonMessageContext context) throws IOException, URISyntaxException {
        return execute(new StringReader(json), context);
    }

    public Map<QualifiedName, Message> execute(StringReader reader, JsonMessageContext context) throws IOException, URISyntaxException {
        return execute(CharStreams.fromReader(reader), context);
    }

    private void resolveNameIfUsed(Map<QualifiedName, Message> nameMessageMap,
                                   Set<QualifiedName> all,
                                   Set<QualifiedName> deps) {
        if (null != deps && deps.size() > 0) {
            for (QualifiedName dep : deps) {
                // Message exists and did not processed
                // One class can have itself as property types.
                if (nameMessageMap.containsKey(dep) && !all.contains(dep)) {
                    all.add(dep);
                    JsonMessageContext ctx = new JsonMessageContext();
                    Message message = nameMessageMap.get(dep);
                    dependencyResolver.visitMessage(message, ctx);
                    // Process deps of this message
                    resolveNameIfUsed(nameMessageMap, all, ctx.getDependencies());
                }
            }
        }
    }

    public Map<QualifiedName, Message> execute(CharStream stream, JsonMessageContext context) throws URISyntaxException {
        Json json = (Json) parser.parse(stream, JsonBaseParser::json);
        FieldType fieldType = translator.visitJson(json, context);
        context.setFieldType(fieldType);

        Map<QualifiedName, Message> nameMessageMap = merge(context);
        // Try to aggregate class hierarchy, less duplicate code.
        classHierarchy.infer(nameMessageMap);

        // After aggregating, some messages may be useless, find used ones here.
        Set<QualifiedName> used = new HashSet<>();
        // The first message is the root and definitely will be needed somewhere.
        Set<QualifiedName> deps = new HashSet<>();
        nameMessageMap.keySet().stream().findFirst().ifPresent(deps::add);
        resolveNameIfUsed(nameMessageMap, used, deps);

        // Collect messages
        Map<QualifiedName, Message> renamed = new HashMap<>();
        // For collecting identity names
        JsonMessageContext ctx = new JsonMessageContext();
        for (QualifiedName name : used) {
            Message message = nameMessageMap.get(name);
            JsonMessageContext messageContext = new JsonMessageContext();
            Message msg = nameResolver.visitMessage(message, messageContext);
            ctx.addIdentityNames(messageContext.getIdentityNames());
            renamed.put(msg.getName(), msg);
        }

        // Final messages
        Map<QualifiedName, Message> fixed = new HashMap<>();
        renamed.forEach((name, message) -> {
            Message msg = fieldTypeResolver.visitMessage(message, ctx);
            fixed.put(msg.getName(), msg);
        });

        // used
        URL url = Json2Bean.class.getResource("/");
        System.out.println(url);
        Path root = Paths.get(url.toURI()).getParent().getParent().resolve("src/test/java");
        fixed.forEach((name, message) -> {
            JsonBeanContext beanContext = new JsonBeanContext(name);
            beanGenerator.visitMessage(message, beanContext);
            Path path = packageToPath(root, message);
            System.out.println("------>");
            System.out.println(path);
            System.out.println("------>");
            try {
                Path dir = Files.createDirectories(path.getParent());
                System.out.println(dir);
                Files.writeString(path, beanContext.toString(), TRUNCATE_EXISTING, CREATE, WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(beanContext.toString());
        });

        return nameMessageMap;
    }

    private Path packageToPath(Path root, Message msg) {
        QualifiedName qn = msg.getName();
        String filename = qn.suffix() + ".java";
        Optional<QualifiedName> oqn = qn.prefix();
        Path path = null;
        if (oqn.isPresent()) {
            List<String> parts = oqn.get().allParts();
            for (String part : parts) {
                if (isNullOrEmpty(part)) {
                    continue;
                }
                if (null == path) {
                    path = Path.of(part);
                    continue;
                }
                path = path.resolve(part);
            }
        }
        if (null == path) {
            path = Path.of(filename);
        } else {
            path = path.resolve(filename);
        }
        return root.resolve(path);
    }
}
