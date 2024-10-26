package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.help.Help;

/**
 * https://rvesse.github.io/airline/
 */
@Cli(name = "json2", description = "Translate JSON to supported targets", defaultCommand = Help.class,
		commands = { Json2AllCommand.class, Json2GoCommand.class, Json2BeanCommand.class, Json2ProtoCommand.class,
				Json2ThriftCommand.class, Json2AvroCommand.class, Help.class })
public class Json2App {

	public static void main(String... args) {
		com.github.rvesse.airline.Cli<Runnable> cli = new com.github.rvesse.airline.Cli<>(Json2App.class);
		Runnable cmd = cli.parse(args);
		cmd.run();
	}

}
