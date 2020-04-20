package org.reploop.translator.json.bean;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Before;
import org.junit.Test;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Json2BeanTest {

    private Json2Bean json2Bean;

    @Before
    public void setUp() throws Exception {
        json2Bean = new Json2Bean();
    }

    @Test
    public void execute() throws Exception {
        URL url = Json2BeanTest.class.getResource("/array.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext("$");
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.println(messageMap);
        assertThat(messageMap).isNotEmpty();
        Message message = messageMap.remove(root);
        assertThat(message).isNotNull();
        messageMap.values().forEach(m -> {
            assertThat(m).isNotNull();
            List<Field> fields = m.getFields();
            assertThat(fields).isNotEmpty().hasSize(9);
        });
    }

    @Test
    public void testMapType() throws Exception {
        URL url = Json2BeanTest.class.getResource("/map-type.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testArray() throws Exception {
        URL url = Json2BeanTest.class.getResource("/type.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testDouble() throws Exception {
        URL url = Json2BeanTest.class.getResource("/double.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testFloat() throws Exception {
        URL url = Json2BeanTest.class.getResource("/float.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testMerge() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testExecute1() {
    }

    @Test
    public void testExecute2() {
    }

    @Test
    public void execute0() {
    }
}