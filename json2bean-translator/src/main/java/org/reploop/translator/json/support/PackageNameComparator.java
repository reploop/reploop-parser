package org.reploop.translator.json.support;

import org.reploop.parser.QualifiedName;

import java.util.Comparator;

public class PackageNameComparator implements Comparator<QualifiedName> {
    @Override
    public int compare(QualifiedName o1, QualifiedName o2) {
        int size = Math.min(o1.size(), o2.size());
        for (int i = 0; i < size; i++) {
            String s1 = o1.partAt(i);
            String s2 = o2.partAt(i);
            int c = s1.compareTo(s2);
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }
}
