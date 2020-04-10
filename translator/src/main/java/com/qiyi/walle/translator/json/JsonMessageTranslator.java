package com.qiyi.walle.translator.json;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Splitter;
import com.qiyi.walle.parser.QualifiedName;
import org.reploop.parser.json.AstVisitor;
import com.qiyi.walle.parser.json.Node;
import com.qiyi.walle.parser.json.tree.DoubleVal;
import com.qiyi.walle.parser.json.tree.Entity;
import com.qiyi.walle.parser.json.tree.LongVal;
import com.qiyi.walle.parser.json.tree.Number;
import com.qiyi.walle.parser.json.tree.Pair;
import com.qiyi.walle.parser.json.tree.Value;
import com.qiyi.walle.parser.json.tree.*;
import com.qiyi.walle.parser.protobuf.tree.*;
import com.qiyi.walle.parser.protobuf.type.*;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JsonMessageTranslator extends AstVisitor<com.qiyi.walle.parser.protobuf.Node, JsonMessageContext> {
    @Override
    public com.qiyi.walle.parser.protobuf.Node visitNode(Node node, JsonMessageContext context) {
        return null;
    }

    private <M extends com.qiyi.walle.parser.protobuf.Node, N extends Node> List<M> visit(List<N> nodes, Function<N, M> visit) {
        return nodes.stream()
            .map(visit)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }


    private static final Converter<String, String> UC = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_CAMEL);
    private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

    private Pattern pattern = Pattern.compile("[-_]+");
    private Splitter splitter = Splitter.on(pattern).trimResults().omitEmptyStrings();

    private static final Map<String, String> replaces;

    static {
        Map<String, String> replace = new HashMap<>();
        replace.put("dowloadPort", "downloadPort");
        replace.put("threedflag", "threedFlag");
        replace.put("hdrtype", "hdrType");
        replace.put("colorspace", "colorSpace");
        replace.put("autocrop", "autoCrop");
        replace.put("mediainfo_v", "mediaInfo_v");
        replace.put("fanxian-version", "fanXianVersion");
        replace.put("IP", "ip");
        replace.put("httpBackurl", "httpBackUrl");
        replace.put("audioSamplerate", "audioSampleRate");
        replace.put("audioBitdepth", "audioBitDepth");
        replace.put("streamid", "streamId");
        replace.put("filesize", "fileSize");
        replaces = Collections.unmodifiableMap(replace);
    }

    private String convert(String key) {
        String val = replaces.getOrDefault(key, key);
        List<String> elements = splitter.splitToList(val);
        StringBuilder sb = new StringBuilder();
        if (elements.size() == 1) {
            sb.append(LC_UC.convert(elements.get(0)));
        } else {
            for (String element : elements) {
                sb.append(LC_UC.convert(element.toLowerCase()));
            }
        }
        return UC.convert(sb.toString());
    }

    private String strip(String val) {
        return val.trim().replace("\"", "")
            .replaceAll("\\s+", "");
    }

    private FieldType type(List<com.qiyi.walle.parser.protobuf.Node> values) {
        FieldType fieldType = null;
        for (com.qiyi.walle.parser.protobuf.Node value : values) {
            FieldType type = type(value);
            if (null == fieldType) {
                fieldType = type;
            }
            if (!type.equals(fieldType)) {
                throw new IllegalStateException("List value should of same type");
            }
        }
        if (null == fieldType) {
            // Cannot infer type from elements.
            fieldType = new StructType("Object");
        }
        return fieldType;
    }

    public FieldType type(com.qiyi.walle.parser.protobuf.Node value) {
        FieldType fieldType;
        if (value instanceof BoolValue) {
            fieldType = new BoolType();
        } else if (value instanceof com.qiyi.walle.parser.protobuf.tree.LongValue) {
            fieldType = new LongType();
        } else if (value instanceof com.qiyi.walle.parser.protobuf.tree.DoubleValue) {
            fieldType = new DoubleType();
        } else if (value instanceof StringValue) {
            fieldType = new StringType();
        } else if (value instanceof ListValue) {
            fieldType = type(((ListValue) value).getValues());
            fieldType = new ListType(fieldType);
        } else if (value instanceof StructValue) {
            fieldType = new StructType("Object");
        } else if (value instanceof Message) {
            fieldType = new StructType(((Message) value).getName());
        } else {
            fieldType = new StructType("Object");
        }
        return fieldType;
    }

    /**
     * DFS.
     */
    @Override
    public Field visitPair(Pair pair, JsonMessageContext context) {
        List<String> comments = new ArrayList<>();
        String key = strip(pair.getKey());
        String k = convert(key);
        if (!key.equals(k)) {
            comments.add("@JsonProperty(\"" + key + "\")");
        } else {
            comments.add("@JsonProperty(\"" + key + "\")");
        }
        QualifiedName name = QualifiedName.of(LC_UC.convert(k));
        FieldType fieldType = visitValue(name, pair.getValue(), context);
        return new Field(FieldModifier.required, 0, k, fieldType, Optional.empty(), comments);
    }

    private Optional<MapType> mapType(Message message) {
        List<Option> options = message.getOptions();
        if (null != options) {
            FieldType keyType = null;
            FieldType valType = null;
            for (Option option : options) {
                if (option instanceof OptionPair) {
                    OptionPair op = (OptionPair) option;
                    String on = op.getName();
                    String oa = op.getAttr();
                    com.qiyi.walle.parser.protobuf.tree.Value va = op.getValue();
                    if ("map".equals(on)) {
                        if ("key".equals(oa)) {
                            keyType = type(va);
                        } else if ("value".equals(oa)) {
                            valType = type(va);
                        }
                    }
                }
            }
            if (null != keyType && null != valType) {
                return Optional.of(new MapType(keyType, valType));
            }
        }
        return Optional.empty();
    }

    private FieldType visitValue(QualifiedName name, Value val, JsonMessageContext context) {
        context.push(name);
        com.qiyi.walle.parser.protobuf.Node value = visitValue(val, context);
        context.pop();
        FieldType fieldType = type(value);
        // Inner Class Definition.
        if (value instanceof Message) {
            Message message = (Message) value;
            Optional<MapType> o = mapType(message);
            if (o.isPresent()) {
                fieldType = o.get();
            } else {
                context.add(message.getName(), message);
                fieldType = new StructType(message.getName());
            }
        } else if (value instanceof ListValue) {
            List<com.qiyi.walle.parser.protobuf.Node> values = ((ListValue) value).getValues();
            for (com.qiyi.walle.parser.protobuf.Node node : values) {
                if (node instanceof Message) {
                    Message m = (Message) node;
                    Optional<MapType> o = mapType(m);
                    if (o.isPresent()) {
                        fieldType = new ListType(o.get());
                    } else {
                        context.add(m.getName(), m);
                    }
                }
            }
        }
        return fieldType;
    }

    @Override
    public ListValue visitArray(Array array, JsonMessageContext context) {
        return new ListValue(visit(array.getValues(), value -> visitValue(value, context)));
    }

    @Override
    public com.qiyi.walle.parser.protobuf.Node visitValue(Value value, JsonMessageContext context) {
        return process(value, context);
    }

    @Override
    public com.qiyi.walle.parser.protobuf.tree.LongValue visitLong(LongVal value, JsonMessageContext context) {
        return new com.qiyi.walle.parser.protobuf.tree.LongValue(value.getVal());
    }

    @Override
    public com.qiyi.walle.parser.protobuf.tree.DoubleValue visitDouble(DoubleVal value, JsonMessageContext context) {
        return new com.qiyi.walle.parser.protobuf.tree.DoubleValue(value.getVal());
    }

    @Override
    public BoolValue visitBool(Bool bool, JsonMessageContext context) {
        return new BoolValue(bool.getVal());
    }

    @Override
    public NullValue visitNull(Null value, JsonMessageContext context) {
        return new NullValue();
    }

    @Override
    public com.qiyi.walle.parser.protobuf.Node visitNumber(Number value, JsonMessageContext context) {
        return process(value, context);
    }

    @Override
    public StringValue visitText(Text value, JsonMessageContext context) {
        return new StringValue(value.getVal());
    }

    @Override
    public Message visitObject(Entity value, JsonMessageContext context) {
        List<Field> fields = visit(value.getPairs(), c -> visitPair(c, context));
        fields.sort(Comparator.comparing(Field::getName));

        // If the name starts with digit, then use map.
        Field f = null;
        for (Field field : fields) {
            if (Character.isDigit(field.getName().charAt(0))) {
                f = field;
                break;
            }
        }
        List<Option> options = new ArrayList<>();
        if (null != f) {
            com.qiyi.walle.parser.protobuf.tree.Value k = new StringValue(f.getType().toString());
            com.qiyi.walle.parser.protobuf.tree.Value v = f.getValue().orElse(new StringValue("Object"));
            options.add(new OptionPair("map", "key", k));
            options.add(new OptionPair("map", "value", v));
        }
        List<String> comments = new ArrayList<>();
        comments.add("@JsonIgnoreProperties(ignoreUnknown = true)");
        return new Message(context.fqn(), comments, fields, Collections.emptyList(), Collections.emptyList(), options);
    }

    @Override
    public com.qiyi.walle.parser.protobuf.Node visitJson(Json json, JsonMessageContext context) {
        Pair pair = new Pair(context.pop().toString(), json.getValue());
        Field field = visitPair(pair, context);

        Map<QualifiedName, QualifiedName> dup = dup(context);
        context.setDup(dup);

        Map<QualifiedName, Message> messages = context.messages;

        List<Message> order = new ArrayList<>(messages.values());
        order.sort(new MessageComparator());

        dup.keySet().forEach(messages::remove);
        return field;
    }

    private void dup(Map<QualifiedName, QualifiedName> replace, Message m0, Message m1) {
        List<Field> f0 = m0.getFields();
        int s0 = f0.size();
        List<Field> f1 = m1.getFields();
        int s1 = f1.size();
        Set<Field> fs = new HashSet<>();
        fs.addAll(f0);
        fs.addAll(f1);
        if (fs.size() == Math.max(s0, s1)) {
            if (s0 == s1) {
                String q0 = m0.getName().toString();
                String q1 = m1.getName().toString();
                int r = Integer.compare(q0.length(), q1.length());
                if (r > 0) {
                    replace.put(m0.getName(), m1.getName());
                } else {
                    replace.put(m1.getName(), m0.getName());
                }
            } else if (s0 > s1) {
                replace.put(m1.getName(), m0.getName());
            } else {
                replace.put(m0.getName(), m1.getName());
            }
        }
    }

    private Map<QualifiedName, QualifiedName> dup(JsonMessageContext context) {
        Map<QualifiedName, Message> messages = context.messages;
        Map<QualifiedName, QualifiedName> replace = new TreeMap<>();
        Set<QualifiedName> names = messages.keySet();
        for (QualifiedName name : names) {
            Message message = messages.get(name);
            for (QualifiedName qn : names) {
                if (name.equals(qn)) {
                    continue;
                }
                dup(replace, message, messages.get(qn));
            }
        }

        names = replace.keySet();
        for (QualifiedName name : names) {
            QualifiedName last = name;
            while (replace.containsKey(last)) {
                last = replace.get(last);
            }
            replace.put(name, last);
        }
        return replace;
    }
}
