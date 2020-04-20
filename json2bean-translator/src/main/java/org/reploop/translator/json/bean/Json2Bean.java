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
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.FieldTypeComparator;
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


    public Comparator<FieldType> typeComparator = new FieldTypeComparator();

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

    public Map<QualifiedName, Message> execute(String json) throws IOException {
        return execute(new StringReader(json));
    }

    public Map<QualifiedName, Message> execute(StringReader reader) throws IOException {
        JsonMessageContext context = new JsonMessageContext("$");
        return execute(reader, context);
    }

    public Map<QualifiedName, Message> execute(StringReader reader, JsonMessageContext context) throws IOException {
        return execute(CharStreams.fromReader(reader), context);
    }

    public Map<QualifiedName, Message> execute(CharStream stream, JsonMessageContext context) {
        Json json = (Json) parser.parse(stream, JsonBaseParser::json);
        FieldType fieldType = translator.visitJson(json, context);
        context.setFieldType(fieldType);
        return merge(context);
    }
}
