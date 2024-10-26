package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Golang Target.
 */
@Command(name = "go", description = "Translate JSON to golang struct.")
public class Json2GoCommand extends Json2Command {

	private static final Logger LOG = LoggerFactory.getLogger(Json2GoCommand.class);

	public Json2GoCommand() {
		setTargets(EnumSet.of(Target.GO));
	}

}
