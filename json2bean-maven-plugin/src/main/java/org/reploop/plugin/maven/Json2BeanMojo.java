package org.reploop.plugin.maven;

import com.google.common.base.Strings;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.reploop.translator.json.bean.Json2BeanApp;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Mojo(name = "bean")
public class Json2BeanMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;
    /**
     * JSON files.
     */
    @Parameter(readonly = true)
    private List<Path> files;
    /**
     * Output directory.
     */
    @Parameter(readonly = true, defaultValue = "${project.maven-gen}")
    private Path output;
    @Parameter(defaultValue = "true")
    private Boolean enableRootGuess;
    @Parameter
    private String namespace;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Json2BeanApp app = new Json2BeanApp();
        Stream<Path> all = listJsonFiles(files);
        all.forEach(path -> {
            try {
                if (Strings.isNullOrEmpty(namespace)) {
                    app.execute(path);
                } else {
                    app.execute(path, namespace);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public Stream<Path> listJsonFiles(List<Path> files) {
        if (CollectionUtils.isEmpty(files)) {
            return Stream.empty();
        }
        return Stream.empty();
    }
}
