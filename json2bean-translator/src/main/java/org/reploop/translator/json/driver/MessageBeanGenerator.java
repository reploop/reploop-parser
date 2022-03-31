package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.DupTypeResolver;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.bean.TypeSimplifier;
import org.reploop.translator.json.gen.BeanGenerator;
import org.reploop.translator.json.support.Target;

import java.util.HashMap;
import java.util.Map;

public class MessageBeanGenerator extends AbstractMessageGenerator {
    // Simplifier
    private static final TypeSimplifier typeSimplifier = new TypeSimplifier();
    private final BeanGenerator beanGenerator = new BeanGenerator();
    private final BeanRenameResolver beanRenameResolver = new BeanRenameResolver();
    private final DupTypeResolver dupTypeResolver = new DupTypeResolver();

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

    @Override
    public void generate(Map<QualifiedName, Message> fixed, String outputDirectory) {
        Map<QualifiedName, Message> renamed = new HashMap<>();
        MessageContext ctx = new MessageContext();
        fixed.forEach((name, message) -> {
            MessageContext context = new MessageContext();
            Message msg = beanRenameResolver.visitMessage(message, context);
            renamed.put(msg.getName(), msg);
            ctx.addIdentityNames(context.getIdentityNames());
        });
        Map<QualifiedName, Message> dup = new HashMap<>();
        renamed.forEach((name, message) -> {
            Message msg = dupTypeResolver.visitMessage(message, ctx);
            dup.put(msg.getName(), msg);
        });
        super.generate(dup, outputDirectory);
    }
}
