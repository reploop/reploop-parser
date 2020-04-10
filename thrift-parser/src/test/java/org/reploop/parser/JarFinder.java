package org.reploop.parser;

import com.google.common.collect.ImmutableMap;

import com.qiyi.walle.parser.commons.FileExtensionFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-03-06 09
 */
public class JarFinder {
    private static final Logger LOG = LoggerFactory.getLogger(JarFinder.class);

    public List<JarFile> getJarFiles(String resource) throws IOException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Enumeration<URL> enumeration = cl.getResources(resource);
        List<JarFile> files = new ArrayList<JarFile>();
        while (enumeration.hasMoreElements()) {
            URL url = enumeration.nextElement();
            if ("jar".equals(url.getProtocol())) {
                String filename = url.getFile();
                int idx = filename.indexOf("!");
                if (-1 != idx) {
                    URI jar = URI.create(filename.substring(0, idx));
                    try {
                        files.add(new JarFile(new File(jar)));
                    } catch (IOException e) {
                        LOG.warn("Cannot get this resource {}", url, e);
                    }

                }
            }
        }
        return files;
    }

    public Map<Path, Reader> list(Path dir, FileExtensionFilter filter) {
        ImmutableMap.Builder<Path, Reader> map = ImmutableMap.builder();
        if (Files.isDirectory(dir)) {
            try {
                Stream<Path> paths = Files.list(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map.build();
    }

    public Map<Path, Reader> list(JarFile jar, FileExtensionFilter filter) {
        Enumeration<JarEntry> entries = jar.entries();
        Map<Path, Reader> nameContent = new HashMap<>();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            if (entry.isDirectory()) {
                continue;
            }
            String name = entry.getName();
            if (filter.accept(name)) {
                try {
                    nameContent.put(Paths.get(name), new InputStreamReader(jar.getInputStream(entry)));
                } catch (IOException e) {
                    LOG.error("Cannot read this entry {}", entry, e);
                }
            }
        }
        return nameContent;
    }
}
