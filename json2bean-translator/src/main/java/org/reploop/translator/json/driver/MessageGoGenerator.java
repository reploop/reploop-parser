package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.support.Target;

public class MessageGoGenerator extends AbstractMessageGenerator {

    public MessageGoGenerator() {
        super(Target.GO);
    }

    @Override
    public void execute(Message message, BeanContext context) {

    }
}
