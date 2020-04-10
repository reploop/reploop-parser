package org.reploop.parser.protobuf.tree;


import org.reploop.parser.protobuf.Node;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-08 17
 */
public class Options extends Node {
    List<Pair> pairs;

    public Options(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Options options = (Options) o;
        return Objects.equals(pairs, options.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairs);
    }

    @Override
    public String toString() {
        return "Options{" +
            "pairs=" + pairs +
            '}';
    }
}
