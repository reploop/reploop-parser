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
import org.reploop.translator.json.bean.Json2Message;
import org.reploop.translator.json.bean.Json52Message;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.reploop.translator.json.support.Constants.DOLLAR;
import static org.reploop.translator.json.support.Constants.DOT_CHAR;
import static org.reploop.translator.json.support.Constants.FILE_SCHEMA;
import static org.reploop.translator.json.support.Constants.HTTPS_SCHEMA;
import static org.reploop.translator.json.support.Constants.HTTP_SCHEMA;
import static org.reploop.translator.json.support.Constants.SEP_CHAR;

public class Json2Driver implements Runnable {
  private static final Logger LOG = LoggerFactory.getLogger(Json2Driver.class);
  private final String outputDirectory;
  private final List<String> inputDirectories;
  private final List<String> uris;
  private final Boolean enableRootGuess;
  private final Boolean enableFailFast;
  private final Boolean json5;
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
    this.json5 = conf.getJson5();
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
    Json2Message j2m;
    if (json5) {
      j2m = new Json52Message();
    } else {
      j2m = new Json2Message();
    }
    Map<QualifiedName, Message> all = j2m.execute(stream, ctx);
    generate(all, ctx);
  }

  private void generate(Map<QualifiedName, Message> fixed, MessageContext context) {
    for (MessageGenerator generator : generators) {
      generator.generate(fixed, outputDirectory);
    }
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
