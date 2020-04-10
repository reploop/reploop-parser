package org.reploop.parser.protobuf;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.commons.CommentHelper;
import com.qiyi.walle.parser.protobuf.base.ProtobufBaseBaseVisitor;
import com.qiyi.walle.parser.protobuf.base.ProtobufBaseLexer;
import com.qiyi.walle.parser.protobuf.base.ProtobufBaseParser;
import com.qiyi.walle.parser.protobuf.tree.*;
import com.qiyi.walle.parser.protobuf.type.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Protobuf AST visitor.
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 09
 */
public class ProtobufAstBuilder extends ProtobufBaseBaseVisitor<Node> {

    CommonTokenStream tokens;

    public ProtobufAstBuilder(CommonTokenStream tokens) {
        this.tokens = tokens;
    }

    private List<String> comments(Token token) {
        return CommentHelper.comments(token, ProtobufBaseLexer.HIDDEN, leftComment);
    }

    @Override
    public Node visitExtensions(ProtobufBaseParser.ExtensionsContext ctx) {
        // TODO
        return super.visitExtensions(ctx);
    }

    @Override
    public Node visitExtend(ProtobufBaseParser.ExtendContext ctx) {
        // TODO
        return super.visitExtend(ctx);
    }

    private BiFunction<Token, Integer, List<Token>> leftComment = new BiFunction<Token, Integer, List<Token>>() {
        @Override
        public List<Token> apply(Token token, Integer channel) {
            if (null != tokens) {
                return tokens.getHiddenTokensToLeft(token.getTokenIndex(), channel);
            }
            return Collections.emptyList();
        }
    };

    private <R> R visit(ParserRuleContext context, Class<R> clazz) {
        return clazz.cast(visit(context));
    }

    private <R> Optional<R> visitIfPresent(ParserRuleContext context, Class<R> clazz) {
        return Optional.ofNullable(context)
                .map(this::visit)
                .filter(Objects::nonNull)
                .map(clazz::cast);
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
    public Option visitOption(ProtobufBaseParser.OptionContext ctx) {
        return visit(ctx.pair(), Pair.class);
    }

    public Message visitMessage(ProtobufBaseParser.MessageContext ctx) {
        String name = ctx.ID().getText();
        List<Option> options = visit(ctx.option(), Option.class);
        List<Field> fields = visit(ctx.field(), Field.class);
        List<Message> messages = visit(ctx.message(), Message.class);
        List<Enumeration> enumerations = visit(ctx.enumeration(), Enumeration.class);
        return new Message(QualifiedName.of(name), fields, messages, enumerations, options);
    }

    @Override
    public EnumField visitNameIndex(ProtobufBaseParser.NameIndexContext ctx) {
        Integer index = Integer.valueOf(ctx.INT().getText());
        return new EnumField(comments(ctx.getStart()), ctx.ID().getText(), index);
    }

    @Override
    public Enumeration visitEnumeration(ProtobufBaseParser.EnumerationContext ctx) {
        String name = ctx.ID().getText();
        List<EnumField> fields = visit(ctx.nameIndex(), EnumField.class);
        return new Enumeration(QualifiedName.of(name), comments(ctx.getStart()), fields);
    }

    @Override
    public Service visitService(ProtobufBaseParser.ServiceContext ctx) {
        String name = ctx.ID().getText();
        List<Option> options = visit(ctx.option(), Option.class);
        List<Function> functions = visit(ctx.function(), Function.class);
        return new Service(QualifiedName.of(name), options, functions);
    }

    @Override
    public Function visitFunction(ProtobufBaseParser.FunctionContext ctx) {
        String name = ctx.ID().getText();
        FieldType requestType = visitFieldType(ctx.requestType);
        FieldType responseType = visitFieldType(ctx.responseType);
        List<Option> options = visit(ctx.option(), Option.class);
        return new Function(QualifiedName.of(name), requestType, responseType, options);
    }

    @Override
    public Namespace visitNamespaceDefinition(ProtobufBaseParser.NamespaceDefinitionContext ctx) {
        return visitNamespace(ctx.namespace());
    }

    @Override
    public Namespace visitNamespace(ProtobufBaseParser.NamespaceContext ctx) {
        return new Namespace(ctx.ID().getText());
    }

    @Override
    public Include visitIncludeDefinition(ProtobufBaseParser.IncludeDefinitionContext ctx) {
        return visitInclude(ctx.include());
    }

    @Override
    public Include visitInclude(ProtobufBaseParser.IncludeContext ctx) {
        return new Include(ctx.STRING().getText());
    }

    private Float getFloat(TerminalNode node) {
        return Float.valueOf(node.getText());
    }

    private Integer getInt(TerminalNode node) {
        return Integer.valueOf(node.getText());
    }

    private FieldType scalarType(TerminalNode node) {
        String text = node.getText();
        ScalarType type = ScalarType.valueOf(text.toUpperCase());
        switch (type) {
            case BOOL:
                return new BoolType();
            case INT32:
            case FIXED32:
            case SFIXED32:
            case SINT32:
            case UINT32:
                return new IntType();
            case INT64:
            case FIXED64:
            case SFIXED64:
            case SINT64:
            case UINT64:
                return new LongType();
            case FLOAT:
                return new FloatType();
            case DOUBLE:
                return new DoubleType();
            case STRING:
                return new StringType();
            case BYTES:
                return new ByteStringType();
            default:
                throw new IllegalArgumentException("");
        }
    }

    @Override
    public FieldType visitPrimitiveType(ProtobufBaseParser.PrimitiveTypeContext ctx) {
        return scalarType(ctx.ScalarType());
    }

    @Override
    public FieldType visitMessageOrEnumType(ProtobufBaseParser.MessageOrEnumTypeContext ctx) {
        return new StructType(ctx.ID().getText());
    }

    @Override
    public IntValue visitIntValue(ProtobufBaseParser.IntValueContext ctx) {
        return new IntValue(getInt(ctx.INT()));
    }

    @Override
    public FloatValue visitFloatValue(ProtobufBaseParser.FloatValueContext ctx) {
        return new FloatValue(getFloat(ctx.FLOAT()));
    }

    @Override
    public BoolValue visitBoolValue(ProtobufBaseParser.BoolValueContext ctx) {
        return new BoolValue(Boolean.valueOf(ctx.BOOL_LITERAL().getText()));
    }

    @Override
    public StringValue visitStringValue(ProtobufBaseParser.StringValueContext ctx) {
        return new StringValue(ctx.STRING().getText());
    }

    @Override
    public StructValue visitStructValue(ProtobufBaseParser.StructValueContext ctx) {
        return new StructValue(ctx.ID().getText());
    }

    @Override
    public CommonPair visitCommonPair(ProtobufBaseParser.CommonPairContext ctx) {
        return new CommonPair(ctx.ID().getText(), visit(ctx.value(), Value.class));
    }

    @Override
    public DefaultPair visitDefaultPair(ProtobufBaseParser.DefaultPairContext ctx) {
        return new DefaultPair(visit(ctx.value(), Value.class));
    }

    @Override
    public OptionPair visitOptionPair(ProtobufBaseParser.OptionPairContext ctx) {
        Token attr = ctx.attr;
        if (null != attr) {
            return new OptionPair(ctx.name.getText(), ctx.attr.getText(), visit(ctx.value(), Value.class));
        } else {
            return new OptionPair(ctx.name.getText(), visit(ctx.value(), Value.class));
        }
    }

    @Override
    public Options visitMultiOptions(ProtobufBaseParser.MultiOptionsContext ctx) {
        return new Options(visit(ctx.pair(), Pair.class));
    }

    public FieldType visitFieldType(ProtobufBaseParser.FieldTypeContext ctx) {
        return visit(ctx, FieldType.class);
    }

    @Override
    public StringValue visitSyntaxName(ProtobufBaseParser.SyntaxNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitPackageName(ProtobufBaseParser.PackageNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitMessageName(ProtobufBaseParser.MessageNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitIdName(ProtobufBaseParser.IdNameContext ctx) {
        return new StringValue(ctx.ID().getText());
    }

    @Override
    public Field visitField(ProtobufBaseParser.FieldContext ctx) {
        TerminalNode node = ctx.FieldModifier();
        FieldModifier modifier = FieldModifier.valueOf(node.getText());
        Optional<Options> options = visitIfPresent(ctx.multiOptions(), Options.class);
        Optional<Value> value = Optional.empty();
        if (options.isPresent()) {
            List<Pair> pairs = options.get().getPairs();
            for (Pair pair : pairs) {
                if (pair instanceof DefaultPair) {
                    value = Optional.ofNullable(pair.getValue());
                    break;
                }
            }
        }
        StringValue name = (StringValue) visit(ctx.fieldName());
        return new Field(modifier,
                getInt(ctx.INT()),
                name.getValue(),
                visitFieldType(ctx.fieldType()),
                value,
                comments(ctx.getStart()));
    }

    @Override
    public ProtoProgram visitProgram(ProtobufBaseParser.ProgramContext ctx) {
        return new ProtoProgram(
                comments(ctx.getStart()),
                visit(ctx.option(), Option.class),
                visit(ctx.header(), Header.class),
                visit(ctx.message(), Message.class),
                visit(ctx.enumeration(), Enumeration.class),
                visit(ctx.service(), Service.class));
    }
}
