package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * #1 URL resource
 * #2 file resource
 * #2 file resource in directory
 */
@Command(name = "bean", description = "Convert JSON to POJO.")
public class Json2BeanCommand extends Json2Command {
    private static final Logger LOG = LoggerFactory.getLogger(Json2BeanCommand.class);

}
