package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Protobuf target.
 */
@Command(name = "proto", description = "Translate JSON to Protobuf Schema.")
public class Json2ProtoCommand extends Json2Command {

	private static final Logger LOG = LoggerFactory.getLogger(Json2ProtoCommand.class);

	public Json2ProtoCommand() {
		setTargets(EnumSet.of(Target.PROTO));
	}

}
