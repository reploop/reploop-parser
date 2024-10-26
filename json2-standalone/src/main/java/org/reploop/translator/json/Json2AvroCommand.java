package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * The Avro target.
 */
@Command(name = "avro", description = "Translate JSON to Apache Avro schema.")
public class Json2AvroCommand extends Json2Command {

	private static final Logger LOG = LoggerFactory.getLogger(Json2AvroCommand.class);

	public Json2AvroCommand() {
		setTargets(EnumSet.of(Target.THRIFT));
	}

}
