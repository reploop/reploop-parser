package org.reploop.translator.json.driver;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;

import java.util.Map;

public interface MessageGenerator {

	void generate(Map<QualifiedName, Message> messages, String outputDirectory);

	void generate(Message message, BeanContext context);

}