package com.qiyi.walle.parser.ast;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAstVisitor<R, N, C> {

    public <O extends N> List<O> visitIfPresent(List<O> nodes, Function<O, O> visitor) {
        if (null == nodes) {
            return Collections.emptyList();
        }
        return nodes
            .stream()
            .map(visitor)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    }

    public abstract R process(N node, C context);
}
