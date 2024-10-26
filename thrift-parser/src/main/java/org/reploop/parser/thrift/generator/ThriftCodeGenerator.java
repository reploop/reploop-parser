package org.reploop.parser.thrift.generator;

import com.google.common.base.CaseFormat;
import org.reploop.parser.Classpath;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.type.FieldType;

import java.util.List;
import java.util.Optional;

import static org.reploop.parser.thrift.generator.GeneratorContext.ONE_INDENT_CONTEXT;
import static org.reploop.parser.thrift.generator.GeneratorContext.ZERO_INDENT_CONTEXT;

/**
 * Code Generator.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-09 11
 */
public class ThriftCodeGenerator extends AstVisitor<StringBuilder, GeneratorContext> {

	private StringBuilder content = new StringBuilder();

	private StringBuilder header;

	private Classpath<ThriftProgram> classpath;

	private static final String NEW_LINE = "\r\n";

	private static final char WHITE_SPACE = ' ';

	private static final char COMMA = ',';

	private static final char SEMI_COLON = ';';

	public ThriftCodeGenerator() {
	}

	public ThriftCodeGenerator(Classpath<ThriftProgram> classpath) {
		this.classpath = classpath;
	}

	private StringBuilder indent(GeneratorContext context) {
		return indent(context.getIndent());
	}

	private StringBuilder indent(int indent) {
		content.append(String.valueOf(WHITE_SPACE).repeat(Math.max(0, indent)));
		return content;
	}

	private void append(char value) {
        content.append(value);
    }

	private StringBuilder append(String value) {
		return content.append(value);
	}

	@Override
	public StringBuilder visitFieldType(FieldType fieldType, GeneratorContext context) {
		indent(context).append(fieldType.getName());
		return content;
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
		return indent(context).append(node.getFieldType().getName());
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
					append(COMMA);
				}
				Field field = fields.get(i);
				visitField(field, ZERO_INDENT_CONTEXT);
			}
		}
		content.append(")");
		Optional<List<Field>> exceptions = node.getExceptions();
		exceptions.ifPresent(exceptionTable -> {
			if (!exceptionTable.isEmpty()) {
				for (int i = 0; i < exceptionTable.size(); i++) {
					if (i == 0) {
						indent(ONE_INDENT_CONTEXT).append("throws");
					}
					else {
						content.append(COMMA);
					}
					Field field = exceptionTable.get(i);
					visitFieldType(field.getFieldType(), ONE_INDENT_CONTEXT);
				}
			}
		});
		content.append("{").append(NEW_LINE);
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
		indent(context).append("}").append(NEW_LINE);
		return content;
	}

	@Override
	public StringBuilder visitNamespace(Namespace node, GeneratorContext context) {
		NamespaceScope scope = node.getScope();
		if (scope.support(Lang.JAVA)) {
			indent(context).append("package")
				.append(WHITE_SPACE)
				.append(node.getNamespace())
				.append(SEMI_COLON)
				.append(NEW_LINE);
		}
		return content;
	}

	private void comments(List<String> comments, GeneratorContext context) {
		if (null != comments && !comments.isEmpty()) {
			for (String comment : comments) {
				indent(context).append(comment).append(NEW_LINE);
			}
		}
    }

	private String name(Service node) {
		return node.getName().suffix() + "Adapter";
	}

	private void constructor(Service node, GeneratorContext context) {
		indent(context).append("public ").append(name(node)).append("(){").append(NEW_LINE);
		context.indent();
		String name = node.getName().suffix();
		String conf = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name)
			.replace("service", "config")
			.toUpperCase();
		indent(context).append("this(CloudZkConfig.").append(conf).append(");").append(NEW_LINE);
		context.dedent();
		indent(context).append("}").append(NEW_LINE).append(NEW_LINE);

		indent(context).append("public ").append(name(node)).append("(RpcConfig config){").append(NEW_LINE);
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
		content = context.code(node).append(header);

		indent(context).append("import com.google.protobuf.InvalidProtocolBufferException;").append(NEW_LINE);
		indent(context).append("import com.reploop.cloud.net.pool.Connection;").append(NEW_LINE);
		indent(context).append("import com.reploop.hbase.config.RpcConfig;").append(NEW_LINE);
		indent(context).append("import com.reploop.hbase.service.QipuServiceAdapter;").append(NEW_LINE);
		indent(context).append("import com.reploop.hbase.util.CloudZkConfig;").append(NEW_LINE);
		indent(context).append("import org.apache.thrift.TException;").append(NEW_LINE);
		indent(context).append("import org.apache.thrift.transport.TTransport;").append(NEW_LINE);
		indent(context).append("import java.net.InetSocketAddress;").append(NEW_LINE);
		indent(context).append("import java.nio.ByteBuffer;").append(NEW_LINE);
		indent(context).append("import ").append(node.getName()).append(";").append(NEW_LINE);

		node.getName().prefix();
		comments(node.getComments(), context);
		String name = name(node);
		indent(context).append("public class ")
			.append(name)
			.append(" extends QipuServiceAdapter<")
			.append(node.getName().suffix())
			.append(".Iface>")
			.append("{")
			.append(NEW_LINE);

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
