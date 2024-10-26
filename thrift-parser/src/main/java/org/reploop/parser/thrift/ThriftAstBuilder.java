package org.reploop.parser.thrift;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.commons.CommentHelper;
import org.reploop.parser.thrift.base.ThriftBaseBaseVisitor;
import org.reploop.parser.thrift.base.ThriftBaseLexer;
import org.reploop.parser.thrift.tree.Enum;
import org.reploop.parser.thrift.tree.Exception;
import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.type.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.reploop.parser.thrift.base.ThriftBaseParser.*;

/**
 * Thrift AST visitor.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 12
 */
public class ThriftAstBuilder extends ThriftBaseBaseVisitor<Node> {

	private final CommonTokenStream tokens;

	public ThriftAstBuilder(CommonTokenStream tokens) {
		this.tokens = tokens;
	}

	private List<String> comments(Token token) {
		return CommentHelper.comments(token, ThriftBaseLexer.HIDDEN, leftComment);
	}

	private final BiFunction<Token, Integer, List<Token>> leftComment = new BiFunction<>() {
		@Override
		public List<Token> apply(Token token, Integer channel) {
			if (null != tokens) {
				return tokens.getHiddenTokensToLeft(token.getTokenIndex(), channel);
			}
			return Collections.emptyList();
		}
	};

	@Override
	public NamespaceScope visitNamespaceScope(NamespaceScopeContext ctx) {
		String lang = ctx.getText();
		EnumSet<Lang> scopes;
		if ("*".equals(lang)) {
			scopes = EnumSet.allOf(Lang.class);
		}
		else {
			Lang l = Lang.valueOf(lang.toUpperCase());
			scopes = EnumSet.of(l);
		}
		return new NamespaceScope(scopes);
	}

	@Override
	public Namespace visitNamespace(NamespaceContext ctx) {
		NamespaceScope scope = visitNamespaceScope(ctx.namespaceScope());
		ctx.ID().getText();
		return new Namespace(scope, ctx.ID().getText());
	}

	@Override
	public Include visitInclude(IncludeContext ctx) {
		if (null != ctx) {
			return new Include(ctx.LITERAL().getText());
		}
		return null;
	}

	@Override
	public Header visitIncludeDefinition(IncludeDefinitionContext ctx) {
		return visitInclude(ctx.include());
	}

	@Override
	public Header visitNamespaceDefinition(NamespaceDefinitionContext ctx) {
		return visitNamespace(ctx.namespace());
	}

	public Header visitHeader(HeaderContext ctx) {
		return visit(ctx, Header.class);
	}

	@Override
	public Node visitPrimitiveType(PrimitiveTypeContext ctx) {
		return visitPrimitives(ctx.primitives());
	}

	@Override
	public MapType visitMapType(MapTypeContext ctx) {
		return new MapType(visit(ctx.key, FieldType.class), visit(ctx.value, FieldType.class));
	}

	@Override
	public VoidType visitVoidType(VoidTypeContext ctx) {
		return new VoidType();
	}

	@Override
	public FunctionType visitReturnType(ReturnTypeContext ctx) {
		return new ReturnType(visit(ctx.fieldType(), FieldType.class));
	}

	public FunctionType visitFunctionType(FunctionTypeContext ctx) {
		return visit(ctx, FunctionType.class);
	}

	@Override
	public StructType visitStructType(StructTypeContext ctx) {
		return new StructType(ctx.ID().getText());
	}

	private FieldType visitFieldType(FieldTypeContext ctx) {
		return (FieldType) visit(ctx);
	}

	@Override
	public Exception visitXception(XceptionContext ctx) {
		return new Exception(ctx.ID().getText(), visit(ctx.field(), Field.class));
	}

	@Override
	public FieldType visitPrimitives(PrimitivesContext ctx) {
		String text = ctx.getText().toUpperCase();
		PrimitiveType type = PrimitiveType.valueOf(text);
		if (null != type) {
			switch (type) {
				case BOOL:
					return new BoolType();
				case BYTE:
					return new ByteType();
				case I16:
					return new ShortType();
				case I32:
					return new IntType();
				case I64:
					return new LongType();
				case BINARY:
					return new BinaryType();
				case STRING:
					return new StringType();
				case DOUBLE:
					return new DoubleType();
				default:
					throw new IllegalArgumentException("Do not support this type " + text + "right now");
			}
		}
		return null;
	}

	@Override
	public ListType visitListType(ListTypeContext ctx) {
		return new ListType(visit(ctx.element, FieldType.class));
	}

	@Override
	public SetType visitSetType(SetTypeContext ctx) {
		return new SetType(visit(ctx.element, FieldType.class));
	}

	@Override
	public Field visitField(FieldContext ctx) {
		String name = ctx.ID().getText();
		Integer fieldId = 0;
		FieldIDContext context = ctx.fieldID();
		if (null != context) {
			fieldId = (Integer.valueOf(context.INT().getText()));
		}
		TerminalNode node = ctx.FieldRequiredness();
		boolean required = (null != node
				&& Requiredness.REQUIRED == Requiredness.valueOf(node.getText().toUpperCase()));
		return new Field(comments(ctx.getStart()), visitFieldType(ctx.fieldType()), fieldId, name, required);
	}

	@Override
	public Raise visitRaise(RaiseContext ctx) {
		if (null != ctx) {
			return new Raise(visit(ctx.field(), Field.class));
		}
		return null;
	}

	@Override
	public Function visitFunction(FunctionContext ctx) {
		List<String> comments = comments(ctx.getStart());
		Optional<List<Field>> exceptions = Optional.empty();
		Raise raise = visitRaise(ctx.raise());
		if (null != raise) {
			exceptions = Optional.ofNullable(raise.getFields());
		}
		return new Function(comments, null != ctx.ONEWAY(), QualifiedName.of(ctx.ID().getText()),
				visitFunctionType(ctx.functionType()), visit(ctx.field(), Field.class), exceptions);
	}

	private <R> Optional<R> visitIfPresent(ParserRuleContext context, Class<R> clazz) {
		return Optional.ofNullable(context).map(this::visit).filter(Objects::nonNull).map(clazz::cast);
	}

	private <R> R visit(ParserRuleContext context, Class<R> clazz) {
		return clazz.cast(visit(context));
	}

	@Override
	public Service visitService(ServiceContext ctx) {
		List<String> comments = comments(ctx.getStart());
		List<Function> functions = visit(ctx.function(), Function.class);
		String name = Optional.ofNullable(ctx.ID(0)).map(ParseTree::getText).get();

		Optional<QualifiedName> parent = Optional.ofNullable(ctx.ID(1)).map(ParseTree::getText).map(QualifiedName::of);
		return new Service(parent, QualifiedName.of(name), comments, functions);
	}

	@Override
	public Struct visitStructDefinition(StructDefinitionContext ctx) {
		return visitStruct(ctx.struct());
	}

	@Override
	public Exception visitExceptionDefinition(ExceptionDefinitionContext ctx) {
		return visitXception(ctx.xception());
	}

	public Entity visitTypeDefinition(TypeDefinitionContext ctx) {
		return (Entity) visit(ctx);
	}

	@Override
	public Struct visitStruct(StructContext ctx) {
		List<String> comments = comments(ctx.getStart());
		return new Struct(ctx.ID().getText(), comments, visit(ctx.field(), Field.class));
	}

	@Override
	public Enum visitEnumeration(EnumerationContext ctx) {
		return new Enum(ctx.ID().getText(), comments(ctx.getStart()), visit(ctx.enumDef(), EnumField.class));
	}

	@Override
	public EnumField visitEnumDef(EnumDefContext ctx) {
		Optional<Integer> index = Optional.empty();
		TerminalNode node = ctx.INT();
		if (null != node) {
			index = Optional.of(Integer.valueOf(node.getText()));
		}
		return new EnumField(ctx.ID().getText(), index, comments(ctx.getStart()));
	}

	@Override
	public Entity visitTypeDefinitionDefinition(TypeDefinitionDefinitionContext ctx) {
		return visitTypeDefinition(ctx.typeDefinition());
	}

	@Override
	public Entity visitServiceDefinition(ServiceDefinitionContext ctx) {
		return visitService(ctx.service());
	}

	private <C extends ParserRuleContext, R extends Node> List<R> visit(List<C> contexts, Class<R> clazz) {
		if (null != contexts) {
			return contexts.stream()
				.map(this::visit)
				.filter(Objects::nonNull)
				.map(clazz::cast)
				.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public ThriftProgram visitProgram(ProgramContext ctx) {
		return new ThriftProgram(comments(ctx.getStart()), visit(ctx.header(), Header.class),
				visit(ctx.definition(), Entity.class));
	}

}
