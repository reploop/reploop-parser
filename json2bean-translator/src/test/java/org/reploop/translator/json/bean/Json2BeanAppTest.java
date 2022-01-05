package org.reploop.translator.json.bean;

import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class Json2BeanAppTest {
    @Test
    public void name() throws Exception {
        Json2BeanApp app = new Json2BeanApp();
        String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
        URL u = URI.create(url).toURL();
        URL d = Json2BeanAppTest.class.getResource("/");
        app.directory = Paths.get(d.toURI()).getParent().getParent().resolve("src/test/java");
        app.execute(u.toURI(), "store");
    }

    @Test
    public void all() throws Exception {
        URL url = Json2BeanAppTest.class.getResource("/");
        assertThat(url).isNotNull();
        Path dir = Paths.get(url.toURI());
        Path directory = dir.getParent().getParent().resolve("src/test/java");
        Files.list(dir)
            .filter(path -> path.toString().toLowerCase().endsWith(".json"))
            .forEach(path -> {
                try {
                    Json2BeanApp app = new Json2BeanApp();
                    app.enableRootGuess = true;
                    app.directory = directory;
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