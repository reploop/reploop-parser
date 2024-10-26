package org.reploop.plugin.maven;

import java.util.EnumSet;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.reploop.translator.json.support.Target;

@Mojo(name = "go", defaultPhase = LifecyclePhase.GENERATE_SOURCES,
		requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class Json2GoMojo extends Json2Mojo {

	public Json2GoMojo() {
		super(EnumSet.of(Target.GO));
	}

}
