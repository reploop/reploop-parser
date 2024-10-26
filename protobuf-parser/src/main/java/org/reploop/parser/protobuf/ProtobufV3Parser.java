package org.reploop.parser.protobuf;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.protobuf.v3.Protobuf3Lexer;
import org.reploop.parser.protobuf.v3.Protobuf3Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

/**
 * Protobuf V3 Schema Parser.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2020-10-04 09
 */
public class ProtobufV3Parser extends ParserDriver<Node, Protobuf3Lexer, Protobuf3Parser> {

	private static final Logger LOG = LoggerFactory.getLogger(ProtobufV3Parser.class);

	public ProtoProgram program(Path file) {
		return (ProtoProgram) parse(file, Protobuf3Parser::proto);
	}

	public ProtoProgram program(Reader file) {
		try {
			return (ProtoProgram) parse(file, Protobuf3Parser::proto);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Protobuf3Parser parser(CommonTokenStream tokenStream) {
		return new Protobuf3Parser(tokenStream);
	}

	@Override
	protected Protobuf3Lexer lexer(CharStream charStream) {
		return new Protobuf3Lexer(charStream);
	}

	@Override
	protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
		return new ProtobufV3AstBuilder(tokenStream);
	}

	@Override
	protected ParseTreeListener parseListener() {
		return new PostProcessor();
	}

	@Override
	protected ANTLRErrorListener errorListener() {
		return new ProtobufErrorListener();
	}

}
