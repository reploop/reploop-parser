package org.reploop.parser.protobuf;

import com.google.common.collect.ImmutableList;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.commons.CommentHelper;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.parser.protobuf.v2.Protobuf2BaseVisitor;
import org.reploop.parser.protobuf.v2.Protobuf2Lexer;
import org.reploop.parser.protobuf.v2.Protobuf2Parser;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Protobuf AST visitor.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 09
 */
public class ProtobufAstBuilder extends Protobuf2BaseVisitor<Node> {

    CommonTokenStream tokens;

    public ProtobufAstBuilder(CommonTokenStream tokens) {
        this.tokens = tokens;
    }

    private List<String> comments(Token token) {
        return CommentHelper.comments(token, Protobuf2Lexer.HIDDEN, leftComment);
    }

    @Override
    public Node visitExtensions(Protobuf2Parser.ExtensionsContext ctx) {
        // TODO
        return super.visitExtensions(ctx);
    }

    @Override
    public Extend visitExtend(Protobuf2Parser.ExtendContext ctx) {
        String name = ctx.ID().getText();
        List<Field> fields = visit(ctx.field(), Field.class);
        return new Extend(QualifiedName.of(name), fields);
    }

    private BiFunction<Token, Integer, List<Token>> leftComment = new BiFunction<>() {
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
    public Option visitOption(Protobuf2Parser.OptionContext ctx) {
        return visit(ctx.pair(), Pair.class);
    }

    public Message visitMessage(Protobuf2Parser.MessageContext ctx) {
        String name = ctx.ID().getText();
        List<Option> options = visit(ctx.option(), Option.class);
        List<Field> fields = visit(ctx.field(), Field.class);
        List<Message> messages = visit(ctx.message(), Message.class);
        List<Enumeration> enumerations = visit(ctx.enumeration(), Enumeration.class);
        return new Message(QualifiedName.of(name), fields, messages, enumerations, options);
    }

    @Override
    public EnumField visitNameIndex(Protobuf2Parser.NameIndexContext ctx) {
        Integer index = Integer.valueOf(ctx.INT().getText());
        return new EnumField(comments(ctx.getStart()), ctx.ID().getText(), index);
    }

    @Override
    public Enumeration visitEnumeration(Protobuf2Parser.EnumerationContext ctx) {
        String name = ctx.ID().getText();
        List<EnumField> fields = visit(ctx.nameIndex(), EnumField.class);
        return new Enumeration(QualifiedName.of(name), comments(ctx.getStart()), fields);
    }

    @Override
    public Service visitService(Protobuf2Parser.ServiceContext ctx) {
        String name = ctx.ID().getText();
        List<Option> options = visit(ctx.option(), Option.class);
        List<Function> functions = visit(ctx.function(), Function.class);
        return new Service(QualifiedName.of(name), options, functions);
    }

    @Override
    public Function visitFunction(Protobuf2Parser.FunctionContext ctx) {
        String name = ctx.ID().getText();
        FieldType requestType = visitFieldType(ctx.requestType);
        FieldType responseType = visitFieldType(ctx.responseType);
        List<Option> options = visit(ctx.option(), Option.class);
        return new Function(QualifiedName.of(name), requestType, responseType, options);
    }

    @Override
    public Namespace visitNamespaceDefinition(Protobuf2Parser.NamespaceDefinitionContext ctx) {
        return visitNamespace(ctx.namespace());
    }

    @Override
    public Namespace visitNamespace(Protobuf2Parser.NamespaceContext ctx) {
        return new Namespace(ctx.ID().getText());
    }

    @Override
    public Include visitIncludeDefinition(Protobuf2Parser.IncludeDefinitionContext ctx) {
        return visitInclude(ctx.include());
    }

    @Override
    public Include visitInclude(Protobuf2Parser.IncludeContext ctx) {
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
    public FieldType visitPrimitiveType(Protobuf2Parser.PrimitiveTypeContext ctx) {
        return scalarType(ctx.ScalarType());
    }

    @Override
    public FieldType visitMessageOrEnumType(Protobuf2Parser.MessageOrEnumTypeContext ctx) {
        return new StructType(ctx.ID().getText());
    }

    @Override
    public IntValue visitIntValue(Protobuf2Parser.IntValueContext ctx) {
        return new IntValue(getInt(ctx.INT()));
    }

    @Override
    public FloatValue visitFloatValue(Protobuf2Parser.FloatValueContext ctx) {
        return new FloatValue(getFloat(ctx.FLOAT()));
    }

    @Override
    public BoolValue visitBoolValue(Protobuf2Parser.BoolValueContext ctx) {
        return new BoolValue(Boolean.valueOf(ctx.BOOL_LITERAL().getText()));
    }

    @Override
    public StringValue visitStringValue(Protobuf2Parser.StringValueContext ctx) {
        return new StringValue(ctx.STRING().getText());
    }

    @Override
    public StructValue visitStructValue(Protobuf2Parser.StructValueContext ctx) {
        return new StructValue(ctx.ID().getText());
    }

    @Override
    public CommonPair visitCommonPair(Protobuf2Parser.CommonPairContext ctx) {
        return new CommonPair(ctx.ID().getText(), visit(ctx.value(), Value.class));
    }

    @Override
    public DefaultPair visitDefaultPair(Protobuf2Parser.DefaultPairContext ctx) {
        return new DefaultPair(visit(ctx.value(), Value.class));
    }

    @Override
    public OptionPair visitOptionPair(Protobuf2Parser.OptionPairContext ctx) {
        Token attr = ctx.attr;
        if (null != attr) {
            return new OptionPair(ctx.name.getText(), ctx.attr.getText(), visit(ctx.value(), Value.class));
        } else {
            return new OptionPair(ctx.name.getText(), visit(ctx.value(), Value.class));
        }
    }

    @Override
    public Options visitMultiOptions(Protobuf2Parser.MultiOptionsContext ctx) {
        return new Options(visit(ctx.pair(), Pair.class));
    }

    public FieldType visitFieldType(Protobuf2Parser.FieldTypeContext ctx) {
        return visit(ctx, FieldType.class);
    }

    @Override
    public StringValue visitSyntaxName(Protobuf2Parser.SyntaxNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitPackageName(Protobuf2Parser.PackageNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitMessageName(Protobuf2Parser.MessageNameContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitIdName(Protobuf2Parser.IdNameContext ctx) {
        return new StringValue(ctx.ID().getText());
    }

    @Override
    public Field visitField(Protobuf2Parser.FieldContext ctx) {
        TerminalNode node = ctx.FieldModifier();
        FieldModifier modifier = FieldModifier.valueOf(node.getText());
        Optional<Options> oop = visitIfPresent(ctx.multiOptions(), Options.class);
        var obs = ImmutableList.<Option>builder();
        Optional<Value> value = Optional.empty();
        if (oop.isPresent()) {
            List<Pair> pairs = oop.get().getPairs();
            for (Pair pair : pairs) {
                obs.add(pair);
                if (pair instanceof DefaultPair) {
                    value = Optional.ofNullable(pair.getValue());
                }
            }
        }
        StringValue name = (StringValue) visit(ctx.fieldName());
        return new Field(modifier,
            getInt(ctx.INT()),
            name.getValue(),
            visitFieldType(ctx.fieldType()),
            value,
            comments(ctx.getStart()),
            obs.build());
    }

    @Override
    public ProtoProgram visitProgram(Protobuf2Parser.ProgramContext ctx) {
        return new ProtoProgram(
            comments(ctx.getStart()),
            visit(ctx.option(), Option.class),
            visit(ctx.header(), Header.class),
            visit(ctx.message(), Message.class),
            visit(ctx.enumeration(), Enumeration.class),
            visit(ctx.service(), Service.class));
    }
}
