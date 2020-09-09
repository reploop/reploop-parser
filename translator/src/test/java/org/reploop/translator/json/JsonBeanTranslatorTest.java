package org.reploop.translator.json;

import com.google.common.base.CaseFormat;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonBeanTranslatorTest {

    private JsonParser parser;
    private org.reploop.translator.json.JsonMessageTranslator translator;
    private String url = "http://lijiehui-monitor-online020-jylt.reploop.virtual/cloudstorage/uri?bizid=bj_ppc_prod&location=bj&production=ppc&type=prod&role=qichuan&usage=normal&app=ppconswift";
    private HttpClient client = HttpClientBuilder.create().build();

    StringReader reader() throws IllegalStateException {
        return reader(url);
    }

    StringReader reader(String url) throws IllegalStateException {
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != HttpStatus.SC_OK) {
                throw new IllegalStateException(status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return new StringReader(body);
        } catch (Exception e) {
            throw new IllegalStateException(url, e);
        }
    }

    @BeforeMethod
    public void setUp() {
        parser = new JsonParser();
        translator = new org.reploop.translator.json.JsonMessageTranslator();
        // url = "http://mixer.video.ireploop.com/mixin/videos/avlist?albumId=203194401&size=2&page=1";
    }

    @Test
    public void testVisitNode() {
    }

    @Test
    public void testVisitPair() {
    }

    @Test
    public void testVisitValue() {
    }

    @Test
    public void testVisitObject() {
        RestTemplate template = new RestTemplate();
        Uri uri = template.getForObject(url, Uri.class);
        System.out.println(uri);
    }

    @Test
    public void testName() {

    }

    @Test
    public void testVisitJson() throws Exception {
        testVisitJson(url);
    }

    private com.google.common.base.Converter<String, String> LU_UC = CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_CAMEL);

    private QualifiedName fqn(String pkg, URI uri) {
        QualifiedName prefix = QualifiedName.of(pkg);

        Path path = Paths.get(uri.getPath()).normalize();
        int size = path.getNameCount() - 1;
        List<String> parts = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            parts.add(path.getName(i).toString());
        }
        String name = path.getName(size).toString().toLowerCase().replace("[.]+", "_");
        QualifiedName qn = QualifiedName.of(LU_UC.convert(name));

        QualifiedName suffix = QualifiedName.of(QualifiedName.of(parts), qn);
        return QualifiedName.of(prefix, suffix);
    }

    private void dup(JsonMessageContext context) {
        context.messages.forEach(((name, message) -> name.prefix()
            .map(qn -> qn.toString().toLowerCase())
            .map(QualifiedName::of)
            .ifPresent(qn -> context.dup(name, QualifiedName.of(qn, name.suffix())))));
    }

    private void output(Path dir, QualifiedName namespace, Message message, JsonMessageContext context) throws IOException {
        MessageDuplicateResolver resolver = new MessageDuplicateResolver();
        Message resolved = resolver.visitMessage(message, context);
        dup(context);
        context.setNamespace(namespace);
        resolved = resolver.visitMessage(resolved, context);
        context.setNamespace(null);
        QualifiedName name = resolved.getName();


        JsonBeanGenerator jbg = new JsonBeanGenerator();
        JsonBeanContext jbc = new JsonBeanContext(name);
        Optional<QualifiedName> fqn = name.prefix();
        Path path = dir;
        if (fqn.isPresent()) {
            QualifiedName ns = fqn.get();

            List<String> parts = ns.allParts();
            for (String part : parts) {
                path = path.resolve(part);
            }
        }


        jbg.visitMessage(resolved, jbc);


        Files.createDirectories(path);

        try (BufferedWriter writer = Files.newBufferedWriter(path.resolve(name.suffix() + ".java"))) {
            writer.write(jbc.toString());
        }
        System.out.println(jbc);
    }

    public void testVisitJson(String url) throws Exception {
        Path path = Paths.get("/Users/george/source/walle/walle-parser/walle-translator/src/test/java");
        URI uri = URI.create(url);
        String pkg = "org.reploop.translator";
        QualifiedName name = fqn(pkg, uri);
        QualifiedName namespace = name.prefix().orElse(null);
        QualifiedName filename = QualifiedName.of(name.suffix());

        Json json = (Json) parser.parse(reader(url), JsonBaseParser::json);
        JsonMessageContext context = new JsonMessageContext(filename);
        org.reploop.parser.protobuf.tree.Field field = (Field) translator.visitJson(json, context);

        // API

        context.messages.forEach((key, message) -> {
            try {
                output(path, namespace, message, context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}