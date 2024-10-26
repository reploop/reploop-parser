package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Option;
import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.List;

/**
 * Collect JSON from the following locations: #1 URL resource #2 file resource #3 file
 * resource in directory then generate schemas
 */
public class Json2Command implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(Json2Command.class);

	@Option(name = { "--output", "-o" }, description = "Where the source code should go")
	String outputDirectory;

	@Option(name = { "--input", "-i" }, description = "Process all json file in the input directory.")
	List<String> inputDirectories;

	@Option(name = { "--uri" },
			description = "An uri to specify where the JSON is. It's schema should be file, http or https, we can handle each of them differently.")
	List<String> uris;

	@Option(name = { "--enable-root-guess" },
			description = "Try to guess a reasonable root name from the filename or the API uri given, otherwise $ is used by default.")
    final
    Boolean enableRootGuess = true;

	@Option(name = { "--enable-fail-fast", "-ff" }, description = "Fail if any error occurred. Default true.")
    final
    Boolean enableFailFast = true;

	@Option(name = { "--namespace", "-n" },
			description = "The top package or namespace of the source. Add package line to the source. Default is empty.")
	String namespace;

	/**
	 * The schema of which supported targets to generate.
	 */
	EnumSet<Target> targets;

	private volatile Json2Driver driver;

	public EnumSet<Target> getTargets() {
		return targets;
	}

	public void setTargets(EnumSet<Target> targets) {
		this.targets = targets;
	}

	protected Json2Driver getDriver() {
		if (null == driver) {
			synchronized (Json2Command.class) {
				if (null == driver) {
					Json2Conf conf = new Json2Conf().uris(uris)
						.inputDirectories(inputDirectories)
						.outputDirectory(outputDirectory)
						.namespace(namespace)
						.enableRootGuess(enableRootGuess)
						.targets(targets)
						.enableFailFast(enableFailFast);
					driver = new Json2Driver(conf);
				}
			}
		}
		return driver;
	}

	@Override
	public void run() {
		getDriver().run();
	}

}
