package org.reploop.plugin.maven;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

public class Json2BeanMojoTest extends AbstractMojoTestCase {

    public void testJson2BeanMojo() throws Exception {
        Json2BeanMojo json2BeanMojo = (Json2BeanMojo) lookupMojo("compile", getBasedir());
    }
}