package org.reploop.translator.json.bean;

import org.junit.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

public class Json2BeanAppTest {
    @Test
    public void name() throws Exception {
        Json2BeanApp app = new Json2BeanApp();
        String url = "https://cxsj.hnygst.com/prod-api/api/serviceList?name=&typeId=&longitude=&latitude=&page=1&limit=10";
        URL u = URI.create(url).toURL();
        URL d = Json2BeanAppTest.class.getResource("/");
        app.directory = Paths.get(d.toURI()).getParent().getParent().resolve("src/test/java");
        app.execute(u, "Store");
    }
}