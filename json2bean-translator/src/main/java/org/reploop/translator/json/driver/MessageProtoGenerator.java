package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.IndexContext;
import org.reploop.translator.json.bean.MessageContext;
import org.reploop.translator.json.gen.ProtoGenerator;
import org.reploop.translator.json.support.Target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageProtoGenerator extends AbstractMessageGenerator {
    private final ProtoGenerator protoGenerator = new ProtoGenerator();
    private final MessageIndexSorter messageIndexSorter = new MessageIndexSorter();
    private final ProtoPathResolver pathResolver = new ProtoPathResolver();

    public MessageProtoGenerator() {
        super(Target.PROTO, CaseFormat.LOWER_UNDERSCORE);
    }

    @Override
    public void execute(Message message, BeanContext context) {
        Message ordered = messageIndexSorter.visitMessage(message, new IndexContext(1));
        MessageContext messageContext = new MessageContext();
        messageContext.setFormat(getFormat());
        Message resolved = pathResolver.visitMessage(ordered, messageContext);
        List<Option> options = new ArrayList<>();
        List<Header> headers = new ArrayList<>();
        SyntaxPair syntaxPair = new SyntaxPair("proto3");
        options.add(syntaxPair);
        OptionPair javaMultipleFiles = new OptionPair("java_multiple_files", new BoolValue(true));
        options.add(javaMultipleFiles);
        resolved.getName().prefix().ifPresent(pkg -> {
            String namespace = pkg.toString();
            OptionPair javaPackage = new OptionPair("java_package", new StringValue(namespace));
            options.add(javaPackage);
            headers.add(new Namespace(namespace));
        });

        ProtoProgram proto = new ProtoProgram(Collections.emptyList(), options, headers, List.of(resolved), Collections.emptyList(), Collections.emptyList());
        protoGenerator.visitProtobufProgram(proto, context);
    }
}
