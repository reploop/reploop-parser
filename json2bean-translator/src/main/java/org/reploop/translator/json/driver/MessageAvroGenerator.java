package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.support.Target;

public class MessageAvroGenerator implements MessageGenerator {
    private final Target target;

    public MessageAvroGenerator() {
        this.target = Target.AVRO;
    }

    @Override
    public Target getTarget() {
        return target;
    }

    @Override
    public void generate(Message message, BeanContext context) {

    }
}
