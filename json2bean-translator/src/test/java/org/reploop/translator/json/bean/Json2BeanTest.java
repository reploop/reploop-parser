package org.reploop.translator.json.bean;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Before;
import org.junit.Test;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.io.StringReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
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
        assertThat(messageMap.get(root)).isNull();
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
    public void testExecute() throws Exception {
        URL url = Json2BeanTest.class.getResource("/object.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testEmptyValue() throws Exception {
        String json = "{}";
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(new StringReader(json), context);
        System.out.println(messageMap);

        json = "[]";
        context = new JsonMessageContext(root);
        messageMap = json2Bean.execute(new StringReader(json), context);
        System.out.println(messageMap);
    }

    @Test
    public void testHAR() throws Exception {
        URL url = Json2BeanTest.class.getResource("/har.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testText() throws Exception {
        URL url = Json2BeanTest.class.getResource("/text.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testSimple() throws Exception {
        URL url = Json2BeanTest.class.getResource("/simple.json");
        QualifiedName root = QualifiedName.of("$");
        JsonMessageContext context = new JsonMessageContext(root);
        CharStream cs = CharStreams.fromPath(Paths.get(url.toURI()), StandardCharsets.UTF_8);
        Map<QualifiedName, Message> messageMap = json2Bean.execute(cs, context);
        System.out.print(messageMap);
    }

    @Test
    public void testRawJsonValue() throws Exception {
        String val = "\"{\\\"code\\\":200,\\\"result\\\":[{\\\"id\\\":-1,\\\"emojiPackageName\\\":\\\"系统默认\\\",\\\"emojiPackagePicContLen\\\":0,\\\"emojiPackagePicUrl\\\":\\\"\\\",\\\"corpId\\\":0,\\\"emojiPackagePicName\\\":\\\"\\\",\\\"location\\\":null,\\\"dbCreateTime\\\":1548247994000,\\\"dbUpdateTime\\\":1548247994000,\\\"emojiType\\\":2,\\\"status\\\":1,\\\"emojiList\\\":null}],\\\"message\\\":\\\"\\\",\\\"total\\\":1}\"\n";
        // String val = "{\"code\":1000,\"result\":[{\"user_id\":\"5566343c63afe\",\"area_id\":\"52c669dae5308\",\"user_gender\":\"2\",\"ser_face\":\"59ba2201a3750.jpg\",\"ser_utime\":\"1566455463\",\"ser_starc\":\"5.0\",\"ser_rmkc\":\"54\",\"user_name\":\"\\u5361\\u5fb7\\u5c14\\u897f\\u65e5\\u90a3\\u4f9d\",\"ser_sort\":\"500\",\"gd_job\":\"\\u6cd5\\u5b66\\u7855\\u58eb\\u5728\\u8bfb\",\"ser_hot\":\"0\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"ser_title\":\"\\u6211\\u4f1a\\u5c3d\\u5168\\u529b\\u8ba9\\u5927\\u5bb6\\u5b89\\u5fc3\\u3001\\u653e\\u5fc3\\u3001\\u8212\\u5fc3\\u3001\\u5f00\\u5fc3\",\"ser_status\":\"1\",\"guide_price\":{\"1\":950,\"2\":1600,\"5\":2200,\"6\":2400,\"3\":450,\"4\":750,\"7\":950,\"8\":1150},\"gd_edu\":\"\\u7855\\u58eb\",\"gd_school\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u5927\\u5b66\",\"user_avatar\":\"5566336ade406.jpg\",\"gd_major\":\"\\u6cd5\\u5b66\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":450,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59ba2201a3750.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"user_id\":\"5b9042b9a3f0b\",\"area_id\":\"52c669dae5308\",\"user_gender\":\"1\",\"ser_face\":\"5b99fec244188.jpg\",\"ser_utime\":\"1544168037\",\"ser_starc\":\"5.0\",\"ser_rmkc\":\"11\",\"user_name\":\"\\u4efb\\u5c11\\u6000\",\"ser_sort\":\"498\",\"gd_job\":\"\\u7f8e\\u672f\\u53f2\\u535a\\u58eb\\u5728\\u8bfb\",\"ser_hot\":\"0\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"ser_title\":\"\\u73a9\\u8f6c\\u6700\\u5730\\u9053\\u7684\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\uff01\",\"ser_status\":\"1\",\"guide_price\":{\"1\":1100,\"3\":600},\"gd_edu\":\"\\u535a\\u58eb\",\"gd_school\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u5927\\u5b66\",\"user_avatar\":\"5b9a003d99335.jpg\",\"gd_major\":\"\\u7f8e\\u672f\\u53f2\",\"tag\":{\"0\":\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"2\":\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\"},\"price\":600,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/5b99fec244188.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"user_name\":\"\\u6768\\u5e05\",\"ser_sort\":\"495\",\"gd_job\":\"\\u6c11\\u7528\\u822a\\u7a7a\\u7a7a\\u4e58\\u672c\\u79d1\\u5728\\u8bfb\",\"ser_hot\":\"0\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"ser_title\":\"\\u53f6\\u5b50\\u843d\\u5730\\u65f6\\u6709\\u98ce\\u63a0\\u8fc7\\u4e00\\u6837\\uff0c\\u6b22\\u8fce\\u6765\\u5230\\u571f\\u8033\\u5176\",\"ser_status\":\"1\",\"guide_price\":{\"1\":900},\"gd_edu\":\"\\u672c\\u79d1\",\"gd_school\":\"\",\"user_avatar\":\"5421408caa498.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"54214094adbb0\",\"ser_face\":\"59ba2557a350b.jpg\",\"user_gender\":\"2\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1507117546\",\"ser_rmkc\":\"5\",\"gd_major\":\"\\u6c11\\u7528\\u822a\\u7a7a\\u7a7a\\u4e58\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\"],\"price\":900,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59ba2557a350b.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":1100,\"2\":1900,\"6\":3000,\"3\":600,\"4\":800,\"8\":1200},\"ser_hot\":\"0\",\"ser_title\":\"\\u73a9\\u904d\\u4e00\\u4e2a\\u4e0d\\u4e00\\u6837\\u7684\\u571f\\u8033\\u5176\",\"gd_edu\":\"\\u82f1\\u8bed\",\"gd_school\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u5927\\u5b66\",\"user_avatar\":\"59e59a5775944.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"59b5922896143\",\"ser_face\":\"5dd64ce89d701.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1574325496\",\"ser_rmkc\":\"6\",\"gd_major\":\"\\u56fd\\u9645\\u8d38\\u6613(\\u82f1\\u8bed\\uff09\",\"user_name\":\"\\u5e93\\u5f97\\u6765\\u63d0\",\"ser_sort\":\"494\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u56fd\\u9645\\u8d38\\u6613(\\u82f1\\u8bed\\uff09\\u82f1\\u8bed\\u5728\\u8bfb\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":600,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/5dd64ce89d701.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":900,\"2\":1500,\"3\":500,\"4\":750},\"ser_hot\":\"0\",\"ser_title\":\"\\u8ddf\\u7740\\u5f53\\u5730\\u4eba\\u66f4\\u6df1\\u5165\\u5730\\u4e86\\u89e3\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_edu\":\"\\u672c\\u79d1\",\"gd_school\":\"\\u5317\\u4eac\\u5916\\u56fd\\u8bed\\u5927\\u5b66\",\"user_avatar\":\"5d81daed8ef15.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"5ce7b5e8ad526\",\"ser_face\":\"5d68ea3f5cb33.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1569736811\",\"ser_rmkc\":\"3\",\"gd_major\":\"\\u4e2d\\u6587\",\"user_name\":\"\\u4e8e\\u5357\\u5b9e\\uff08Erdem\\uff09\",\"ser_sort\":\"494\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u82f1\\u8bed\\u6559\\u5e08\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":500,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/5d68ea3f5cb33.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":1000,\"2\":1800,\"5\":2750,\"6\":3250,\"3\":450,\"4\":750,\"7\":950,\"8\":1150},\"ser_hot\":\"0\",\"ser_title\":\"\\u571f\\u8033\\u5176\\uff0c\\u4e00\\u4e2a\\u591a\\u6587\\u5316\\u800c\\u795e\\u79d8\\u7684\\u56fd\\u5bb6\",\"gd_edu\":\"\\u672c\\u79d1\",\"gd_school\":\"\\u5b89\\u5361\\u62c9\\u5927\\u5b66\",\"user_avatar\":\"562897622095e.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"5616d5f2646c0\",\"ser_face\":\"59ba2444e01db.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"4.8\",\"ser_utime\":\"1536897104\",\"ser_rmkc\":\"14\",\"gd_major\":\"\\u65c5\\u6e38\\u7ba1\\u7406\",\"user_name\":\"\\u827e\\u529b\",\"ser_sort\":\"493\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u65c5\\u6e38\\u7ba1\\u7406\\u672c\\u79d1\\u5728\\u8bfb\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":450,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59ba2444e01db.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start2\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":900,\"2\":2100,\"5\":3000,\"6\":2700,\"3\":450,\"4\":750,\"7\":950,\"8\":1150},\"ser_hot\":\"0\",\"ser_title\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u2014\\u2014\\u4e00\\u4e2a\\u6d77\\u6ee8\\u65c5\\u6e38\\u5ea6\\u5047\\u7684\\u7406\\u60f3\\u80dc\\u5730\",\"gd_edu\":\"\",\"gd_school\":\"\",\"user_avatar\":\"54dd6f2509215.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"54dd6e5897a49\",\"ser_face\":\"59f97d3903d07.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1566455439\",\"ser_rmkc\":\"13\",\"gd_major\":\"\",\"user_name\":\"\\u6797\\u6d77\",\"ser_sort\":\"492\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u4e13\\u4e1a\\u5411\\u5bfc\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":450,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59f97d3903d07.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":1000,\"3\":600},\"ser_hot\":\"0\",\"ser_title\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14 \\u8fd9\\u5ea7\\u57ce\\u5e02\\u7684\\u8bb0\\u5fc6\",\"gd_edu\":\"\\u672c\\u79d1\",\"gd_school\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u5927\\u5b66\",\"user_avatar\":\"596c4b8465dcd.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"593424944a514\",\"ser_face\":\"59ba265f36507.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1566455458\",\"ser_rmkc\":\"3\",\"gd_major\":\"\\u751f\\u7269\\u5b66\",\"user_name\":\"\\u8fea\\u4e9a\\u5c14\",\"ser_sort\":\"492\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u751f\\u7269\\u5b66\\u672c\\u79d1\\u5728\\u8bfb\",\"tag\":{\"0\":\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"2\":\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\"},\"price\":600,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59ba265f36507.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]},{\"ser_status\":\"1\",\"guide_price\":{\"1\":900,\"2\":1550,\"5\":2200,\"6\":2400,\"3\":450,\"4\":750,\"7\":950,\"8\":1150},\"ser_hot\":\"0\",\"ser_title\":\"\\u84dd\\u8272\\u571f\\u8033\\u5176\\uff0c\\u4e00\\u4e2a\\u4e1c\\u897f\\u65b9\\u6587\\u5316\\u878d\\u6c47\\u56fd\\u5bb6\",\"gd_edu\":\"\\u672c\\u79d1\",\"gd_school\":\"\\u4f0a\\u65af\\u5766\\u5e03\\u5c14\\u5927\\u5b66\",\"user_avatar\":\"596735a00fe58.jpg\",\"area_id\":\"52c669dae5308\",\"user_id\":\"595b47d46b8f1\",\"ser_face\":\"59ba261e2fde2.jpg\",\"user_gender\":\"1\",\"ser_starc\":\"5.0\",\"ser_utime\":\"1569380249\",\"ser_rmkc\":\"1\",\"gd_major\":\"\\u571f\\u8033\\u5176\\u8bed\",\"user_name\":\"\\u4e70\\u4e70\\u63d0\\u827e\\u529b\",\"ser_sort\":\"490\",\"area_name\":\"\\u571f\\u8033\\u5176 - \\u4f0a\\u65af\\u5766\\u5e03\\u5c14\",\"gd_job\":\"\\u571f\\u8033\\u5176\\u8bed\\u672c\\u79d1\\u5728\\u8bfb\",\"tag\":[\"\\u5f92\\u6b65\\u5411\\u5bfc\",\"\\u5e26\\u8f66\\u5411\\u5bfc\",\"\\u5f92\\u6b65\\u63a5\\u9001\\u673a\",\"\\u5e26\\u8f66\\u63a5\\u9001\\u673a\"],\"price\":450,\"service_face\":\"https:\\/\\/wanzi-hangzhou.oss-cn-hangzhou.aliyuncs.com\\/images\\/59ba261e2fde2.jpg?x-oss-process=style\\/w303_h177\",\"remark\":[\"start3\",\"start3\",\"start3\",\"start3\",\"start3\"]}],\"error\":\"\",\"count\":12,\"date\":\"2020-04-23 10:36:20\"}";
        CharacterIterator it = new StringCharacterIterator(val);
        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            System.out.println(c);
        }
    }
}