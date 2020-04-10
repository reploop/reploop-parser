package org.reploop.parser.protobuf.generator;


import org.reploop.parser.Classpath;
import org.reploop.parser.protobuf.ProtobufParser;
import org.reploop.parser.protobuf.type.*;
import org.reploop.parser.protobuf.tree.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-05-17 19
 */
public class ProtobufClasspathResolverTest {

    private ProtobufParser parser;
    private ProtobufClasspathResolver resolver;

    @BeforeMethod
    public void setUp() throws Exception {
        parser = new ProtobufParser();
        resolver = new ProtobufClasspathResolver(parser);

    }

    @Test
    public void testVisitProtobufProgram1() throws Exception {
        URL uri = ClassLoader.getSystemClassLoader().getResource("knowledge/pub/metadatas.proto");
        Path path = Paths.get(uri.toURI());
        ProtoProgram program = parser.program(path);
        Classpath<ProtoProgram> classpath = new Classpath<>();
        classpath.file(path);
        classpath.path(path.resolve("../../../").normalize());
        classpath.entity(path, program);
        ProtoProgram pp = resolver.visitProtobufProgram(program, classpath);

        ProtobufClassnameResolver classnameResolver = new ProtobufClassnameResolver();
        pp = classnameResolver.visitProtobufProgram(pp, classpath);
        System.out.println(pp);
    }

    @Test
    public void testVisitProtobufProgram() throws Exception {
        URL uri = ClassLoader.getSystemClassLoader().getResource("knowledge/pub/formats.proto");
        Path path = Paths.get(uri.toURI());
        ProtoProgram program = parser.program(path);
        Classpath<ProtoProgram> classpath = new Classpath<>();
        classpath.file(path);
        classpath.path(path.resolve("../../../").normalize());
        classpath.entity(path, program);
        ProtoProgram pp = resolver.visitProtobufProgram(program, classpath);
        System.out.println(pp);
    }

}