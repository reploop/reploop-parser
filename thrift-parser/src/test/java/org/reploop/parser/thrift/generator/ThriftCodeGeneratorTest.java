package org.reploop.parser.thrift.generator;

import org.reploop.parser.thrift.ThriftParser;
import org.reploop.parser.Classpath;
import org.reploop.parser.thrift.tree.ThriftProgram;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-09 17
 */
public class ThriftCodeGeneratorTest {
    ThriftParser parser;
    ThriftCodeGenerator generator;

    @BeforeMethod
    public void setUp() throws Exception {
        parser = new ThriftParser();
        generator = new ThriftCodeGenerator();
    }

    @Test
    public void testService() throws Exception {
        URL uri = ClassLoader.getSystemClassLoader().getResource("write_rpc_service.thrift");
        assert uri != null;
        Path path = Paths.get(uri.toURI());
        ThriftProgram ThriftProgram = parser.program(path);
        Classpath<ThriftProgram> classpath = new Classpath<>();
        classpath.file(path);
        System.out.println(classpath);
        ThriftBinaryNameResolver resolver = new ThriftBinaryNameResolver(new HashMap<>());
        // We need rewrite function parameter and return type name.
        ThriftProgram p = resolver.visitProgram(ThriftProgram, classpath);
        System.out.println(p);
        StringBuilder builder = generator.process(p, new GeneratorContext());
        System.out.println(builder);
        TimeUnit.SECONDS.sleep(3);
    }
}