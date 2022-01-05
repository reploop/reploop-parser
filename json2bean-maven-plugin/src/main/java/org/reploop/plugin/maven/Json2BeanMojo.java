package org.reploop.plugin.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.reploop.translator.json.bean.Json2Bean;

@Mojo(name = "json2bean")
public class Json2BeanMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Json2Bean json2Bean = new Json2Bean();
    }
}
