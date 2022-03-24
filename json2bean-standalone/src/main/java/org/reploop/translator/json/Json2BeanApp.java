package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.help.Help;

import java.io.IOException;

/**
 * https://rvesse.github.io/airline/
 */
@Cli(name = "json2",
        description = "Translate JSON to POJO",
        defaultCommand = Help.class,
        commands = {Json2BeanCommand.class, Json2ProtoCommand.class, Json2ThriftCommand.class, Json2AvroCommand.class, Help.class})
public class Json2BeanApp {
    public static void main(String... args) throws IOException {
        com.github.rvesse.airline.Cli<Runnable> cli = new com.github.rvesse.airline.Cli<>(Json2BeanApp.class);
        Runnable cmd = cli.parse(args);
        cmd.run();
    }
}
