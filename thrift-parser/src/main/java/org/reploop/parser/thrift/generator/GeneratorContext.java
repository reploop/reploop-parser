package org.reploop.parser.thrift.generator;


import org.reploop.parser.thrift.tree.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Code Generator Context.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-05-16 17
 */
public class GeneratorContext implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(GeneratorContext.class);
    private int indent;
    private final Map<Service, StringBuilder> services;

    public static final int DEFAULT_INDENT = 4;
    public static GeneratorContext ZERO_INDENT_CONTEXT = new GeneratorContext(0, Collections.emptyMap());
    public static GeneratorContext ONE_INDENT_CONTEXT = new GeneratorContext(1, Collections.emptyMap());

    public GeneratorContext(int indent, Map<Service, StringBuilder> services) {
        this.indent = indent;
        this.services = services;
    }

    public GeneratorContext(int indent) {
        this(indent, new HashMap<>());
    }

    public GeneratorContext() {
        this(0);
    }

    public int getIndent() {
        return indent;
    }

    public Map<Service, StringBuilder> getServices() {
        return services;
    }

    public StringBuilder code(Service service) {
        return services.computeIfAbsent(service, key -> new StringBuilder());
    }

    public GeneratorContext copyThenIndent() {
        return copyThenIndent(DEFAULT_INDENT);
    }

    public GeneratorContext copyThenIndent(int indent) {
        GeneratorContext gc = copy();
        return gc.indent();
    }

    public GeneratorContext indentThenCopy() {
        return indentThenCopy(DEFAULT_INDENT);
    }

    public GeneratorContext indentThenCopy(int indent) {
        indent(indent);
        return copy();
    }

    public GeneratorContext copy() {
        return new GeneratorContext(indent, services);
    }

    public GeneratorContext indent() {
        return indent(DEFAULT_INDENT);
    }

    public GeneratorContext indent(int indent) {
        this.indent += indent;
        return this;
    }

    public GeneratorContext dedent() {
        return dedent(DEFAULT_INDENT);
    }

    public GeneratorContext dedent(int dedent) {
        this.indent -= dedent;
        return this;
    }

    @Override
    public String toString() {
        return "GeneratorContext{" +
                "indent=" + indent +
                ", services=" + services +
                '}';
    }
}
