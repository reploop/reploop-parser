package org.reploop.translator;

import org.reploop.parser.Classpath;
import org.reploop.parser.protobuf.ProtobufParser;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.thrift.ThriftParser;
import org.reploop.parser.thrift.generator.GeneratorContext;
import org.reploop.parser.thrift.generator.ThriftBinaryNameResolver;
import org.reploop.parser.thrift.generator.ThriftCodeGenerator;
import org.reploop.parser.thrift.tree.ThriftProgram;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-05-17 10
 */
public class ThriftCodeTranslatorTest {
    ThriftParser parser;
    ThriftCodeGenerator generator;
    ProtobufParser protobufParser;

    ThriftCodeTranslator translator;

    public void setUp() throws Exception {
        parser = new ThriftParser();
        protobufParser = new ProtobufParser();
        generator = new ThriftCodeGenerator();
        translator = new ThriftCodeTranslator();
    }

    public void testGenerate() throws Exception {
        URL url = ClassLoader.getSystemClassLoader().getResource("idl");
        assert null != url;
        Path dest = Paths.get(url.toURI());
        Path to = dest.getParent().getParent().resolve("generated-sources").resolve("qipu");
        ThriftCodeTranslator translator = new ThriftCodeTranslator();
        translator.execute(dest, to);
    }

    public void testCategoryService() throws Exception {
        testService("category_rpc_service.thrift", "categories.proto");
    }

    public void testIdService() throws Exception {
        testService("idl/knowledge/pub/id_rpc_service.thrift", "idl/knowledge/pub/id_service.proto");
    }

    public void testReadService() throws Exception {
        testService("read_rpc_service.thrift", "read_service.proto");
    }

    public void testWriteService() throws Exception {
        testService("write_rpc_service.thrift", "write_service.proto");
    }

    public void testService(String thriftIdl, String protoSchema) throws Exception {
        URL uri = ClassLoader.getSystemClassLoader().getResource(thriftIdl);
        assert uri != null;
        URL proto = ClassLoader.getSystemClassLoader().getResource(protoSchema);
        assert proto != null;
        Path path = Paths.get(uri.toURI());
        Path protoPath = Paths.get(proto.toURI());

        ProtoProgram protoProgram = protobufParser.program(protoPath);
        ThriftProgram ThriftProgram = parser.program(path);

        Classpath<ThriftProgram> classpath = new Classpath<>();

        List<Message> messages = protoProgram.getMessages();
        if (null != messages) {
            for (Message message : messages) {
            }
        }
        classpath.file(path);
        ThriftBinaryNameResolver resolver = new ThriftBinaryNameResolver(new HashMap<>());
        // We need rewrite function parameter and return type name.
        ThriftProgram p = resolver.visitProgram(ThriftProgram, classpath);
        System.out.println(p);
        StringBuilder builder = generator.process(p, new GeneratorContext());
        System.out.println(builder);
    }
}