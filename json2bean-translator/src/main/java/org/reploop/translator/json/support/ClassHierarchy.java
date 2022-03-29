package org.reploop.translator.json.support;

import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.bean.DupTypeResolver;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.reploop.translator.json.support.Constants.*;
import static org.reploop.translator.json.support.TypeSupport.customTypeName;

/**
 * Try to analyze class hierarchy to avoid duplicated classes.
 */
public class ClassHierarchy {

    private final DupTypeResolver fieldTypeResolver;

    public ClassHierarchy() {
        this(new DupTypeResolver());
    }

    public ClassHierarchy(DupTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    /**
     * From bottom up
     */
    private final Comparator<Message> messageComparator = (o1, o2) -> o2.getName().compareTo(o1.getName());

    public void infer(Map<QualifiedName, Message> messageMap) {
        // All names
        Set<QualifiedName> keys = new HashSet<>(messageMap.keySet());
        Optional<Parent> op = infer0(messageMap);
        if (op.isPresent()) {
            Parent parent = op.get();
            // Merged names, should exclude from original collection.
            Set<QualifiedName> names = parent.getMessages().stream().map(Entity::getName).collect(toSet());

            Map<QualifiedName, Message> freshMap = keys.stream()
                .filter(qn -> !names.contains(qn))
                .collect(toMap(qn -> qn, messageMap::get));
            // Exclude messages, infer messages again.
            infer(freshMap);
            // Merge abstract messages
            messageMap.putAll(freshMap);
        }
    }

    private Optional<Parent> infer0(Map<QualifiedName, Message> messageMap) {
        MessageInfer infer = new MessageInfer();
        Optional<Parent> op = infer.analyze(messageMap);
        Map<QualifiedName, QualifiedName> same = new HashMap<>();
        if (op.isPresent()) {
            Parent p = op.get();
            // Fields may be in parent class
            Set<Field> fields = p.getFields();
            // Messages may have common parent class
            List<Message> messages = p.getMessages();
            // Handle the deepest level message first.
            messages.sort(messageComparator);
            // Message will extend the parent
            Message parent = null;
            QualifiedName name;

            List<Message> subClasses = new ArrayList<>();
            for (Message message : messages) {
                QualifiedName qn = message.getName();
                List<Field> sub = message.getFields().stream()
                    .filter(field -> !fields.contains(field))
                    .collect(toList());
                // Same as parent, we make this message as parent  without modifying its name.
                if (sub.isEmpty()) {
                    if (null == parent) {
                        parent = message;
                    } else {
                        // They are same, replace them with parent class.
                        same.put(qn, parent.getName());
                    }
                } else {
                    Message child = new Message(qn, message.getComments(), sub, message.getMessages(), message.getEnumerations(), message.getServices(), message.getOptions());
                    subClasses.add(child);
                    // Update the message
                    messageMap.put(qn, child);
                }
            }
            if (null == parent) {
                name = parentName(p);
                // Add options
                List<Option> ops = ImmutableList.of(new CommonPair(ABSTRACT_ATTR, new BoolValue(true)));
                parent = new Message(name, new ArrayList<>(fields), Collections.emptyList(), Collections.emptyList(), ops);
            } else {
                name = parent.getName();
                // Only 2 Fields
                if (subClasses.isEmpty() && fields.size() < 3) {
                    QualifiedName parentName = parentName(p);
                    parent = new Message(parentName, parent.getComments(), parent.getFields(), parent.getMessages(), parent.getEnumerations(), parent.getServices(), parent.getOptions());
                    same.put(name, parentName);
                    messageMap.put(parentName, parent);
                }
            }
            if (!subClasses.isEmpty()) {
                // Add options
                for (Message sub : subClasses) {
                    ImmutableList.Builder<Option> lb = ImmutableList.<Option>builder()
                        .add(new CommonPair(EXTENDS_ATTR, new StringValue(name.toString())));
                    List<Option> options = sub.getOptions();
                    if (null != options) {
                        lb.addAll(options);
                    }
                    Message m = new Message(sub.getName(), sub.getComments(), sub.getFields(), sub.getMessages(), sub.getEnumerations(), sub.getServices(), lb.build());
                    messageMap.put(m.getName(), m);
                }

                // If parent and subclasses are same actually, we eliminate some useless entities.
                reduce(parent, subClasses, messageMap, same);
            }

            // Rewrite same entities
            if (same.size() > 0) {
                rewrite(messageMap, same);
            }
            messageMap.put(name, parent);
        }
        return op;
    }

    private QualifiedName commonParent(List<Message> messages) {
        List<QualifiedName> names = Stream.of(messages)
            .flatMap(Collection::stream)
            .map(Entity::getName)
            .collect(Collectors.toList());

        List<String> parts = new ArrayList<>();
        for (int i = 0; names.size() > 0; i++) {
            String part = null;
            boolean samePrefix = true;
            for (QualifiedName qn : names) {
                int size = qn.size();
                if (i >= size) {
                    samePrefix = false;
                    break;
                }
                if (null == part) {
                    part = qn.partAt(i);
                    continue;
                }
                if (!part.equals(qn.partAt(i))) {
                    samePrefix = false;
                    break;
                }
            }
            if (!samePrefix) {
                break;
            }
            if (null != part) {
                parts.add(part);
            }
        }
        return QualifiedName.of(parts);
    }

    private QualifiedName parentName(Parent info) {
        List<Message> messages = info.getMessages();
        // Message name space.
        QualifiedName qn = commonParent(messages);

        Set<Field> fields = info.getFields();
        // If parent class has less than 3 fields, try to generate a class name from fields.
        // like Key-Value, Name-ID
        if (fields.size() < 3) {
            String name0 = Stream.of(fields)
                .flatMap(Collection::stream)
                .map(Field::getName)
                .sorted()
                .collect(Collectors.joining(UNDERSCORE));
            return QualifiedName.of(qn, name0);
        }
        // Try to generate parent class name from message names
        String name = Stream.of(messages)
            .flatMap(Collection::stream)
            .map(Entity::getName)
            .map(QualifiedName::suffix)
            .sorted()
            .limit(2)
            .collect(Collectors.joining(UNDERSCORE));
        return QualifiedName.of(qn, name);
    }

    private void rewrite(Map<QualifiedName, Message> messageMap, Map<QualifiedName, QualifiedName> identityNames) {
        MessageContext context = new MessageContext();
        context.addIdentityNames(identityNames);
        messageMap.forEach((name, message) -> {
            Message msg = fieldTypeResolver.visitMessage(message, context);
            messageMap.put(msg.getName(), msg);
        });
    }

    /**
     * Try to analyze self-included class and merge them as one class.
     *
     * @param parent     the parent class
     * @param subClasses the sub classes
     * @param messageMap all the message map
     * @param sameMap    same message map
     */
    private void reduce(Message parent,
                        List<Message> subClasses,
                        Map<QualifiedName, Message> messageMap,
                        Map<QualifiedName, QualifiedName> sameMap) {
        // From bottom up
        List<Message> messages = subClasses.stream()
            .sorted(messageComparator)
            .collect(toList());
        MessageContext ctx = new MessageContext();
        ctx.addIdentityNames(sameMap);
        for (Message message : messages) {
            Message msg = fieldTypeResolver.visitMessage(message, ctx);
            Optional<Message> om = reduce(parent, msg, messageMap);
            if (om.isPresent()) {
                parent = om.get();
            }
        }
    }

    private Optional<Message> reduce(Message parent, Message sub,
                                     Map<QualifiedName, Message> messageMap) {
        List<Field> fields = sub.getFields();
        if (null == fields || fields.size() != 1) {
            return Optional.empty();
        }
        // The only field
        Field field = fields.get(0);
        Optional<QualifiedName> oq = customTypeName(field.getType());
        // A class has only one field and the field's type is same as it's parent, then we consider this class can be parent.
        boolean same = oq.filter(qn -> qn.equals(parent.getName())).isPresent();
        if (same) {
            MessageContext ctx = new MessageContext(sub.getName());
            // Parent is same as this message after fields merging.
            ctx.addIdentityName(parent.getName(), sub.getName());
            List<Field> merge = ImmutableList.<Field>builder()
                .add(field)
                .addAll(parent.getFields())
                .build();
            List<Field> list = merge.stream()
                .map(f -> fieldTypeResolver.visitField(f, ctx))
                .distinct()
                .collect(toList());
            Message msg = new Message(sub.getName(), sub.getComments(), list, sub.getMessages(), sub.getEnumerations(), sub.getServices(), sub.getOptions());
            messageMap.put(msg.getName(), msg);
            return Optional.of(msg);
        }
        return Optional.empty();
    }
}
