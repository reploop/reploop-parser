package org.reploop.translator.json.bean;

import org.junit.Ignore;
import org.junit.Test;
import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;

import javax.swing.text.EditorKit;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Json2DriverTest {

  @Test
  @Ignore
  public void name() throws Exception {
    String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
    URL d = Json2DriverTest.class.getResource("/");
    String outputDirectory = Paths.get(d.toURI()).getParent().getParent()
      .resolve("src/test/java").toString();
    Json2Conf conf = new Json2Conf().outputDirectory(outputDirectory);
    Json2Driver app = new Json2Driver(conf);
    app.execute(URI.create(url), "store");
  }

  @Test
  public void all() throws Exception {
    URL url = Json2DriverTest.class.getResource("/");
    assertThat(url).isNotNull();
    Path dir = Paths.get(url.toURI());
    Path directory = dir.getParent().getParent().resolve("target/generated-sources/");
    System.out.println(directory);
    Files.list(dir)
      .filter(path -> path.toString().toLowerCase().endsWith(".json"))
      .forEach(path -> {
        try {
          Json2Conf conf = new Json2Conf().enableRootGuess(true)
            .targets(EnumSet.of(Target.JAVA))
            .outputDirectory(directory.toString());
          Json2Driver app = new Json2Driver(conf);
          app.execute(path);
          System.out.println(path);
        } catch (Exception e) {
          System.err.println(path);
        }
      });
  }
}