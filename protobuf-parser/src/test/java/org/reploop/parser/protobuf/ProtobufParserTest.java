package org.reploop.parser.protobuf;

import org.junit.Before;
import org.junit.Test;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.protobuf.tree.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtobufParserTest {

	private Path dir;

	private ProtobufParser parser;

	@Before
	public void setUp() throws Exception {
		URL url = ProtobufParserTest.class.getResource("/proto");
		dir = Paths.get(url.toURI());
		parser = new ProtobufParser();
	}

	@Test
	public void program() throws IOException {
		Stream<Path> i = Files.list(dir);

		i.forEach(p -> {
			System.out.println(p);
			ProtoProgram proto = parser.program(p);
			// System.out.println(proto);
		});
	}

	@Test
	public void testProgram() {
		String filename = "ReconfigurationProtocol.proto";
		Path path = dir.resolve(filename);
		ProtoProgram proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(7);
		assertThat(proto.getServices()).hasSize(1);

		filename = "xattr.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(9);

		filename = "inotify.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(10);
		assertThat(proto.getEnumerations()).hasSize(3);

		filename = "ClientDatanodeProtocol.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(28);

		filename = "datatransfer.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(29);
		assertThat(proto.getEnumerations()).hasSize(2);

		filename = "ClientNamenodeProtocol.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(172);
		assertThat(proto.getServices()).hasSize(1);
		Service service = proto.getServices().get(0);
		assertThat(service.getFunctions()).hasSize(109);

		filename = "erasurecoding.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(22);

		filename = "encryption.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(12);

		filename = "hdfs.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(51);

		filename = "acl.proto";
		path = dir.resolve(filename);
		proto = parser.program(path);
		assertThat(proto).isNotNull();
		assertThat(proto.getMessages()).hasSize(15);
	}

}