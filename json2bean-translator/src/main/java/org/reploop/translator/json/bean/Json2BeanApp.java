package org.reploop.translator.json.bean;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.google.common.base.CaseFormat;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.support.NameFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.nio.file.StandardOpenOption.*;
import static org.reploop.translator.json.support.Constants.JAVA;

/**
 * #1 URL resource
 * #2 file resource
 */
@Command(description = "JSON 2 Bean", name = "json2bean")
public class Json2BeanApp {
    private static final Logger LOG = LoggerFactory.getLogger(Json2BeanApp.class);
    private final JsonBeanGenerator beanGenerator = new JsonBeanGenerator();
    private static final Json2Bean json2Bean = new Json2Bean();
    @Option(name = {"--output", "-o"})
    Path directory;
    @Option(name = {"--json"})
    String json;
    @Option(name = {"--uri"})
    String uri;
    @Option(name = {"--enable-root-guess"})
    Boolean enableRootGuess;

    private final CloseableHttpClient client = HttpClientBuilder.create()
        .build();

    public Json2BeanApp() {
    }

    public static void main(String... args) throws IOException {
        SingleCommand<Json2BeanApp> command = SingleCommand.singleCommand(Json2BeanApp.class);
        Json2BeanApp app = command.parse(args);
        if (null != app.uri) {
            app.execute(URI.create(app.uri));
        }
        if (null != app.json) {
            app.execute(Paths.get(app.json));
        }
    }

    private final NameFormat nameFormat = new NameFormat();
    private static final char SEP = '/';
    private static final char DOT = '.';
    private static final String DOLLAR = "$";

    public String guessRoot(Path path) {
        return guessRoot(path.normalize().toString());
    }

    public String guessRoot(URI uri) {
        return guessRoot(uri.getPath());
    }


    private String guessRoot(String path) {
        if (enableRootGuess) {
            // #1 Get last path name
            int idx = path.lastIndexOf(SEP);
            if (idx > 0) {
                String suffix = path.substring(idx + 1).trim();
                // #2 Remove file extension if necessary.
                idx = suffix.indexOf(DOT);
                if (idx > 0) {
                    suffix = suffix.substring(0, idx);
                }
                return nameFormat.format(suffix, CaseFormat.LOWER_CAMEL);
            }
        }
        return DOLLAR;
    }

    public void execute(URI uri) throws IOException {
        execute(uri, guessRoot(uri));
    }

    public void execute(URI uri, String root) throws IOException {
        CloseableHttpResponse response = client.execute(new HttpGet(uri));
        int code = response.getCode();
        if (200 != code) {
            throw new IllegalArgumentException("Send request to " + uri + " get error code " + code);
        }
        HttpEntity entity = response.getEntity();
        ContentType contentType = ContentType.parse(entity.getContentType());
        Charset charset;
        if (null == contentType || null == (charset = contentType.getCharset())) {
            charset = StandardCharsets.UTF_8;
        }
        CharStream stream = CharStreams.fromStream(entity.getContent(), charset);
        execute(stream, root);
    }

    public void execute(Path path) throws IOException {
        execute(path, guessRoot(path));
    }

    public void execute(Path path, String root) throws IOException {
        execute(CharStreams.fromPath(path), root);
    }

    private void execute(CharStream stream, String root) {
        JsonMessageContext ctx = new JsonMessageContext(root, directory);
        Map<QualifiedName, Message> all = json2Bean.execute(stream, ctx);
        generate(all, ctx);
    }

    private Path packageToPath(Path root, Message msg) {
        QualifiedName qn = msg.getName();
        String filename = toFilename(qn);
        Optional<QualifiedName> oqn = qn.prefix();
        Path path = null;
        if (oqn.isPresent()) {
            List<String> parts = oqn.get().allParts();
            for (String part : parts) {
                if (isNullOrEmpty(part)) {
                    continue;
                }
                if (null == path) {
                    path = Path.of(part);
                    continue;
                }
                path = path.resolve(part);
            }
        }
        if (null == path) {
            path = Path.of(filename);
        } else {
            path = path.resolve(filename);
        }
        return root.resolve(path);
    }

    private String toFilename(QualifiedName qn) {
        return qn.suffix() + DOT + JAVA;
    }


    private void generate(Map<QualifiedName, Message> fixed, JsonMessageContext context) {
        fixed.forEach((name, message) -> {
            Path path = packageToPath(context.getDirectory(), message);
            JsonBeanContext beanContext = new JsonBeanContext(name);
            beanGenerator.visitMessage(message, beanContext);
            try {
                Files.createDirectories(path.getParent());
                Files.writeString(path, beanContext.toString(), TRUNCATE_EXISTING, CREATE, WRITE);
            } catch (IOException e) {
                LOG.error("Cannot write source code to file {}", path, e);
            }
        });
    }
}
