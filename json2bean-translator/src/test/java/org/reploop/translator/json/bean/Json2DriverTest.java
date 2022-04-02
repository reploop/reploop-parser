package org.reploop.translator.json.bean;

import org.junit.Test;
import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Json2DriverTest {
    @Test
    public void name() throws Exception {
        String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
        URL d = Json2DriverTest.class.getResource("/");
        String outputDirectory = Paths.get(d.toURI()).getParent().getParent().resolve("src/test/java").toString();
        Json2Conf conf = new Json2Conf().outputDirectory(outputDirectory);
        Json2Driver app = new Json2Driver(conf);
        app.execute(URI.create(url), "store");
    }

    @Test
    public void all() throws Exception {
        URL url = Json2DriverTest.class.getResource("/");
        assertThat(url).isNotNull();
        Path dir = Paths.get(url.toURI());
        Path directory = dir.getParent().getParent().resolve("src/test/");
        Files.list(dir)
            .filter(path -> path.toString().toLowerCase().endsWith(".json"))
            .forEach(path -> {
                try {
                    Json2Conf conf = new Json2Conf().enableRootGuess(true)
                        .targets(EnumSet.allOf(Target.class))
                        .outputDirectory(directory.toString());
                    Json2Driver app = new Json2Driver(conf);
                    if (!path.toString().contains("00.json")) {
                        app.execute(path);
                        System.out.println(path);
                    }
                } catch (Exception e) {
                    System.err.println(path);
                    e.printStackTrace();
                }
            });
    }

    @Test
    public void guessRoot() {
    }

    @Test
    public void testGuessRoot() {
    }

    @Test
    public void execute() {
    }

    @Test
    public void fromHTTP() {
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testExecute1() {
    }

    @Test
    public void testExecute2() {
    }

    @Test
    public void run() {
    }
}