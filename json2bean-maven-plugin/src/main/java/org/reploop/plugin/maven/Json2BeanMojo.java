package org.reploop.plugin.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.reploop.translator.json.bean.Json2Bean;
import org.reploop.translator.json.bean.Json2BeanApp;
import org.reploop.translator.json.bean.JsonMessageContext;

import java.io.IOException;

@Mojo(name = "json2bean")
public class Json2BeanMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Json2BeanApp app = new Json2BeanApp();
        Json2Bean json2Bean = new Json2Bean();
        JsonMessageContext ctx = new JsonMessageContext();
        try {
            json2Bean.execute("ctx", ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
