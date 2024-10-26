package org.reploop.plugin.maven;

import java.util.EnumSet;
import java.util.List;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;

public abstract class Json2Mojo extends AbstractMojo {

	private final EnumSet<Target> targets;

	/**
	 * Maven Project that runs this plugin.
	 */
	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	protected MavenProject project;

	/**
	 * Where the source code should go
	 */
	@Parameter(defaultValue = "${project.build.output}")
	protected String outputDirectory;

	/**
	 * Process all json file in the input directory.
	 */
	@Parameter
	protected List<String> inputDirectories;

	/**
	 * An uri to specify where the JSON is. It's schema should be file, http or https, we
	 * can handle each of them differently.
	 */
	@Parameter
	protected List<String> uris;

	/**
	 * Try to guess a reasonable root name from the filename or the API uri given,
	 * otherwise $ is used by default.
	 */
	@Parameter(defaultValue = "true")
	protected final Boolean enableRootGuess = true;

	/**
	 * Fail if any error occurred. Default true.
	 */
	@Parameter(defaultValue = "true")
	protected final Boolean enableFailFast = true;

	/**
	 * The top package or namespace of the source. Add package line to the source. Default
	 * is empty.
	 */
	@Parameter
	protected String namespace;

	private volatile Json2Driver driver;

	public Json2Mojo(EnumSet<Target> targets) {
		this.targets = targets;
	}

	protected Json2Driver getDriver() {
		if (null == driver) {
			synchronized (Json2Mojo.class) {
				if (null == driver) {
					Json2Conf conf = new Json2Conf().uris(uris)
						.targets(targets)
						.inputDirectories(inputDirectories)
						.outputDirectory(outputDirectory)
						.namespace(namespace)
						.enableRootGuess(enableRootGuess)
						.enableFailFast(enableFailFast);
					driver = new Json2Driver(conf);
				}
			}
		}
		return driver;
	}

	@Override
	public void execute() {
		getDriver().run();
	}

}
