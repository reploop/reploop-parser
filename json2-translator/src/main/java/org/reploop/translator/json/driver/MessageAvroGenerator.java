package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.gen.AvroGenerator;
import org.reploop.translator.json.support.Target;

public class MessageAvroGenerator extends AbstractMessageGenerator {

	private final AvroGenerator avroGenerator = new AvroGenerator();

	public MessageAvroGenerator() {
		super(Target.AVRO, CaseFormat.LOWER_UNDERSCORE);
	}

	@Override
	public void execute(Message message, BeanContext context) {
		context.setSpaces(2);
		avroGenerator.visitMessage(message, context);
	}

}
