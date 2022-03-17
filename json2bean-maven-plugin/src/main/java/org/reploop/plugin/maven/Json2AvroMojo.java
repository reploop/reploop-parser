package org.reploop.plugin.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * https://avro.apache.org
 */
@Mojo(name = "avro")
public class Json2AvroMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
