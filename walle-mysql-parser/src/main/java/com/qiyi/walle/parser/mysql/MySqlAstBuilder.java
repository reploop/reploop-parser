package com.qiyi.walle.parser.mysql;

import com.qiyi.walle.parser.mysql.base.MySqlParserBaseVisitor;
import com.qiyi.walle.parser.mysql.base.MySqlParser;
import com.qiyi.walle.parser.mysql.tree.*;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MySqlAstBuilder extends MySqlParserBaseVisitor<Node> {
    TokenStream tokenStream;

    public MySqlAstBuilder(TokenStream tokenStream) {
        this.tokenStream = tokenStream;
    }

    @Override
    public Node visitPreparedStatement(MySqlParser.PreparedStatementContext ctx) {
        ctx.getText();
        return super.visitPreparedStatement(ctx);
    }

    @Override
    public Node visitQueryCreateTable(MySqlParser.QueryCreateTableContext ctx) {
        return super.visitQueryCreateTable(ctx);
    }

    @Override
    public DdlStatement visitDdlStatement(MySqlParser.DdlStatementContext ctx) {
        return visit(ctx.createTable(), CreateTable.class);
    }

    @Override
    public SqlStatement visitSqlStatement(MySqlParser.SqlStatementContext ctx) {
        return visit(ctx.ddlStatement(), DdlStatement.class);
    }

    @Override
    public SqlStatements visitSqlStatements(MySqlParser.SqlStatementsContext ctx) {
        List<SqlStatement> statements = visit(ctx.sqlStatement(), SqlStatement.class);
        return new SqlStatements(statements);
    }

    @Override
    public Node visitRoot(MySqlParser.RootContext ctx) {
        return visit(ctx.sqlStatements());
    }


    private <T, C extends ParseTree> T visit(C context, Class<T> type) {
        return type.cast(visit(context));
    }

    private <T, C extends ParseTree> List<T> visit(List<C> contexts, Class<T> type) {
        if (null != contexts) {
            return contexts.stream()
                    .map(this::visit)
                    .map(type::cast)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public UID visitUid(MySqlParser.UidContext ctx) {
        return visit(ctx.simpleId(), SimpleId.class);
    }

    @Override
    public FullId visitFullId(MySqlParser.FullIdContext ctx) {
        List<UID> ids = visit(ctx.uid(), UID.class);
        return new FullId(ids);
    }

    @Override
    public TableName visitTableName(MySqlParser.TableNameContext ctx) {
        return visit(ctx.fullId(), FullId.class);
    }


    @Override
    public CreateDefinitions visitCreateDefinitions(MySqlParser.CreateDefinitionsContext ctx) {
        List<CreateDefinition> definitions = visit(ctx.createDefinition(), CreateDefinition.class);
        return new CreateDefinitions(definitions);
    }

    private Optional<String> text(TerminalNode node) {
        if (null != node) {
            return Optional.ofNullable(node.getText());
        }
        return Optional.empty();
    }

    @Override
    public SimpleId visitSimpleId(MySqlParser.SimpleIdContext ctx) {
        String id = text(ctx.ID()).get();
        return new SimpleId(id);
    }

    @Override
    public ColumnDefinition visitColumnDefinition(MySqlParser.ColumnDefinitionContext ctx) {
        DataType dataType = visit(ctx.dataType(), DataType.class);
        return new ColumnDefinition(dataType);
    }

    @Override
    public ColumnDeclaration visitColumnDeclaration(MySqlParser.ColumnDeclarationContext ctx) {
        UID uid = visitUid(ctx.uid());
        ColumnDefinition definition = visitColumnDefinition(ctx.columnDefinition());
        return new ColumnDeclaration(uid, definition);
    }

    @Override
    public ColumnCreateTable visitColumnCreateTable(MySqlParser.ColumnCreateTableContext ctx) {
        TableName tn = visit(ctx.tableName(), TableName.class);

        CreateDefinitions cd = visit(ctx.createDefinitions(), CreateDefinitions.class);
        //List<TableOption> nodes = visit(ctx.tableOption(), TableOption.class);

        ColumnCreateTable cct = new ColumnCreateTable(tn.getName(), null != ctx.TEMPORARY(), null != ctx.ifNotExists());
        cct.setDefinitions(cd.definitions);
        //cct.setOptions(nodes);
        return cct;
    }


}
