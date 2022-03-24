package org.reploop.translator.json;

import com.github.rvesse.airline.annotations.Option;
import org.reploop.translator.json.bean.Json2Conf;
import org.reploop.translator.json.bean.Json2Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * #1 URL resource
 * #2 file resource
 * #2 file resource in directory
 */
public class Json2Command implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Json2Command.class);
    @Option(name = {"--output", "-o"}, description = "Where the source code should go")
    String outputDirectory;
    @Option(name = {"--input", "-i"}, description = "Process all json file in the input directory.")
    List<String> inputDirectories;
    @Option(name = {"--uri"}, description = "An uri to specify where the JSON is. It's schema should be file, http or https, we can handle each of them differently.")
    List<String> uris;
    @Option(name = {"--enable-root-guess"}, description = "Try to guess a reasonable root name from the filename or the API uri given, otherwise $ is used by default.")
    Boolean enableRootGuess = true;
    @Option(name = {"--enable-fail-fast", "-ff"}, description = "Fail if any error occurred. Default true.")
    Boolean enableFailFast = true;
    @Option(name = {"--namespace", "-n"}, description = "The top package or namespace of the source. Add package line to the source. Default is empty.")
    String namespace;

    private volatile Json2Driver driver;

    protected Json2Driver getDriver() {
        if (null == driver) {
            synchronized (Json2Command.class) {
                if (null == driver) {
                    Json2Conf conf = new Json2Conf()
                            .uris(uris)
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
    public void run() {
        getDriver().run();
    }
}
