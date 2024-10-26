package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Command;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

/**
 * Java Bean target.
 */
@Command(name = "bean", description = "Convert JSON to Java POJO.")
public class Json2BeanCommand extends Json2Command {

	private static final Logger LOG = LoggerFactory.getLogger(Json2BeanCommand.class);

	public Json2BeanCommand() {
		setTargets(EnumSet.of(Target.JAVA));
	}

}
