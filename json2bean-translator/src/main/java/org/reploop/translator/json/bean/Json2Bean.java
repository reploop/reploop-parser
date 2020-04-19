package org.reploop.translator.json.bean;

import com.google.common.collect.Iterables;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.NumberSpec;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.max;

public class Json2Bean {
    private final FieldTypeAdaptor fieldTypeAdaptor;
    private final JsonParser parser;
    private final JsonMessageTranslator translator;

    public Json2Bean() {
        this(new FieldTypeAdaptor(), new JsonParser(), new JsonMessageTranslator());
    }

    public Json2Bean(FieldTypeAdaptor fieldTypeAdaptor, JsonParser parser, JsonMessageTranslator translator) {
        this.fieldTypeAdaptor = fieldTypeAdaptor;
        this.parser = parser;
        this.translator = translator;
    }

    private Integer valueTypeOrder(FieldType type) {
        if (type instanceof CollectionType) {
            return valueTypeOrder(((CollectionType) type).getElementType());
        }
        if (type instanceof MapType) {
            return valueTypeOrder(((MapType) type).getValueType());
        }
        if (type instanceof StructType && type.getName().endsWith("Object")) {
            return Integer.MIN_VALUE;
        }

        if (type instanceof NumberType) {
            return ((NumberType) type).bits();
        }
        return 0;
    }

    public Comparator<FieldType> typeComparator = (f0, f1) -> {
        Integer o0 = valueTypeOrder(f0);
        Integer o1 = valueTypeOrder(f1);
        return o0.compareTo(o1);
    };

    private FieldType expandValueType(FieldType fieldType) {
        if (fieldType instanceof CollectionType) {
            return expandValueType(((CollectionType) fieldType).getElementType());
        }
        if (fieldType instanceof MapType) {
            return expandValueType(((MapType) fieldType).getValueType());
        }
        return fieldType;
    }

    public Field merge(Set<Field> fields) {
        int size = fields.size();
        if (0 == size) {
            return null;
        }
        if (fields.size() == 1) {
            return Iterables.getOnlyElement(fields);
        } else {
            Field field = fields.stream().max((f0, f1) -> typeComparator.compare(f0.getType(), f1.getType())).get();

            boolean floating = false;
            int bits = 0;

            for (Field f : fields) {
                FieldType fieldType = expandValueType(f.getType());
                if (fieldType instanceof NumberType) {
                    int n = ((NumberType) fieldType).bits();
                    if (!floating && fieldType instanceof FloatingPointType) {
                        floating = true;
                    }
                    bits = max(n, bits);
                }
            }
            if (bits > 0) {
                FieldType ft = fieldTypeAdaptor.visitFieldType(field.getType(), new NumberSpec(floating, bits));
                return new Field(field.getModifier(), field.getIndex(), field.getName(), ft, field.getValue(), field.getComments());
            }
            return field;
        }
    }

    public Map<QualifiedName, Message> merge(JsonMessageContext context) {
        Map<QualifiedName, List<Message>> namedMessages = context.getNamedMessages();
        Map<QualifiedName, Message> messageMap = new HashMap<>();
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
        return messageMap;
    }

    public void execute(String json) throws IOException {
        execute(new StringReader(json));
    }

    public void execute(StringReader reader) throws IOException {
        JsonMessageContext context = new JsonMessageContext("$");
        execute(reader, context);
    }

    public void execute(StringReader reader, JsonMessageContext context) throws IOException {
        Json json = (Json) parser.parse(reader, JsonBaseParser::json);
        FieldType type = translator.visitJson(json, context);
        System.out.println(type);
        Map<QualifiedName, Message> messages = merge(context);
        messages.forEach((name, message) -> System.out.println(message));
    }

}
