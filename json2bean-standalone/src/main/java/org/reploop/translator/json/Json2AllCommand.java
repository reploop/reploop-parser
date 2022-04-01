package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * All targets
 */
@Command(name = "all", description = "Convert JSON to all supported target in one run.")
public class Json2AllCommand extends Json2Command {
    private static final Logger LOG = LoggerFactory.getLogger(Json2AllCommand.class);

    public Json2AllCommand() {
        setTargets(EnumSet.allOf(Target.class));
    }
}
