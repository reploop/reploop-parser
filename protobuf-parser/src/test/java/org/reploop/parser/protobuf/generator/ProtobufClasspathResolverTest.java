package org.reploop.parser.protobuf.generator;

import org.junit.Before;
import org.junit.Test;
import org.reploop.parser.Classpath;
import org.reploop.parser.protobuf.ProtobufParser;
import org.reploop.parser.protobuf.tree.ProtoProgram;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-05-17 19
 */
public class ProtobufClasspathResolverTest {

	private ProtobufParser parser;

	private ProtobufClasspathResolver resolver;

	@Before
	public void setUp() {
		parser = new ProtobufParser();
		resolver = new ProtobufClasspathResolver(parser);

	}

	@Test
    public void testVisitProtobufProgram1() throws Exception {
		URL uri = ClassLoader.getSystemClassLoader().getResource("proto/acl.proto");
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
		URL uri = ClassLoader.getSystemClassLoader().getResource("proto/hdfs.proto");
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