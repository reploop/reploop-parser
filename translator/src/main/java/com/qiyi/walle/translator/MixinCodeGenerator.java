package com.qiyi.walle.translator;

import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import org.reploop.parser.Classpath;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.generator.GeneratorContext;
import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.type.CollectionType;
import org.reploop.parser.thrift.type.FieldType;
import org.reploop.parser.thrift.type.ListType;
import org.reploop.parser.thrift.type.MapType;

import java.util.List;
import java.util.Optional;

import static org.reploop.parser.thrift.generator.GeneratorContext.ONE_INDENT_CONTEXT;
import static org.reploop.parser.thrift.generator.GeneratorContext.ZERO_INDENT_CONTEXT;

/**
 * Code Generator.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-09 11
 */
public class MixinCodeGenerator extends AstVisitor<StringBuilder, GeneratorContext> {
    private StringBuilder content = new StringBuilder();
    private StringBuilder header;
    private final Classpath<ThriftProgram> ctp;
    private final Classpath<ProtoProgram> cpp;
    private static final String NEW_LINE = "\r\n";
    private static final char WHITE_SPACE = ' ';
    private static final char COMMA = ',';
    private static final char SEMI_COLON = ';';

    public MixinCodeGenerator(Classpath<ThriftProgram> ctp, Classpath<ProtoProgram> cpp) {
        this.ctp = ctp;
        this.cpp = cpp;
    }

    private StringBuilder indent(GeneratorContext context) {
        return indent(context.getIndent());
    }

    private StringBuilder indent(int indent) {
        for (int i = 0; i < indent; i++) {
            content.append(WHITE_SPACE);
        }
        return content;
    }

    private StringBuilder append(char value) {
        return content.append(value);
    }

    private StringBuilder append(String value) {
        return content.append(value);
    }

    @Override
    public StringBuilder visitField(Field node, GeneratorContext context) {
        indent(context);
        visitFieldType(node.getFieldType(), ZERO_INDENT_CONTEXT);
        indent(ONE_INDENT_CONTEXT).append(node.getName());
        return content;
    }

    @Override
    public StringBuilder visitFunctionType(FunctionType node, GeneratorContext context) {
        return process(node, context);
    }

    @Override
    public StringBuilder visitVoidType(VoidType node, GeneratorContext context) {
        return indent(context).append("void");
    }

    @Override
    public StringBuilder visitReturnType(ReturnType node, GeneratorContext context) {
        return visitFieldType(node.getFieldType(), context);
    }

    @Override
    public StringBuilder visitLiteralNode(LiteralNode node, GeneratorContext context) {
        return indent(context).append(node.getValue());
    }

    @Override
    public StringBuilder visitFieldType(FieldType ft, GeneratorContext context) {
        StringBuilder sb = indent(context).append(ft.getName());
        if (ft instanceof CollectionType) {
            FieldType rt = ((ListType) ft).getElementType();
            sb.append('<');
            visitFieldType(rt, ZERO_INDENT_CONTEXT);
            sb.append('>');
        } else if (ft instanceof MapType) {
            MapType mt = (MapType) ft;
            sb.append('<');
            visitFieldType(mt.getKeyType(), ZERO_INDENT_CONTEXT);
            sb.append(',');
            visitFieldType(mt.getValueType(), ZERO_INDENT_CONTEXT);
            sb.append('>');
        }
        return sb;
    }

    @Override
    public StringBuilder visitFunction(Function node, GeneratorContext context) {
        comments(node.getComments(), context);
        indent(context).append("public");
        visitFunctionType(node.getReturnType(), ONE_INDENT_CONTEXT);
        indent(1).append(node.getName()).append("(");
        List<Field> fields = node.getParameters();
        if (null != fields) {
            for (int i = 0; i < fields.size(); i++) {
                if (i > 0) {
                    append(COMMA).append(WHITE_SPACE);
                }
                Field field = fields.get(i);
                visitField(field, ZERO_INDENT_CONTEXT);
            }
        }
        content.append(")");
        Optional<List<Field>> exceptions = node.getExceptions();
        exceptions.ifPresent(exceptionTable -> {
            if (exceptionTable.size() > 0) {
                for (int i = 0; i < exceptionTable.size(); i++) {
                    if (i == 0) {
                        indent(ONE_INDENT_CONTEXT).append("throws");
                    } else {
                        content.append(COMMA);
                    }
                    Field field = exceptionTable.get(i);
                    visitFieldType(field.getFieldType(), ONE_INDENT_CONTEXT);
                }
            }
        });
        content.append(WHITE_SPACE).append("{").append(NEW_LINE);
        String body = node.getBody();
        if (Strings.isNullOrEmpty(body)) {
            context.indent();
            indent(context).append("ByteBuffer buff = ByteBuffer.wrap(");
            @SuppressWarnings("all")
            Field field = fields.get(0);
            content.append(field.getName()).append(".toByteArray());").append(NEW_LINE);

            indent(context).append("Connection<TTransport, InetSocketAddress> conn = getConnection();").append(NEW_LINE);
            indent(context).append("try {").append(NEW_LINE);
            context.indent();
            indent(context).append("buff = newClient(conn).").append(node.getName()).append("(buff);").append(NEW_LINE);
            indent(context).append("success(conn); ").append(NEW_LINE);
            indent(context).append("return ");
            visitFunctionType(node.getReturnType(), GeneratorContext.ZERO_INDENT_CONTEXT);
            content.append(".parseFrom(buff.array());").append(NEW_LINE);
            context.dedent();
            indent(context).append("} catch (TException e) {").append(NEW_LINE);
            context.indent();
            indent(context).append("fail(conn, e);").append(NEW_LINE);
            indent(context).append("throw e;").append(NEW_LINE);
            context.dedent();
            indent(context).append("}").append(NEW_LINE);
            context.dedent();
        } else {
            context.indent();
            String[] lines = body.split(NEW_LINE);
            for (String line : lines) {
                indent(context).append(line).append(NEW_LINE);
            }
            context.dedent();
        }
        indent(context).append("}").append(NEW_LINE).append(NEW_LINE);
        return content;
    }

    @Override
    public StringBuilder visitNamespace(Namespace node, GeneratorContext context) {
        NamespaceScope scope = node.getScope();
        if (scope.support(Lang.JAVA)) {
            indent(context).append("package").append(WHITE_SPACE).append(node.getNamespace()).append(SEMI_COLON).append(NEW_LINE);
        }
        return content;
    }

    private StringBuilder comments(List<String> comments, GeneratorContext context) {
        if (null != comments && comments.size() > 0) {
            for (String comment : comments) {
                String l;
                if (Strings.isNullOrEmpty(l = comment.trim())) {
                    continue;
                }
                if (comment.startsWith("/*")) {
                    String[] lines = comment.split("\r?\n");
                    for (int i = 0; i < lines.length; i++) {
                        String c = lines[i].trim();
                        if (Strings.isNullOrEmpty(c)) {
                            continue;
                        }
                        if (0 != i) {
                            content.append(WHITE_SPACE).append(WHITE_SPACE);
                        }
                        indent(context).append(c).append(NEW_LINE);
                    }
                } else {
                    indent(context).append(l).append(NEW_LINE);
                }
            }
        }
        return content;
    }

    private String name(Service node) {
        return node.getName().suffix() + "Adapter";
    }

    private void constructor(Service node, GeneratorContext context) {
        indent(context).append("public ").append(name(node)).append("() {").append(NEW_LINE);
        context.indent();
        String name = node.getName().suffix();
        String conf = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name)
            .replace("service", "config").toUpperCase();
        indent(context).append("this(CloudZkConfig.").append(conf).append(");").append(NEW_LINE);
        context.dedent();
        indent(context).append("}").append(NEW_LINE).append(NEW_LINE);

        indent(context).append("public ").append(name(node)).append("(RpcConfig config) {").append(NEW_LINE);
        context.indent();
        indent(context).append("super(config, ").append(node.getName()).append(".Iface.class);").append(NEW_LINE);
        context.dedent();
        indent(context).append("}").append(NEW_LINE).append(NEW_LINE);
    }

    @Override
    public StringBuilder visitService(Service node, GeneratorContext context) {
        if (null == header || header.length() == 0) {
            header = content;
        }
        content = context.code(node).append("/*").append(NEW_LINE);
        indent(context).append(" * Auto-generated by doc-maven-plugin(http://gitlab.qiyi.domain/walle/doc-maven-plugin).").append(NEW_LINE);
        indent(context).append(" *").append(NEW_LINE);
        indent(context).append(" * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING").append(NEW_LINE);
        indent(context).append(" */").append(NEW_LINE);
        indent(context).append(header);
        indent(context).append(NEW_LINE);

        indent(context).append("import com.google.protobuf.InvalidProtocolBufferException;").append(NEW_LINE);
        indent(context).append("import com.qiyi.cloud.net.pool.Connection;").append(NEW_LINE);
        indent(context).append("import com.qiyi.vrs.vis.hbase.config.RpcConfig;").append(NEW_LINE);
        indent(context).append("import com.qiyi.vrs.vis.hbase.service.QipuServiceAdapter;").append(NEW_LINE);
        indent(context).append("import com.qiyi.vrs.vis.hbase.util.CloudZkConfig;").append(NEW_LINE);
        indent(context).append("import org.apache.thrift.TException;").append(NEW_LINE);
        indent(context).append("import org.apache.thrift.transport.TTransport;").append(NEW_LINE);
        indent(context).append("import java.net.InetSocketAddress;").append(NEW_LINE);
        indent(context).append("import java.nio.ByteBuffer;").append(NEW_LINE);
        indent(context).append("import java.util.List;").append(NEW_LINE);
        indent(context).append("import java.util.Collections;").append(NEW_LINE);
        indent(context).append("import ").append(node.getName()).append(";").append(NEW_LINE);

        comments(node.getComments(), context);
        String name = name(node);
        indent(context)
            .append("public class ")
            .append(name)
            .append(" extends QipuServiceAdapter<")
            .append(node.getName().suffix())
            .append(".Iface>").append(" {").append(NEW_LINE);

        constructor(node, context.copyThenIndent());

        List<Function> functions = node.getFunctions();
        if (null != functions) {
            functions.forEach(function -> visitFunction(function, context.copyThenIndent()));
        }
        indent(context).append("}").append(NEW_LINE);
        return content;
    }


    @Override
    public StringBuilder visitHeader(Header node, GeneratorContext context) {
        return process(node, context);
    }

    @Override
    public StringBuilder visitEntity(Entity node, GeneratorContext context) {
        return process(node, context);
    }

    @Override
    public StringBuilder visitProgram(ThriftProgram node, GeneratorContext context) {
        List<Header> headers = node.getHeaders();
        if (null != headers) {
            headers.forEach(header -> visitHeader(header, context));
        }
        List<Entity> entities = node.getEntities();
        if (null != entities) {
            entities.forEach(entity -> visitEntity(entity, context));
        }
        return content;
    }
}
