package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.support.Target;

public class MessageAvroGenerator extends AbstractMessageGenerator {

    public MessageAvroGenerator() {
        super(Target.AVRO);
    }

    @Override
    public void execute(Message message, BeanContext context) {

    }
}
