package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.support.Target;

public interface MessageGenerator {
    Target getTarget();

    void generate(Message message, BeanContext context);
}
