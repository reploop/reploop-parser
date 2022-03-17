package org.reploop.translator.json;

import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class Json2BeanCommandTest {
    @Test
    public void name() throws Exception {
        Json2BeanCommand app = new Json2BeanCommand();
        String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
        URL u = URI.create(url).toURL();
        URL d = Json2BeanCommandTest.class.getResource("/");
        app.outputDirectory = Paths.get(d.toURI()).getParent().getParent().resolve("src/test/java").toString();
        app.execute(u.toURI(), "store");
    }

    @Test
    public void all() throws Exception {
        URL url = Json2BeanCommandTest.class.getResource("/");
        assertThat(url).isNotNull();
        Path dir = Paths.get(url.toURI());
        Path directory = dir.getParent().getParent().resolve("src/test/java");
        Files.list(dir)
            .filter(path -> path.toString().toLowerCase().endsWith(".json"))
            .forEach(path -> {
                try {
                    Json2BeanCommand app = new Json2BeanCommand();
                    app.enableRootGuess = true;
                    app.outputDirectory = directory.toString();
                    if (path.toString().contains("car_response.json")) {
                        app.execute(path);
                        System.out.println(path);
                    }
                } catch (Exception e) {
                    System.err.println(path);
                    e.printStackTrace();
                }
            });
    }
}