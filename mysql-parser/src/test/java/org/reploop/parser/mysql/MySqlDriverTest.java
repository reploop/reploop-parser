package org.reploop.parser.mysql;

import org.reploop.parser.mysql.base.MySqlParser;
import org.reploop.parser.mysql.tree.Node;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class MySqlDriverTest {

    MySqlDriver driver = new MySqlDriver();

    @Test
    public void parse() throws IOException {
        Path dir = Paths.get("/Users/george/open-source/flowable-engine/modules/flowable-engine/src/main/resources/org/flowable/db/create");
        Path file = dir.resolve("flowable.mssql.create.engine.sql");
        Node node = driver.parse(file, MySqlParser::root);
        List<String> lines = Files.readAllLines(file);
        for (String line : lines) {
        }
        assertNotNull(node);
    }

    @Test
    public void parseText() throws IOException {
        String sql = "CREATE TABLE ACT_HI_PROCINST (\n" +
                "    ID_ varchar(64) not null,\n" +
                "    PROC_INST_ID_ varchar(64) not null,\n" +
                "    BUSINESS_KEY_ varchar(255),\n" +
                "    PROC_DEF_ID_ varchar(64) not null,\n" +
                "    START_TIME_ datetime not null,\n" +
                "    END_TIME_ datetime,\n" +
                "    DURATION_ bigint,\n" +
                "    START_USER_ID_ varchar(255),\n" +
                "    START_ACT_ID_ varchar(255),\n" +
                "    END_ACT_ID_ varchar(255),\n" +
                "    SUPER_PROCESS_INSTANCE_ID_ varchar(64),\n" +
                "    DELETE_REASON_ varchar(4000),\n" +
                "    primary key (ID_),\n" +
                "    unique (PROC_INST_ID_),\n" +
                "    unique ACT_UNIQ_HI_BUS_KEY (PROC_DEF_ID_, BUSINESS_KEY_)\n" +
                ")  DEFAULT CHARSET=utf8 COLLATE utf8_bin;";
        Node node = driver.parse(sql.toUpperCase(), MySqlParser::root);
        System.out.println(node);
    }
}