package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.JsonBeanContext;
import org.reploop.translator.json.bean.JsonBeanGenerator;
import org.reploop.translator.json.bean.JsonMessageContext;
import org.reploop.translator.json.support.Constants;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.nio.file.StandardOpenOption.*;

/**
 * #1 URL resource
 * #2 file resource
 * #2 file resource in directory
 */
@Command(name = "bean", description = "Convert JSON to POJO.")
public class Json2BeanCommand implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Json2BeanCommand.class);
    private final JsonBeanGenerator beanGenerator = new JsonBeanGenerator();
    private static final org.reploop.translator.json.bean.Json2Bean json2Bean = new org.reploop.translator.json.bean.Json2Bean();
    @Option(name = {"--output", "-o"}, description = "Where the source code should go")
    String outputDirectory;
    @Option(name = {"--input", "-i"}, description = "Process all json file in the input directory.")
    List<String> inputDirectories;
    @Option(name = {"--uri"}, description = "An uri to specify where the JSON is. It's schema should be file, http or https, we can handle each of them differently.")
    List<String> uris;
    @Option(name = {"--url"}, description = "We can fire a HTTP request, and translate it's json response to bean directly.")
    List<String> urls;
    @Option(name = {"--enable-root-guess"}, description = "Try to guess a reasonable root name from the filename or the API uri given, otherwise $ is used by default.")
    Boolean enableRootGuess = true;
    @Option(name = {"--enable-fail-fast", "-ff"}, description = "Fail if any error occurred. Default true.")
    Boolean enableFailFast = true;
    @Option(name = {"--namespace", "-n"}, description = "The top package or namespace of the source. Add package line to the source. Default is empty.")
    String namespace;

    public Json2BeanCommand() {
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

    public void execute(URI uri) {
        try {
            execute(uri, guessRoot(uri));
        } catch (IOException e) {
            if (enableFailFast) {
                throw new IllegalStateException("Cannot execute " + uri, e);
            }
            LOG.error("Cannot translate to bean {}", uri, e);
        }
    }

    private CharStream from(URI uri) throws IOException {
        String schema = Strings.nullToEmpty(uri.getScheme()).toLowerCase();
        if ("file".equals(schema)) {
            return CharStreams.fromPath(Paths.get(uri));
        } else if ("http".equals(schema) || "https".equals(schema)) {
            return fromHTTP(uri);
        }
        throw new IllegalArgumentException("Unsupported schema " + schema);
    }

    public CharStream fromHTTP(URI uri) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
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
        return CharStreams.fromStream(entity.getContent(), charset);
    }

    public void execute(URI uri, String root) throws IOException {
        execute(from(uri), root);
    }

    public void execute(Path path) throws IOException {
        execute(path, guessRoot(path));
    }

    public void execute(Path path, String root) throws IOException {
        execute(CharStreams.fromPath(path), root);
    }

    private void execute(CharStream stream, String root) {
        QualifiedName qn = QualifiedName.of(root);
        if (!Strings.isNullOrEmpty(namespace)) {
            qn = QualifiedName.of(namespace, qn);
        }
        JsonMessageContext ctx = new JsonMessageContext(qn, Paths.get(outputDirectory));
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
        return qn.suffix() + DOT + Constants.JAVA;
    }


    private void generate(Map<QualifiedName, Message> fixed, JsonMessageContext context) {
        fixed.forEach((name, message) -> {
            Path path = packageToPath(context.getDirectory(), message).normalize();
            JsonBeanContext beanContext = new JsonBeanContext(name);
            beanGenerator.visitMessage(message, beanContext);
            try {
                Path dir = Files.createDirectories(path.getParent());
                System.out.println(dir);
                Files.writeString(path, beanContext.toString(), TRUNCATE_EXISTING, CREATE, WRITE);
            } catch (IOException e) {
                LOG.error("Cannot write source code to file {}", path, e);
            }
        });
    }

    @Override
    public void run() {
        if (null != urls) {
            for (String url : uris) {
                execute(URI.create(url));
            }
        }
        if (null != uris) {
            for (String uri : uris) {
                execute(URI.create(uri));
            }
        }
        if (null != inputDirectories) {
            for (String inputDirectory : inputDirectories) {
                Path inDir = Paths.get(inputDirectory);
                List<Path> files = list(inDir);
                for (Path file : files) {
                    try {
                        execute(file);
                    } catch (IOException e) {
                        if (enableFailFast) {
                            throw new IllegalStateException("Cannot process file " + file.toString());
                        }
                        LOG.error("Cannot {}", inDir, e);
                    }
                }
            }
        }
    }

    private List<Path> list(Path dir) {
        if (Files.isDirectory(dir)) {
            try {
                return Files.list(dir).collect(Collectors.toList());
            } catch (IOException e) {
                LOG.error("Cannot list file in directory {}", dir, e);
            }
        }
        return Collections.emptyList();
    }
}
