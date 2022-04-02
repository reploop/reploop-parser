package org.reploop.plugin.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * All in one.
 */
@Mojo(name = "all")
public class Json2AllMojo extends Json2Mojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getDriver().run();
    }
}
