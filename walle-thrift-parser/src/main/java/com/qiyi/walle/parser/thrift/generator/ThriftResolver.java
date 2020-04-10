package com.qiyi.walle.parser.thrift.generator;

import com.qiyi.walle.parser.Classpath;
import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-09-22 15
 */
public class ThriftResolver {

    public <E extends Node> Map<Path, E> resolve(Classpath<E> cpp,
                                                 Map<Path, E> ppm,
                                                 AstVisitor<Node, Classpath<E>> resolver) {
        Map<Path, E> resolvedMap = new HashMap<>();
        for (Map.Entry<Path, E> entry : ppm.entrySet()) {
            Path file = entry.getKey();
            E program = entry.getValue();
            cpp.current(file);
            E thrift = (E) resolver.process(program, cpp);
            if (null != thrift) {
                cpp.entity(file, thrift);
                resolvedMap.put(file, thrift);
            } else {
                cpp.entities().remove(file);
                cpp.files().remove(file);
            }
        }
        return resolvedMap;
    }
}
