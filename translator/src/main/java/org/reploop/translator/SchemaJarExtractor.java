package org.reploop.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-10-23 23
 */
public class SchemaJarExtractor {
    private static final Logger LOG = LoggerFactory.getLogger(SchemaJarExtractor.class);

    public void extractTo(Path dir, File jar) throws IOException {
        try (JarFile jarFile = new JarFile(jar)) {
            extractTo(dir, jarFile);
        } catch (IOException e) {
            LOG.error("Cannot handle this jar {} to dir {}", jar, dir, e);
        }
    }

    public void extractTo(Path dir, String jar) {
        try (JarFile jarFile = new JarFile(jar)) {
            extractTo(dir, jarFile);
        } catch (IOException e) {
            LOG.error("Cannot handle this jar {} to dir {}", jar, dir, e);
        }
    }

    private void extractTo(Path dir, JarFile jarFile) throws IOException {
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();
            Path path = dir.resolve(name);
            if (!Files.exists(path)) {
                if (jarEntry.isDirectory()) {
                    Files.createDirectory(path);
                } else {
                    InputStream inputStream = jarFile.getInputStream(jarEntry);
                    Files.createDirectories(path.getParent());
                    Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    public boolean delete(Path dir) throws IOException {
        if (!Files.exists(dir)) {
            return false;
        }
        if (Files.isRegularFile(dir)) {
            return Files.deleteIfExists(dir);
        }
        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
        return true;
    }

    public Path findThenExtract(Path dest) {
        String classpath =
                (System.getProperty("java.class.path"));
        String[] paths = classpath.split(File.pathSeparator);
        for (String cp : paths) {
            if (cp.contains("knowledge-idl-")) {
                Path path = Paths.get(cp);
                String dir = path.getFileName().toString();
                int idx = dir.lastIndexOf("");
                if (idx > 0) {
                    dir = dir.substring(0, idx);
                }
                try {
                    delete(dest);
                    Files.createDirectories(dest);
                    extractTo(dest, cp);
                    return dest;
                } catch (Exception e) {
                    LOG.error("Cannot create a temp dir {}", dir, e);
                }
            }
        }
        return null;
    }
}
