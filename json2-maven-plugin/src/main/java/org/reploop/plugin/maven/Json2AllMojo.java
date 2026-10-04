package org.reploop.plugin.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.reploop.translator.json.support.Target;

import java.util.EnumSet;

/**
 * All in one.
 */
@Mojo(name = "all", defaultPhase = LifecyclePhase.GENERATE_SOURCES,
        requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class Json2AllMojo extends Json2Mojo {

    public Json2AllMojo() {
        super(EnumSet.allOf(Target.class));
    }

}
