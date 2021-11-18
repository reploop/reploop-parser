package org.reploop.parser.protobuf;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.commons.CommentHelper;
import org.reploop.parser.protobuf.tree.Enumeration;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.parser.protobuf.v3.Protobuf3BaseVisitor;
import org.reploop.parser.protobuf.v3.Protobuf3Lexer;
import org.reploop.parser.protobuf.v3.Protobuf3Parser;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Protobuf V3 AST visitor.
 */
public class ProtobufV3AstBuilder extends Protobuf3BaseVisitor<Node> {

    CommonTokenStream tokens;

    public ProtobufV3AstBuilder(CommonTokenStream tokens) {
        this.tokens = tokens;
    }

    private List<String> comments(Token token) {
        return CommentHelper.comments(token, Protobuf3Lexer.HIDDEN, leftComment);
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
    public StringValue visitMessageName(Protobuf3Parser.MessageNameContext ctx) {
        visit(ctx.ident());
        return new StringValue(ctx.getText());
    }

    private static final String[] QUOTES = {"\"", "'"};

    private String stripQuote(String val) {
        for (String quote : QUOTES) {
            String v = StringUtils.strip(val, quote);
            if (v.length() != val.length()) {
                return v;
            }
        }
        return val;
    }

    @Override
    public SyntaxPair visitSyntax(Protobuf3Parser.SyntaxContext ctx) {
        TerminalNode tn = Optional.ofNullable(ctx.PROTO3_LIT_DOBULE()).orElse(ctx.PROTO3_LIT_SINGLE());
        return new SyntaxPair(stripQuote(tn.getText()));
    }

    @Override
    public Node visitPackageStatement(Protobuf3Parser.PackageStatementContext ctx) {
        return visit(ctx.fullIdent());
    }

    @Override
    public Node visitImportStatement(Protobuf3Parser.ImportStatementContext ctx) {
        TerminalNode o = Optional.ofNullable(ctx.PUBLIC()).orElse(ctx.WEAK());
        Protobuf3Parser.StrLitContext n = ctx.strLit();
        visit(ctx.strLit());
        return super.visitImportStatement(ctx);
    }

    @Override
    public IntValue visitIntLit(Protobuf3Parser.IntLitContext ctx) {
        Integer val = Integer.valueOf(ctx.INT_LIT().getText());
        return new IntValue(val);
    }

    @Override
    public IntValue visitFieldNumber(Protobuf3Parser.FieldNumberContext ctx) {
        return visitIntLit(ctx.intLit());
    }

    @Override
    public StringValue visitMapName(Protobuf3Parser.MapNameContext ctx) {
        return visitIdent(ctx.ident());
    }

    @Override
    public Field visitMapField(Protobuf3Parser.MapFieldContext ctx) {
        FieldType keyType = visit(ctx.keyType(), FieldType.class);
        FieldType valueType = visit(ctx.type_(), FieldType.class);
        MapType type = new MapType(keyType, valueType);
        IntValue iv = visitFieldNumber(ctx.fieldNumber());
        StringValue sv = visitMapName(ctx.mapName());

        return new Field(FieldModifier.optional, iv.getValue(), sv.getValue(), type, Optional.empty(), null);
    }

    @Override
    public Message visitMessageDef(Protobuf3Parser.MessageDefContext ctx) {
        StringValue sv = visitMessageName(ctx.messageName());
        QualifiedName qn = QualifiedName.of(sv.getValue());
        var bodyContext = ctx.messageBody();
        List<Protobuf3Parser.MessageElementContext> children = bodyContext.messageElement();
        List<Message> messages = new ArrayList<>();
        List<Enumeration> enumerations = new ArrayList<>();
        List<Service> services = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        List<Option> options = new ArrayList<>();
        for (var x : children) {
            // message
            visitIfPresent(x.messageDef(), Message.class).ifPresent(messages::add);
            // enum
            visitIfPresent(x.enumDef(), Enumeration.class).ifPresent(enumerations::add);
            // option
            visitOptionStatement(x.optionStatement());
            // one-of
            // Message oneOf = visitOneof(x.oneof());
            // field
            visitIfPresent(x.field(), Field.class).ifPresent(fields::add);
            // map field
            visitIfPresent(x.mapField(), Field.class).ifPresent(fields::add);
            // reserved
            x.reserved();
            // empty statement
            x.emptyStatement();
        }
        return new Message(qn, comments, fields, messages, enumerations, options);
    }

    @Override
    public Option visitOptionStatement(Protobuf3Parser.OptionStatementContext ctx) {
        return null;
    }

    @Override
    public StringValue visitKeywords(Protobuf3Parser.KeywordsContext ctx) {
        return new StringValue(ctx.getText());
    }

    @Override
    public StringValue visitIdent(Protobuf3Parser.IdentContext ctx) {
        TerminalNode tn = ctx.IDENTIFIER();
        if (null != tn) {
            String val = tn.getText();
            return new StringValue(val);
        } else {
            return visitKeywords(ctx.keywords());
        }
    }

    @Override
    public StringValue visitEnumName(Protobuf3Parser.EnumNameContext ctx) {
        return visitIdent(ctx.ident());
    }

    @Override
    public Enumeration visitEnumDef(Protobuf3Parser.EnumDefContext ctx) {
        List<String> comments = new ArrayList<>();
        StringValue sv = visitEnumName(ctx.enumName());
        QualifiedName qn = QualifiedName.of(sv.getValue());
        List<EnumField> fields = new ArrayList<>();
        List<Option> options = new ArrayList<>();
        var elements = ctx.enumBody().enumElement();
        for (var element : elements) {
            visitIfPresent(element.enumField(), EnumField.class).ifPresent(fields::add);
            visitIfPresent(element.optionStatement(), Option.class).ifPresent(options::add);
        }
        return new Enumeration(qn, comments, fields);
    }

    @Override
    public Service visitServiceDef(Protobuf3Parser.ServiceDefContext ctx) {
        return null;
    }

    @Override
    public ProtoProgram visitProto(Protobuf3Parser.ProtoContext ctx) {
        comments(ctx.getStart());
        visit(ctx.syntax(), SyntaxPair.class);
        visit(ctx.importStatement(), Option.class);
        visit(ctx.packageStatement(), Header.class);
        visit(ctx.optionStatement(), Option.class);
        visit(ctx.topLevelDef(), Message.class);
        visit(ctx.emptyStatement(), Enumeration.class);
        return null;
    }
}
