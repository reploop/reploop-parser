package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.IndexContext;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.gen.ProtoGenerator;
import org.reploop.translator.json.support.Target;

public class MessageProtoGenerator extends AbstractMessageGenerator {
    private final ProtoGenerator protoGenerator = new ProtoGenerator();
    private final MessageIndexSorter messageIndexSorter = new MessageIndexSorter();
    private final MessagePathResolver pathResolver = new MessagePathResolver();

    public MessageProtoGenerator() {
        super(Target.PROTO, CaseFormat.LOWER_UNDERSCORE);
    }

    @Override
    public void execute(Message message, BeanContext context) {
        Message ordered = messageIndexSorter.visitMessage(message, new IndexContext(1));
        MessageContext messageContext = new MessageContext();
        messageContext.setFormat(getFormat());
        Message resolved = pathResolver.visitMessage(ordered, messageContext);
        protoGenerator.visitMessage(resolved, context);
    }
}
