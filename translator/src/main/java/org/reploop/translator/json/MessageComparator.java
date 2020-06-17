package org.reploop.translator.json;


import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.util.*;
import java.util.stream.Collectors;

public class MessageComparator implements Comparator<Message> {
    private List<String> names(List<Field> fields) {
        if (null != fields) {
            return fields.stream()
                .map(Field::getName)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public int compare(Message o1, Message o2) {
        List<String> n1 = names(o1.getFields());
        List<String> n2 = names(o2.getFields());

        // union  set of names.
        Set<String> n = new HashSet<>();
        n.addAll(n1);
        n.addAll(n2);

        // n1 contains n2 or n2 contains n1, so they are equal.
        if (n.size() == n1.size() || n.size() == n2.size()) {
            return 0;
        }
        // just compare ths size of the two.
        return n1.size() - n2.size();
    }
}
