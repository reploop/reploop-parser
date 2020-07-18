package org.reploop.parser.protobuf.generator;

import org.reploop.parser.Classpath;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;


import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-09-22 15
 */
public class ProtobufResolver {

    public <E extends Node> Map<Path, E> resolve(Classpath<E> cpp,
                                                 Map<Path, E> ppm,
                                                 AstVisitor<Node, Classpath<E>> resolver) {
        Map<Path, E> resolvedMap = new HashMap<>();
        for (Map.Entry<Path, E> entry : ppm.entrySet()) {
            Path file = entry.getKey();
            E program = entry.getValue();
            cpp.current(file);
            cpp.entity(file, program);
            @SuppressWarnings("all")
            E proto = (E) resolver.process(program, cpp);
            if (null != proto) {
                cpp.entity(file, proto);
                resolvedMap.put(file, proto);
            } else {
                cpp.entities().remove(file);
                cpp.files().remove(file);
            }
        }
        return resolvedMap;
    }
}
