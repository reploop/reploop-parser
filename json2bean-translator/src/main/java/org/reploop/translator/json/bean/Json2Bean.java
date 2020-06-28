package org.reploop.translator.json.bean;

import com.google.common.collect.Iterables;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.tree.Namespace;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.translator.json.ClassHierarchy;
import org.reploop.translator.json.type.FieldTypeComparator;
import org.reploop.translator.json.type.NumberSpec;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static org.reploop.translator.json.bean.Support.customTypeName;
import static org.reploop.translator.json.bean.Support.fieldNumberSpec;

public class Json2Bean {
    private final JsonNumberTypeAdaptor numberTypeAdaptor;
    private final JsonParser parser;
    private final JsonMessageTranslator translator;
    private final Comparator<FieldType> typeComparator = new FieldTypeComparator();
    private final ClassHierarchy classHierarchy = new ClassHierarchy();
    private final JsonBeanGenerator beanGenerator = new JsonBeanGenerator();
    private final JsonNameResolver nameResolver = new JsonNameResolver();

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
        } else if (1 == size) {
            return Iterables.getOnlyElement(fields);
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

    public Map<QualifiedName, Message> execute(String json, JsonMessageContext context) throws IOException {
        return execute(new StringReader(json), context);
    }

    public Map<QualifiedName, Message> execute(StringReader reader, JsonMessageContext context) throws IOException {
        return execute(CharStreams.fromReader(reader), context);
    }

    JsonMessageDependencyResolver dependencyResolver = new JsonMessageDependencyResolver();

    public Map<QualifiedName, Message> execute(CharStream stream, JsonMessageContext context) {
        Json json = (Json) parser.parse(stream, JsonBaseParser::json);
        FieldType fieldType = translator.visitJson(json, context);
        context.setFieldType(fieldType);
        Optional<QualifiedName> of = customTypeName(fieldType);
        Map<QualifiedName, Message> nameMessageMap = merge(context);
        // Try to aggregate class hierarchy, less duplicate code.
        classHierarchy.infer(nameMessageMap);
        Set<QualifiedName> names = new HashSet<>();
        for (Map.Entry<QualifiedName, Message> entry : nameMessageMap.entrySet()) {
            JsonMessageContext ctx0 = new JsonMessageContext();
            dependencyResolver.visitMessage(entry.getValue(), ctx0);
            Set<QualifiedName> deps = ctx0.getDependencies();
            if (0 == deps.size()) {
                break;
            }
            names.addAll(deps);
        }
        System.out.println(names);
        JsonMessageContext ctx1 = new JsonMessageContext();
        nameMessageMap.forEach((name, message) -> {
            JsonBeanContext ctx = new JsonBeanContext(name);
            Message msg = nameResolver.visitMessage(message, ctx1);
            beanGenerator.visitMessage(msg, ctx);
            System.out.println(ctx.toString());
        });
        return nameMessageMap;
    }
}
