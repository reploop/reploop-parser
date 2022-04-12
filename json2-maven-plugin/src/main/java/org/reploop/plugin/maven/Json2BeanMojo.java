package org.reploop.plugin.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.reploop.translator.json.support.Target;

import java.util.EnumSet;

@Mojo(name = "bean",
    defaultPhase = LifecyclePhase.GENERATE_SOURCES,
    requiresDependencyResolution = ResolutionScope.COMPILE,
    requiresProject = true,
    threadSafe = true)
public class Json2BeanMojo extends Json2Mojo {

    public Json2BeanMojo() {
        super(EnumSet.of(Target.JAVA));
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getDriver().run();
    }
}
