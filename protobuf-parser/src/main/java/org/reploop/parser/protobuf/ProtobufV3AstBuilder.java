package org.reploop.parser.protobuf;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.commons.CommentHelper;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.parser.protobuf.v3.Protobuf3BaseVisitor;
import org.reploop.parser.protobuf.v3.Protobuf3Lexer;
import org.reploop.parser.protobuf.v3.Protobuf3Parser;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    @Override
    public Node visitExtend(Protobuf3Parser.ExtendContext ctx) {
        // TODO
        return super.visitExtend(ctx);
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
        return new StringValue(ctx.getText());
    }


    @Override
    public SyntaxPair visitSyntax(Protobuf3Parser.SyntaxContext ctx) {
        TerminalNode tn = Optional.ofNullable(ctx.PROTO3_SINGLE()).orElse(ctx.PROTO3_DOUBLE());
        return new SyntaxPair(tn.getText());
    }

    @Override
    public Node visitPackageStatement(Protobuf3Parser.PackageStatementContext ctx) {
        return visit(ctx.fullIdent());
    }

    @Override
    public Node visitImportStatement(Protobuf3Parser.ImportStatementContext ctx) {
        ctx.PUBLIC();
        ctx.StrLit().getText();
        return super.visitImportStatement(ctx);
    }

    @Override
    public ProtoProgram visitProto(Protobuf3Parser.ProtoContext ctx) {
        comments(ctx.getStart());
        visit(ctx.syntax(), SyntaxPair.class);
        visit(ctx.importStatement(), Option.class);
        visit(ctx.packageStatement(), Header.class);
        visit(ctx.option(), Option.class);
        visit(ctx.topLevelDef(), Message.class);
        visit(ctx.emptyStatement(), Enumeration.class);
        return null;
    }
}
