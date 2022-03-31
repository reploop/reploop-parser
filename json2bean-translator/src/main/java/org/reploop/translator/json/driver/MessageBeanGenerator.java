package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.bean.TypeSimplifier;
import org.reploop.translator.json.gen.BeanGenerator;
import org.reploop.translator.json.support.Target;

public class MessageBeanGenerator extends AbstractMessageGenerator {
    // Simplifier
    private static final TypeSimplifier typeSimplifier = new TypeSimplifier();
    private final BeanGenerator beanGenerator = new BeanGenerator();

    public MessageBeanGenerator() {
        super(Target.JAVA, CaseFormat.UPPER_CAMEL);
    }

    @Override
    protected String filename(QualifiedName fqn) {
        return fqn.suffix();
    }

    @Override
    public void execute(Message merged, BeanContext context) {
        Message simplified = typeSimplifier.visitMessage(merged, new MessageContext());
        beanGenerator.visitMessage(simplified, context);
    }
}
