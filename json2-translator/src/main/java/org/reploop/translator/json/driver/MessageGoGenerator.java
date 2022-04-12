package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.gen.GoGenerator;
import org.reploop.translator.json.support.Target;

public class MessageGoGenerator extends AbstractMessageGenerator {

    private final GoTypeSimplifier typeSimplifier = new GoTypeSimplifier();
    private final GoGenerator goGenerator = new GoGenerator();

    public MessageGoGenerator() {
        super(Target.GO);
    }

    @Override
    public void execute(Message message, BeanContext context) {
        Message simplified = typeSimplifier.visitMessage(message, new MessageContext());
        goGenerator.visitMessage(simplified, context);
    }
}
