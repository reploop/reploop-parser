package org.reploop.parser.mysql;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.mysql.base.MySQLParser;
import org.reploop.parser.mysql.base.MySQLParserBaseVisitor;
import org.reploop.parser.mysql.tree.ColumnCreateTable;
import org.reploop.parser.mysql.tree.ColumnDeclaration;
import org.reploop.parser.mysql.tree.ColumnDefinition;
import org.reploop.parser.mysql.tree.CreateDefinition;
import org.reploop.parser.mysql.tree.CreateTable;
import org.reploop.parser.mysql.tree.DataType;
import org.reploop.parser.mysql.tree.DdlStatement;
import org.reploop.parser.mysql.tree.FullId;
import org.reploop.parser.mysql.tree.Node;
import org.reploop.parser.mysql.tree.SimpleId;
import org.reploop.parser.mysql.tree.SqlStatement;
import org.reploop.parser.mysql.tree.SqlStatements;
import org.reploop.parser.mysql.tree.TableName;
import org.reploop.parser.mysql.tree.UID;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class MySqlAstBuilder extends MySQLParserBaseVisitor<Node> {

	final TokenStream tokenStream;

	public MySqlAstBuilder(TokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}

	@Override
	public Node visitPreparedStatement(MySQLParser.PreparedStatementContext ctx) {
		ctx.getText();
		return super.visitPreparedStatement(ctx);
	}

	@Override
	public Node visitSimpleSelect(MySQLParser.SimpleSelectContext ctx) {
		Node node = visitQuerySpecification(ctx.querySpecification());
		var ln = visitIfPresent(ctx.lockClause(), Node.class);
		return super.visitSimpleSelect(ctx);
	}

	@Override
	public Node visitQueryCreateTable(MySQLParser.QueryCreateTableContext ctx) {
		return super.visitQueryCreateTable(ctx);
	}

	@Override
	public DdlStatement visitDdlStatement(MySQLParser.DdlStatementContext ctx) {
		return visit(ctx.createTable(), CreateTable.class);
	}

	@Override
	public SqlStatement visitSqlStatement(MySQLParser.SqlStatementContext ctx) {
		return visit(ctx.ddlStatement(), DdlStatement.class);
	}

	@Override
	public SqlStatements visitSqlStatements(MySQLParser.SqlStatementsContext ctx) {
		List<SqlStatement> statements = visit(ctx.sqlStatement(), SqlStatement.class);
		return new SqlStatements(statements);
	}

	@Override
	public Node visitRoot(MySQLParser.RootContext ctx) {
		return visit(ctx.sqlStatements());
	}

	private <T, C extends ParseTree> T visit(C context, Class<T> type) {
		return type.cast(visit(context));
	}

	private <T, C extends ParseTree> Optional<T> visitIfPresent(C context, Class<T> type) {
		T val = null;
		if (nonNull(context)) {
			val = type.cast(visit(context));
		}
		return Optional.ofNullable(val);
	}

	private <T, C extends ParseTree> List<T> visit(List<C> contexts, Class<T> type) {
		if (null != contexts) {
			return contexts.stream().map(this::visit).map(type::cast).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public UID visitUid(MySQLParser.UidContext ctx) {
		return visit(ctx.simpleId(), SimpleId.class);
	}

	@Override
	public FullId visitFullId(MySQLParser.FullIdContext ctx) {
		List<UID> ids = visit(ctx.uid(), UID.class);
		return new FullId(ids);
	}

	@Override
	public TableName visitTableName(MySQLParser.TableNameContext ctx) {
		return visit(ctx.fullId(), FullId.class);
	}

	@Override
	public CreateDefinitions visitCreateDefinitions(MySQLParser.CreateDefinitionsContext ctx) {
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
	public SimpleId visitSimpleId(MySQLParser.SimpleIdContext ctx) {
		String id = text(ctx.ID()).orElse(ctx.getText());
		return new SimpleId(id);
	}

	@Override
	public ColumnDefinition visitColumnDefinition(MySQLParser.ColumnDefinitionContext ctx) {
		DataType dataType = visit(ctx.dataType(), DataType.class);
		return new ColumnDefinition(dataType);
	}

	@Override
	public ColumnDeclaration visitColumnDeclaration(MySQLParser.ColumnDeclarationContext ctx) {
		UID uid = visitUid(ctx.uid());
		ColumnDefinition definition = visitColumnDefinition(ctx.columnDefinition());
		return new ColumnDeclaration(uid, definition);
	}

	@Override
	public ColumnCreateTable visitColumnCreateTable(MySQLParser.ColumnCreateTableContext ctx) {
		TableName tn = visit(ctx.tableName(), TableName.class);

		CreateDefinitions cd = visit(ctx.createDefinitions(), CreateDefinitions.class);
		// List<TableOption> nodes = visit(ctx.tableOption(), TableOption.class);

		ColumnCreateTable cct = new ColumnCreateTable(tn.getName(), null != ctx.TEMPORARY(), null != ctx.ifNotExists());
		cct.setDefinitions(cd.definitions);
		// cct.setOptions(nodes);
		return cct;
	}

}
