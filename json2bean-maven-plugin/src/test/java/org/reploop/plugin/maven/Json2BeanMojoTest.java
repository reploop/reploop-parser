package org.reploop.plugin.maven;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;
import java.net.URL;

public class Json2BeanMojoTest extends AbstractMojoTestCase {
    public void testJson2BeanMojo() throws Exception {
        URL pomUrl = Json2BeanMojoTest.class.getResource("/");
        System.out.println(pomUrl);
        File pom = new File(pomUrl.toURI());
        Json2BeanMojo json2BeanMojo = (Json2BeanMojo) lookupMojo("compile", pom);

    }
}