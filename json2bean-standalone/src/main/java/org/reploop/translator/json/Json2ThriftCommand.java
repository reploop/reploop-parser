package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Apache Thrift target.
 */
@Command(name = "thrift", description = "Translate JSON to Protobuf Schema.")
public class Json2ThriftCommand extends Json2Command {
    private static final Logger LOG = LoggerFactory.getLogger(Json2ThriftCommand.class);

    public Json2ThriftCommand() {
        setTargets(EnumSet.of(Target.THRIFT));
    }
}
