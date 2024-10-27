package org.reploop.parser.json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reploop.parser.json.json5.JSON5Parser;
import org.reploop.parser.json.tree.Json5;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Json5ParserTest {

	Json5Parser parser;

	@BeforeEach
	void setUp() {
		parser = new Json5Parser();
	}

	@Test
	void visitor() throws IOException {
		// https://raw.githubusercontent.com/chromium/chromium/feb3c9f670515edf9a88f185301cbd7794ee3e52/third_party/blink/renderer/platform/runtime_enabled_features.json5
		var url = Json5ParserTest.class.getResource("/runtime_enabled_features.json5");
		assertThat(url).isNotNull();
		CharStream cs = CharStreams.fromStream(url.openStream());
		Json5 node = (Json5) parser.parse(cs, JSON5Parser::json5);
		System.out.println(node);
	}

	@Test
	void visitSample() throws Exception {
		var url = Json5ParserTest.class.getResource("/sample.json5");
		assertThat(url).isNotNull();
		CharStream cs = CharStreams.fromStream(url.openStream());
		Json5 node = (Json5) parser.parse(cs, JSON5Parser::json5);
		System.out.println(node);
	}

}