package org.reploop.translator.json;


import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MessageComparatorTest {

    MessageComparator mc = new MessageComparator();

    @Test
    public void testCompare() {
        List<Field> f1 = new ArrayList<>();
        QualifiedName q1 = QualifiedName.of("org.M");
        Message m1 = new Message(q1, f1);
        List<Field> f2 = new ArrayList<>();
        QualifiedName q2 = QualifiedName.of("com.M");
        Message m2 = new Message(q2, f2);
        int i = mc.compare(m1, m2);
        assertEquals(0, i);
    }
}