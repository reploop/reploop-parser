package com.qiyi.walle.translator.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.reploop.parser.QualifiedName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


public class Json2BeanTest {

    Json2Bean jb;

    @BeforeMethod
    public void setUp() {
        File file = new File("/Users/george/source/walle/walle-parser/walle-translator/src/test/java");
        jb = new Json2Bean(file, "com.iqiyi.cloud.oven.workshop.model.parse");
    }

    @Test
    public void testExecute() {
        String body = " {\"taskEndTime\": \"2018-10-12 13:00:16\", \"extend\": \"e4be88fe58664894b65de33f4d3290c0\", \"taskProgress\": 100, \"taskStatus\": 2, \"taskId\": 2000046140722833501, \"taskStartTime\": \"2018-10-12 13:00:14\", \"taskData\": {\"outFiles\": [{\"origin\": \"swift://bjyunlou5.oss.qiyi.storage:8080|bjyunlou5.oss.qiyi.storage:8080/v1/AUTH_d57616c48a2140b393ca2f787567ddb5/20181012-00/_acb8bcaaeedf410c878a0a24aba5ff0c.jpg\", \"128_80\": \"swift://bjyunlou5.oss.qiyi.storage:8080|bjyunlou5.oss.qiyi.storage:8080/v1/AUTH_d57616c48a2140b393ca2f787567ddb5/20181012-02/_432f9883e4884ced8532de0aa1447ff2.jpg\", \"200_150\": \"swift://bjyunlou5.oss.qiyi.storage:8080|bjyunlou5.oss.qiyi.storage:8080/v1/AUTH_afaaffa9919b4828a15a8cb42fdb4a0f/20181012-00/_6d933b8e43984559b6240f5e0c1413ac.jpg\", \"480_360\": \"swift://bjyunlou5.oss.qiyi.storage:8080|bjyunlou5.oss.qiyi.storage:8080/v1/AUTH_d57616c48a2140b393ca2f787567ddb5/20181012-02/_f8763f54e194400ebf876653e70d9dcb.jpg\"}]}, \"taskProgressDesc\": \"\"}";
        jb.execute(QualifiedName.of("DistInfo"), new StringReader(body));
    }


    @Test
    public void testExecuteUrl() {
        String url = "http://storageuri.qiyi.domain/cloudstorage/uri?bizid=jy_storage_dev_test&location=jy&production=storage_dev&type=test&role=storage_dev&filename=MP3.mp4";
        jb.execute(url);
    }

    @Test
    public void testSort() throws Exception {
        URL url = Json2BeanTest.class.getResource("/body.json");
        System.out.println(url);
        Path path = Paths.get(url.toURI());
        String body = Files.lines(path)
            .map(s -> s.replace("(", ""))
            .map(s -> s.replace(")", ""))
            .map(s -> s.replace("ObjectId", ""))
            .map(s -> s.replace("NumberLong", ""))
            .reduce((s, s2) -> s + s2).orElse("").trim();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // UgcVideoEntity node = mapper.readValue(url, UgcVideoEntity.class);
        //String json = mapper.writeValueAsString(node);
        // System.out.println(json);
        // Files.write(path, json.getBytes());

    }

    @Test
    public void testExecute1() throws Exception {
        URL url = Json2BeanTest.class.getResource("/body.json");
        System.out.println(url);
        Path path = Paths.get(url.toURI());
        String body = Files.lines(path)
            .map(s -> s.replace("(", ""))
            .map(s -> s.replace(")", ""))
            .map(s -> s.replace("ObjectId", ""))
            .map(s -> s.replace("NumberLong", ""))
            .reduce((s, s2) -> s + s2).orElse("").trim();
        // Files.write(path, body.getBytes());
        System.out.println(body);
        String s = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        QualifiedName name = QualifiedName.of("ShipArchiveResponse");
        QualifiedName qn = Optional.ofNullable(jb.getPkg())
            .map(QualifiedName::of)
            .map(n -> QualifiedName.of(n, name))
            .orElse(name);
        jb.execute(qn, new StringReader(s.trim()));
    }
}