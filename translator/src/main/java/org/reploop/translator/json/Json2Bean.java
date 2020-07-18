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
import org.reploop.parser.protobuf.tree.Option;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Json2Bean {
    private HttpClient client = HttpClientBuilder.create().build();

    private JsonParser parser = new JsonParser();
    private JsonMessageTranslator translator = new JsonMessageTranslator();
    /**
     * The output directory of the source file generated.
     */
    private File outputDirectory;

    /**
     * The url to mock.
     */
    private String url;
    /**
     * Batch mode.
     */
    private List<String> urls;

    /**
     * The package name of the bean generated.
     */
    private String pkg;

    public Json2Bean(File outputDirectory, String pkg) {
        this.outputDirectory = outputDirectory;
        this.pkg = pkg;
    }

    public File getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    private StringReader reader(URI url) throws IllegalStateException {
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
            throw new IllegalStateException(url.toString(), e);
        }
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
        context.getDup().clear();
        context.getMessages().forEach(((name, message) -> name.prefix()
            .map(qn -> qn.toString().toLowerCase())
            .map(QualifiedName::of)
            .ifPresent(qn -> context.dup(name, QualifiedName.of(qn, name.suffix())))));
        reduce(context);
        direct(context);
    }

    private void direct(JsonMessageContext context) {
        Map<QualifiedName, QualifiedName> names = context.dup;
        names.forEach((key, value) -> {
            QualifiedName val = value;
            while (names.containsKey(val)) {
                val = names.get(val);
            }
            names.put(key, val);
        });
    }

    private void reduce(JsonMessageContext context) {
        TreeMap<QualifiedName, Message> map = (TreeMap<QualifiedName, Message>) context.getMessages();
        map.descendingKeySet()
            .forEach(fqn -> {
                Map<QualifiedName, QualifiedName> dup = context.dup;
                Set<QualifiedName> names = new HashSet<>();
                context.dup(fqn)
                    .ifPresent(qn -> {
                        names.add(qn);
                        List<String> parts = qn.allParts();
                        int size = parts.size();
                        for (int c = 1; c < size; c++) {
                            List<String> all = new ArrayList<>();
                            for (int j = size - c; j <= size - 1; j++) {
                                all.add(parts.get(j));
                            }
                            QualifiedName n = QualifiedName.of(all);
                            if (dup.containsKey(qn)) {
                                break;
                            }
                            if (!names.contains(n)) {
                                dup.put(qn, n);
                                names.add(n);
                            }
                        }
                    });
            });
    }

    private MessageDuplicateResolver resolver = new MessageDuplicateResolver();
    private JsonBeanGenerator generator = new JsonBeanGenerator();
    private JsonMessageShorter shorter = new JsonMessageShorter();

    private static final QualifiedName EXT = QualifiedName.of("java");

    private void output(Path dir, QualifiedName namespace, Message message, JsonMessageContext context) throws IOException {
        dup(context);
        context.setNamespace(namespace);
        Message resolved = resolver.visitMessage(message, context);
        context.setNamespace(null);

        // We got the full qualified name.
        QualifiedName fqn = resolved.getName();

        List<Option> options = resolved.getOptions();
        resolved = shorter.visitMessage(resolved, options);

        // Generate Java bean.
        JsonBeanContext jbc = new JsonBeanContext(fqn);
        generator.visitMessage(resolved, jbc);

        // Make sure parent directories exist.
        Path parent = ensureParent(dir, fqn);
        QualifiedName filename = QualifiedName.of(fqn.suffix(), EXT);
        Path path = parent.resolve(filename.toString());
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jbc.toString());
        }
    }

    private Path ensureParent(Path dir, QualifiedName fqn) throws IOException {
        Path path = dir;
        Optional<QualifiedName> qn = fqn.prefix();
        if (qn.isPresent()) {
            QualifiedName ns = qn.get();
            List<String> parts = ns.allParts();
            for (String part : parts) {
                path = path.resolve(part);
            }
        }
        return Files.createDirectories(path);
    }


    public void execute() {
        List<String> list = new ArrayList<>();
        if (null != urls) {
            urls.stream()
                .filter(Objects::nonNull)
                .forEach(list::add);
        }
        if (null != url) {
            list.add(url);
        }
        for (String url : list) {
            execute(url);
        }
    }

    public void execute(String url) {
        URI uri = URI.create(url);
        QualifiedName name = fqn(pkg, uri);
        Path dir = outputDirectory.toPath();
        execute(dir, name, reader(uri));
    }

    public void execute(QualifiedName name, StringReader reader) {
        Path dir = outputDirectory.toPath();
        execute(dir, name, reader);
    }

    public void execute(Path dir, QualifiedName name, StringReader reader) {
        try {
            QualifiedName namespace = name.prefix().orElse(null);
            QualifiedName filename = QualifiedName.of(name.suffix());

            Json json = (Json) parser.parse(reader, JsonBaseParser::json);
            JsonMessageContext context = new JsonMessageContext(filename);
            org.reploop.parser.protobuf.tree.Field field = (Field) translator.visitJson(json, context);

            // Handle qualified name, resolve package.
            context.getMessages().forEach((key, message) -> {
                Message resolved = resolver.visitMessage(message, context);
                context.add(key, resolved);
            });
            // API
            context.getMessages().forEach((key, message) -> {
                try {
                    output(dir, namespace, message, context);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new IllegalStateException(url, e);
        }
    }
}
