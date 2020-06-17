package org.reploop.translator;

import com.google.common.base.CaseFormat;
import org.reploop.parser.thrift.ThriftParser;
import org.reploop.parser.Classpath;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.ProtobufParser;
import org.reploop.parser.protobuf.generator.ProtobufClassnameResolver;
import org.reploop.parser.protobuf.generator.ProtobufClasspathResolver;
import org.reploop.parser.protobuf.generator.ProtobufResolver;
import org.reploop.parser.protobuf.generator.ProtobufServiceResolver;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.thrift.generator.GeneratorContext;
import org.reploop.parser.thrift.generator.ThriftClasspathResolver;
import org.reploop.parser.thrift.generator.ThriftResolver;
import org.reploop.parser.thrift.tree.Service;
import org.reploop.parser.thrift.tree.ThriftProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-05-17 10
 */
public class ThriftCodeTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ThriftCodeTranslator.class);


    public static void main(String... args) throws IOException {
        Path dest = Paths.get("E:\\data\\idl");
        Path to = Paths.get("E:\\gitlab\\walle-libs\\vis-hbase-service\\src\\main\\java\\qipu");
        ThriftCodeTranslator translator = new ThriftCodeTranslator();
        translator.generate(dest, to);
    }

    private void extract(Path baseDir) {
        SchemaJarExtractor extractor = new SchemaJarExtractor();
        extractor.findThenExtract(baseDir);
    }

    public void generate(Path baseDir, Path to) throws IOException {
        extract(baseDir);
        execute(baseDir, to);
    }

    void execute(Path baseDir, Path to) throws IOException {
        Map<Path, Set<Path>> includes = includes(baseDir);
        ProtobufParser pp = new ProtobufParser();
        Map<Path, ProtoProgram> ppm = new HashMap<>();
        ThriftParser tp = new ThriftParser();
        Map<Path, ThriftProgram> tpm = new HashMap<>();

        Files.walkFileTree(baseDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = file.getFileName().toString();
                if (fileName.endsWith(".proto")) {
                    ProtoProgram p = pp.program(file);
                    p.setFile(file);
                    ppm.put(file, p);
                } else if (fileName.endsWith(".thrift")) {
                    ThriftProgram t = tp.program(file);
                    t.setFile(file);
                    tpm.put(file, t);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        final Classpath<ProtoProgram> cpp = new Classpath<>();
        // Classpath start path.
        cpp.path(baseDir);
        ProtobufResolver pr = new ProtobufResolver();
        ProtobufClasspathResolver resolver = new ProtobufClasspathResolver(pp);
        Map<Path, ProtoProgram> resolvedMap = pr.resolve(cpp, ppm, resolver);
        cpp.clear();
        ProtobufClassnameResolver classnameResolver = new ProtobufClassnameResolver();
        resolvedMap = pr.resolve(cpp, resolvedMap, classnameResolver);

        ProtobufServiceResolver serviceResolver = new ProtobufServiceResolver();
        resolvedMap = pr.resolve(cpp, resolvedMap, serviceResolver);

        final Classpath<ThriftProgram> cpt = new Classpath<>();
        cpt.names(cpp.names());

        ThriftResolver tr = new ThriftResolver();
        Map<Path, ThriftProgram> resolved = tr.resolve(cpt, tpm, new ThriftClasspathResolver(tp));
        resolved = tr.resolve(cpt, resolved, new MixinBinaryNameResolver(cpp, includes));
        resolved = tr.resolve(cpt, resolved, new MixinExpansionResolver(cpp));

        generate(to, includes, cpp, cpt, resolved);
    }

    private void generate(Path to, Map<Path, Set<Path>> includes, Classpath<ProtoProgram> cpp, Classpath<ThriftProgram> cpt, Map<Path, ThriftProgram> resolved) {
        final GeneratorContext gc = new GeneratorContext();
        resolved.forEach((path, program) -> {
            MixinCodeGenerator tcg = new MixinCodeGenerator(cpt, cpp);
            gc.indent(0);
            tcg.visitProgram(program, gc);
        });

        Map<Service, StringBuilder> services = gc.getServices();
        services.forEach((service, content) -> {
            try {
                Optional<QualifiedName> qn = service.getName().prefix();
                String filename = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, service.getName().suffix()) + ".thrift";
                boolean found = false;
                for (Path p : includes.keySet()) {
                    if (p.endsWith(filename)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return;
                }
                Optional<Path> dir = qn.map(name -> {
                    Path target = to;
                    for (String part : name.allParts()) {
                        target = target.resolve(part);
                    }
                    return target;
                });
                Path target = dir.orElse(to);
                Files.createDirectories(target);
                String name = service.getName().suffix();
                List<String> code = Collections.singletonList(content.toString());
                Files.write(target.resolve(name + "Adapter.java"), code, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private Map<Path, Set<Path>> includes(Path baseDir) {
        add(baseDir, "knowledge/graph/pub/graph_rpc_service.thrift", "knowledge/graph/pub/graph_service.proto");
        add(baseDir, "knowledge/pub/id_rpc_service.thrift", "knowledge/pub/id_service.proto");
        add(baseDir, "knowledge/pub/read_rpc_service.thrift", "knowledge/pub/read_service.proto");
        add(baseDir, "knowledge/pub/write_rpc_service.thrift", "knowledge/pub/write_service.proto");

        add(baseDir, "knowledge/fusion/category/category_rpc_service.thrift", "knowledge/fusion/category/category_service.proto");
        add(baseDir, "knowledge/fusion/category/category_rpc_service.thrift", "knowledge/pub/categories.proto");

        add(baseDir, "knowledge/pub/category_rpc_service.thrift", "knowledge/pub/categories.proto");
        add(baseDir, "knowledge/fusion/query/query_rpc_service.thrift", "knowledge/fusion/query/query_service.proto");

        add(baseDir, "knowledge/fusion/fusion_rpc_service.thrift", "knowledge/fusion/fusion_service.proto");
        add(baseDir, "knowledge/fusion/fusion_rpc_service.thrift", "knowledge/pub/read_service.proto");
        add(baseDir, "knowledge/fusion/fusion_rpc_service.thrift", "knowledge/graph/pub/graph_service.proto");
        add(baseDir, "knowledge/fusion/fusion_rpc_service.thrift", "knowledge/fusion/query/query_service.proto");
        return includes;
    }

    private Map<Path, Set<Path>> includes = new HashMap<>();

    private void add(Path baseDir, String name, String include, String... more) {
        Set<Path> files = includes.computeIfAbsent(baseDir.resolve(name), f -> new HashSet<>());
        files.add(baseDir.resolve(include));
        if (null != more) {
            for (String file : more) {
                files.add(baseDir.resolve(file));
            }
        }
    }


}
