package org.reploop.plugin.maven;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Json2BeanMojoTest extends AbstractMojoTestCase {

    public void testJson2BeanMojo() throws Exception {
        Path pomPath = Paths.get("src/test/resources/json2bean-maven-project/pom.xml");
        File pom = Path.of(getBasedir()).resolve(pomPath).normalize().toFile();
        System.out.println(pom.toString());
        Json2BeanMojo json2BeanMojo = (Json2BeanMojo) lookupMojo("compile", pom);
    }
}