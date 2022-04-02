package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Strings;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.FieldPushDown;
import org.reploop.translator.json.support.Constants;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import static java.nio.file.StandardOpenOption.*;

public abstract class AbstractMessageGenerator implements MessageGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractMessageGenerator.class);
    private static final Converter<String, String> UC_LD = CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);
    private static final FieldPushDown fieldPushDown = new FieldPushDown();
    protected final Target target;
    private final CaseFormat format;

    public AbstractMessageGenerator(Target target) {
        this(target, CaseFormat.UPPER_CAMEL);
    }

    public AbstractMessageGenerator(Target target, CaseFormat format) {
        this.target = target;
        this.format = format;
    }

    public CaseFormat getFormat() {
        return format;
    }

    protected String filenameExt(Message message) {
        QualifiedName fqn = message.getName();
        String filename = filename(message.getName());
        return String.join(Constants.DOT, filename, target.ext());
    }

    protected String filename(QualifiedName fqn) {
        return CaseFormat.UPPER_CAMEL.to(format, fqn.suffix());
    }

    public Target getTarget() {
        return target;
    }

    @Override
    public void generate(Message message, BeanContext context) {
        context.setName(message.getName());
        String filename = filenameExt(message);
        context.setFilename(filename);
        Path path = packageToPath(message).resolve(filename);
        context.setFile(path);
        execute(message, context);
    }

    protected Path packageToPath(Message msg) {
        QualifiedName fqn = msg.getName();
        String[] array = fqn.prefix().stream()
            .map(QualifiedName::allParts)
            .flatMap(Collection::stream)
            .filter(s -> !Strings.isNullOrEmpty(s))
            .toArray(String[]::new);
        return Paths.get(srcDir(), array);
    }

    protected String srcDir() {
        return target.name().toLowerCase();
    }

    @Override
    public void generate(Map<QualifiedName, Message> fixed, String outputDirectory) {
        fixed.forEach((name, message) -> {
            Message merged = fieldPushDown.visitMessage(message, new BeanContext(name, fixed));
            BeanContext beanContext = new BeanContext(name, fixed);
            beanContext.setDeps(fixed);
            generate(merged, beanContext);

            Path root = Paths.get(outputDirectory);
            Path path = root.resolve(beanContext.getFile()).normalize();
            try {
                Path dir = Files.createDirectories(path.getParent());
                Files.writeString(path, beanContext.toString(), TRUNCATE_EXISTING, CREATE, WRITE);
            } catch (IOException e) {
                LOG.error("Cannot write source code to file {}", path, e);
            }
        });
    }

    public abstract void execute(Message message, BeanContext context);
}
