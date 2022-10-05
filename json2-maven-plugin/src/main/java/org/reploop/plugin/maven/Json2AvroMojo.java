package org.reploop.plugin.maven;

import java.util.EnumSet;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.reploop.translator.json.support.Target;

/**
 * https://avro.apache.org
 */
@Mojo(name = "avro",
    defaultPhase = LifecyclePhase.GENERATE_SOURCES,
    requiresDependencyResolution = ResolutionScope.COMPILE,
    threadSafe = true)
public class Json2AvroMojo extends Json2Mojo {

    public Json2AvroMojo() {
        super(EnumSet.of(Target.AVRO));
    }
}
