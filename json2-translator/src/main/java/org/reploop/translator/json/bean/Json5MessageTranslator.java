package org.reploop.translator.json.bean;

import org.reploop.parser.json.Json5Parser;
import org.reploop.parser.json.json5.JSON5Parser;
import org.reploop.parser.json.tree.Json5;
import org.reploop.parser.json.tree.Value;
import org.reploop.parser.protobuf.type.FieldType;

import java.io.IOException;
import java.io.Reader;

public class Json5MessageTranslator extends JsonMessageTranslator {
    private final Json5Parser json5Parser;

    public Json5MessageTranslator() {
        this(new Json5Parser());
    }

    public Json5MessageTranslator(Json5Parser json5Parser) {
        this.json5Parser = json5Parser;
    }

    @Override
    protected FieldType valueLiterals(Reader l, MessageContext context) throws IOException {
        Value val = (Value) json5Parser.parse(l, JSON5Parser::value);
        return visitValue(val, context);
    }

    @Override
    protected FieldType visitRawTextValue(Reader val, MessageContext context) throws IOException {
        Json5 json = (Json5) json5Parser.parse(val, JSON5Parser::json5);
        return visitValue(json.getValue(), context);
    }
}
