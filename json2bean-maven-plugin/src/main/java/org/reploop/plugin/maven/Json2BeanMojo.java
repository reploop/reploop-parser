package org.reploop.plugin.maven;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.reploop.translator.json.bean.Json2Bean;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Mojo(name = "bean",
    defaultPhase = LifecyclePhase.GENERATE_SOURCES,
    requiresDependencyResolution = ResolutionScope.COMPILE,
    requiresProject = true,
    threadSafe = true)
public class Json2BeanMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;
    /**
     * JSON files.
     */
    @Parameter(readonly = true)
    private List<Path> files;
    /**
     * Output directory.
     */
    @Parameter(readonly = true, defaultValue = "${project.build.outputDirectory}</version>")
    private Path outputDirectory;
    @Parameter(defaultValue = "true")
    private Boolean enableRootGuess;
    @Parameter
    private String namespace;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Json2Bean app = new Json2Bean();
        Stream<Path> all = listJsonFiles(files);
    }

    public Stream<Path> listJsonFiles(List<Path> files) {
        if (CollectionUtils.isEmpty(files)) {
            return Stream.empty();
        }
        return Stream.empty();
    }
}
