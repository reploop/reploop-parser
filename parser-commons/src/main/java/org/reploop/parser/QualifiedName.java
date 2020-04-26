package org.reploop.parser;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

import java.util.*;

import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.concat;

/**
 * Java Qualified Name.
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-12 09
 */
public class QualifiedName implements Comparable<QualifiedName> {
    private static final char DOT = '.';
    private static final Joiner JOINER = Joiner.on(DOT).skipNulls();
    private static final Splitter SPLITTER = Splitter.on(DOT).omitEmptyStrings().trimResults();
    private final List<String> parts;

    public static QualifiedName of(List<String> parts) {
        return new QualifiedName(parts);
    }

    public static QualifiedName of(String prefix, QualifiedName suffix) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(suffix);
        return new QualifiedName(concat(SPLITTER.split(prefix), suffix.allParts()));
    }

    public static QualifiedName of(Optional<QualifiedName> prefix, String suffix) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(suffix);
        List<String> names = prefix.map(QualifiedName::allParts)
            .orElse(Collections.emptyList());
        return new QualifiedName(concat(names, SPLITTER.split(suffix)));
    }

    public static QualifiedName of(QualifiedName prefix, String suffix) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(suffix);
        return new QualifiedName(concat(prefix.allParts(), SPLITTER.split(suffix)));
    }

    public static QualifiedName of(QualifiedName prefix, QualifiedName suffix) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(suffix);
        return new QualifiedName(concat(prefix.allParts(), suffix.allParts()));
    }

    public static QualifiedName of(String suffix) {
        Preconditions.checkNotNull(suffix);
        return new QualifiedName(SPLITTER.split(suffix));
    }

    public static QualifiedName of(String first, String second, String... rest) {
        Preconditions.checkNotNull(first);
        Preconditions.checkNotNull(second);
        return new QualifiedName(copyOf(concat(SPLITTER.split(first), SPLITTER.split(second), Arrays.asList(rest))));
    }

    public static QualifiedName of(String first, String... rest) {
        Preconditions.checkNotNull(first);
        return new QualifiedName(copyOf(concat(SPLITTER.split(first), Arrays.asList(rest))));
    }

    public QualifiedName(Iterable<String> parts) {
        this.parts = copyOf(parts);
    }

    public List<String> allParts() {
        return parts;
    }

    public int size() {
        return parts.size();
    }

    public boolean endsWith(String name) {
        return toString().endsWith(name);
    }

    public boolean startsWith(String name) {
        return toString().startsWith(name);
    }

    public boolean startsWith(QualifiedName name) {
        List<String> shorts = name.allParts();
        int ss = shorts.size();
        List<String> longs = allParts();
        int ls = longs.size();
        if (ls >= ss) {
            int si = 0, li = 0;
            while (si < ss && li < ls) {
                String p = shorts.get(si);
                String t = longs.get(li);
                if (!Objects.equals(p, t)) {
                    return false;
                }
                si++;
                li++;
            }
            return true;
        }
        return false;
    }

    public boolean endsWith(QualifiedName name) {
        List<String> shorts = name.allParts();
        int ss = shorts.size();
        List<String> longs = allParts();
        int ls = longs.size();
        if (ls >= ss) {
            while (ss > 0 && ls > 0) {
                --ss;
                --ls;
                String p = shorts.get(ss);
                String t = longs.get(ls);
                if (!Objects.equals(p, t)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Optional<QualifiedName> prefix() {
        if (1 == parts.size()) {
            return Optional.empty();
        }
        return Optional.of(new QualifiedName(parts.subList(0, size() - 1)));
    }

    public Optional<QualifiedName> insertsAfter(QualifiedName prefix, String name) {
        return insertsAfter(prefix, QualifiedName.of(name));
    }


    public String partAt(int index) {
        return parts.get(index);
    }

    public Optional<QualifiedName> insertsAfter(QualifiedName prefix, QualifiedName name) {
        boolean match = true;
        int i;
        List<String> merge = new ArrayList<>(size() + name.size());
        for (i = 0; i < prefix.size(); i++) {
            String part = partAt(i);
            if (!part.equals(prefix.partAt(i))) {
                match = false;
                break;
            }
            merge.add(part);
        }
        if (match) {
            merge.addAll(name.allParts());
            for (; i < size(); i++) {
                merge.add(partAt(i));
            }
            return Optional.of(new QualifiedName(merge));
        }
        return Optional.empty();
    }

    public String suffix() {
        return Iterables.getLast(parts);
    }

    public QualifiedName replace(String target, String replacement) {
        String suffix = suffix();
        String name = suffix.replace(target, replacement);
        return of(prefix(), name);
    }

    public boolean has(String part) {
        if (null != parts) {
            for (String p : parts) {
                if (Strings.isNullOrEmpty(p)) {
                    continue;
                }
                if (p.equals(part)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QualifiedName that = (QualifiedName) o;
        return Objects.equals(parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }

    @Override
    public String toString() {
        return JOINER.join(parts);
    }

    @Override
    public int compareTo(QualifiedName o) {
        int c = Integer.compare(this.size(), o.size());
        if (0 == c) {
            c = toString().compareTo(o.toString());
        }
        return c;
    }
}
