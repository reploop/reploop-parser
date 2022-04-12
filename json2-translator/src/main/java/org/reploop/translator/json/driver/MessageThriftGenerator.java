package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.IndexContext;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.gen.ThriftGenerator;
import org.reploop.translator.json.support.Target;

public class MessageThriftGenerator extends AbstractMessageGenerator {
    private final ThriftGenerator thriftGenerator = new ThriftGenerator();
    private final MessageIndexSorter messageIndexSorter = new MessageIndexSorter();
    private final RelativePathResolver relativePathResolver = new RelativePathResolver();

    public MessageThriftGenerator() {
        super(Target.THRIFT, CaseFormat.LOWER_UNDERSCORE);
    }

    @Override
    public void execute(Message message, BeanContext context) {
        Message ordered = messageIndexSorter.visitMessage(message, new IndexContext(1));
        MessageContext messageContext = new MessageContext();
        messageContext.setFormat(getFormat());
        Message resolved = relativePathResolver.visitMessage(ordered, messageContext);
        thriftGenerator.visitMessage(resolved, context);
    }
}
