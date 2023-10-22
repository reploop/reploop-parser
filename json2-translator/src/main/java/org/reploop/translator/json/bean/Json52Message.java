package org.reploop.translator.json.bean;

import org.antlr.v4.runtime.CharStream;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.Json5Parser;
import org.reploop.parser.json.base.JSON5Parser;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.protobuf.tree.Message;

import java.util.Map;

/**
 * Parse <a href="https://json5.org/">json5</a> to message.
 */
public class Json52Message extends Json2Message {
  private final Json5Parser parser;

  public Json52Message() {
    this(new Json5Parser());
  }

  public Json52Message(Json5Parser parser) {
    this.parser = parser;
  }

  @Override
  public Map<QualifiedName, Message> execute(CharStream stream, MessageContext context) {
    var json = (Json) parser.parse(stream, JSON5Parser::json5);
    return execute(json, context);
  }
}
