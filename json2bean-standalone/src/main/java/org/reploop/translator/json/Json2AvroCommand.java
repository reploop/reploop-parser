package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * #1 URL resource
 * #2 file resource
 * #2 file resource in directory
 */
@Command(name = "avro", description = "Translate JSON to Protobuf Schema.")
public class Json2AvroCommand extends Json2Command {
    private static final Logger LOG = LoggerFactory.getLogger(Json2AvroCommand.class);
}
