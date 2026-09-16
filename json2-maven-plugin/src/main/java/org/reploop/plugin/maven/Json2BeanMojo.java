package org.reploop.plugin.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.reploop.translator.json.support.Target;

import java.util.EnumSet;

@Mojo(name = "bean", defaultPhase = LifecyclePhase.GENERATE_SOURCES,
        requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class Json2BeanMojo extends Json2Mojo {

    public Json2BeanMojo() {
        super(EnumSet.of(Target.JAVA));
    }

}
