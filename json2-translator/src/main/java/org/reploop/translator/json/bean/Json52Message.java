package org.reploop.translator.json.bean;

import org.reploop.parser.json.Json5Parser;

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
}
