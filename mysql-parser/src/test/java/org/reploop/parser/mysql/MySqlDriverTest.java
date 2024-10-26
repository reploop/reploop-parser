package org.reploop.parser.mysql;

import org.junit.Ignore;
import org.junit.Test;
import org.reploop.parser.mysql.base.MySQLParser;
import org.reploop.parser.mysql.tree.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class MySqlDriverTest {

	final MySqlDriver driver = new MySqlDriver();

	@Test
	@Ignore
	public void parse() throws IOException {
		Path dir = Paths.get(
				"/Users/george/open-source/flowable-engine/modules/flowable-engine/src/main/resources/org/flowable/db/create");
		Path file = dir.resolve("flowable.mssql.create.engine.sql");
		Node node = driver.parse(file, MySQLParser::root);
		List<String> lines = Files.readAllLines(file);
		for (String line : lines) {
		}
		assertNotNull(node);
	}

	@Test
	public void func() throws Exception {
		String sql = "select sum(count) from tb_agg";
		Node node = driver.parse(sql, MySQLParser::selectStatement);
		System.out.println(node);
	}

	@Test
	public void sql() throws Exception {
		String sql = "SELECT b.mt4Account, b.server, SUM(t.pip_commission_currency) as pipCommissionCurrency, SUM( CASE WHEN b.commission_flag = 0 THEN b.pip_commission ELSE 0 END ) AS 'innerCommission', SUM( CASE WHEN b.commission_flag = 1 THEN b.pip_commission ELSE 0 END ) AS 'outerCommission', DATABASE() as db FROM tb_commission_ib b, tb_account_mt4 u, tb_commission_ib_transaction t, tb_commission_ib_volume a WHERE b.mt4Account=u.mt4_account AND b.id = t.commission_ib_id AND b.ticket = a.ticket AND b.`server` = a.dataSourceId AND b.close_time >= ? AND b.close_time <= ? AND b.tradeOnCredit != 1 AND LOWER(a.mt4AccountGroup) not like '%test%' GROUP BY b.mt4Account ORDER BY b.mt4Account";
		Node node = driver.parse(sql, MySQLParser::selectStatement);
		System.out.println(node);
	}

	@Test
	public void parseText() throws IOException {
		String sql = "CREATE TABLE ACT_HI_PROCINST (\n" + "    ID_ varchar(64) not null,\n"
				+ "    PROC_INST_ID_ varchar(64) not null,\n" + "    BUSINESS_KEY_ varchar(255),\n"
				+ "    PROC_DEF_ID_ varchar(64) not null,\n" + "    START_TIME_ datetime not null,\n"
				+ "    END_TIME_ datetime,\n" + "    DURATION_ bigint,\n" + "    START_USER_ID_ varchar(255),\n"
				+ "    START_ACT_ID_ varchar(255),\n" + "    END_ACT_ID_ varchar(255),\n"
				+ "    SUPER_PROCESS_INSTANCE_ID_ varchar(64),\n" + "    DELETE_REASON_ varchar(4000),\n"
				+ "    primary key (ID_),\n" + "    unique (PROC_INST_ID_),\n"
				+ "    unique ACT_UNIQ_HI_BUS_KEY (PROC_DEF_ID_, BUSINESS_KEY_)\n"
				+ ")  DEFAULT CHARSET=utf8 COLLATE utf8_bin;";
		Node node = driver.parse(sql.toUpperCase(), MySQLParser::root);
		System.out.println(node);
	}

}