package org.reploop.translator.json.support;

import org.junit.Test;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FieldModifier;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.StringType;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageInferTest {

    @Test
    public void maxArea() {
        MessageInfer infer = new MessageInfer();
        Map<QualifiedName, Message> nameMessageMap = new HashMap<>();
        QualifiedName qn1 = QualifiedName.of("org.reploop.Main");
        List<Field> fields = new ArrayList<>();
        Field f1 = new Field(FieldModifier.required, 0, "name", new StringType(), Optional.empty(), Collections.emptyList());
        Field f2 = new Field(FieldModifier.required, 0, "id", new StringType(), Optional.empty(), Collections.emptyList());
        Field f3 = new Field(FieldModifier.required, 0, "version", new StringType(), Optional.empty(), Collections.emptyList());

        fields.add(f1);
        fields.add(f2);
        fields.add(f3);
        Message m1 = new Message(qn1, fields);

        nameMessageMap.put(qn1, m1);

        QualifiedName qn2 = QualifiedName.of("org.reploop.Entry");
        List<Field> fields2 = new ArrayList<>();
        Field f21 = new Field(FieldModifier.required, 0, "name", new StringType(), Optional.empty(), Collections.emptyList());
        Field f22 = new Field(FieldModifier.required, 0, "id", new StringType(), Optional.empty(), Collections.emptyList());

        fields2.add(f21);
        fields2.add(f22);
        Message m2 = new Message(qn2, fields2);

        nameMessageMap.put(qn2, m2);


        Optional<Rect> or = infer.maxArea(nameMessageMap);
        assertThat(or).isNotNull();
        assertThat(or.isPresent()).isTrue();
        Rect rect = or.get();

        Optional<Parent> superInfo = infer.analyze(nameMessageMap);
        assertThat(superInfo.isPresent()).isTrue();
    }
}