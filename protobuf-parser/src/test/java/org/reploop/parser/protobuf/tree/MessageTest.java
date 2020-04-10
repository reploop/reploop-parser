package org.reploop.parser.protobuf.tree;

import org.testng.annotations.Test;

import java.util.Comparator;

public class MessageTest {

    @Test
    public void testGetFields() {

        Comparator<Message> messageComparator = new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return 0;
            }
        };
    }
}