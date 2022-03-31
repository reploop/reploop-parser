package org.reploop.translator.json.driver;

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
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.FieldPushDown;
import org.reploop.translator.json.bean.Json2Message;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.support.NameFormat;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.nio.file.StandardOpenOption.*;
import static org.reploop.translator.json.support.Constants.*;

public class Json2Driver implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Json2Driver.class);
    private static final Json2Message json2Bean = new Json2Message();
    private static final FieldPushDown fieldPushDown = new FieldPushDown();
    private final String outputDirectory;
    private final List<String> inputDirectories;
    private final List<String> uris;
    private final Boolean enableRootGuess;
    private final Boolean enableFailFast;
    private final String namespace;
    private final NameFormat nameFormat = new NameFormat();
    private final EnumSet<Target> targets;
    private List<MessageGenerator> generators;

    public Json2Driver(Json2Conf conf) {
        this.inputDirectories = conf.getInputDirectories();
        this.uris = conf.getUris();
        this.enableFailFast = conf.getEnableFailFast();
        this.enableRootGuess = conf.getEnableRootGuess();
        this.namespace = conf.getNamespace();
        this.outputDirectory = conf.getOutputDirectory();
        this.targets = conf.getTargets();
        init();
    }

    private void init() {
        generators = new ArrayList<>();
        for (Target target : targets) {
            switch (target) {
                case GO:
                    generators.add(new MessageGoGenerator());
                    break;
                case AVRO:
                    generators.add(new MessageAvroGenerator());
                    break;
                case JAVA:
                    generators.add(new MessageBeanGenerator());
                    break;
                case PROTO:
                    generators.add(new MessageProtoGenerator());
                    break;
                case THRIFT:
                    generators.add(new MessageThriftGenerator());
                    break;
            }
        }
    }

    public String guessRoot(Path path) {
        return guessRoot(path.normalize().toString());
    }

    public String guessRoot(URI uri) {
        return guessRoot(uri.getPath());
    }

    private String guessRoot(String path) {
        if (enableRootGuess) {
            // #1 Get last path name
            int idx = path.lastIndexOf(SEP_CHAR);
            if (idx > 0) {
                String suffix = path.substring(idx + 1).trim();
                // #2 Remove file extension if necessary.
                idx = suffix.indexOf(DOT_CHAR);
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
        if (FILE_SCHEMA.equals(schema)) {
            return CharStreams.fromPath(Paths.get(uri));
        } else if (HTTP_SCHEMA.equals(schema) || HTTPS_SCHEMA.equals(schema)) {
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
        MessageContext ctx = new MessageContext(qn, Paths.get(outputDirectory));
        Map<QualifiedName, Message> all = json2Bean.execute(stream, ctx);
        generate(all, ctx);
    }

    private Path packageToPath(Path root, Message msg, String ext) {
        QualifiedName qn = msg.getName();
        String filename = toFilename(qn, ext);
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

    private String toFilename(QualifiedName qn, String ext) {
        return qn.suffix() + DOT + ext;
    }

    private void generate(Map<QualifiedName, Message> fixed, MessageContext context) {
        fixed.forEach((name, message) -> {
            Message merged = fieldPushDown.visitMessage(message, new BeanContext(name, fixed));
            for (MessageGenerator generator : generators) {
                BeanContext beanContext = new BeanContext(name, fixed);
                generator.generate(merged, beanContext);

                Path root = Paths.get(outputDirectory);
                Path path = root.resolve(beanContext.getFile()).normalize();
                try {
                    Path dir = Files.createDirectories(path.getParent());
                    Files.writeString(path, beanContext.toString(), TRUNCATE_EXISTING, CREATE, WRITE);
                } catch (IOException e) {
                    LOG.error("Cannot write source code to file {}", path, e);
                }
            }
        });
    }

    @Override
    public void run() {
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
                            throw new IllegalStateException("Cannot process file " + file.toString(), e);
                        }
                        LOG.error("Cannot process file {} in directory {}", file, inDir, e);
                    }
                }
            }
        }
    }

    private List<Path> list(Path dir) {
        if (Files.isDirectory(dir)) {
            try (Stream<Path> sp = Files.walk(dir)) {
                return sp.filter(p -> !Files.isDirectory(p))
                    .collect(Collectors.toList());
            } catch (IOException e) {
                LOG.error("Cannot list files in directory {}", dir, e);
            }
        }
        return Collections.emptyList();
    }
}
