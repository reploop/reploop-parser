package org.reploop.parser;

import org.reploop.parser.thrift.ThriftParser;
import org.reploop.parser.thrift.tree.ThriftProgram;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 21
 */
public class JarIdlTest {
    FileExtensionFilter filter;
    FileExtensionFilter jar;
    JarFinder finder;
    ThriftParser thriftParser;

    @BeforeMethod
    public void setUp() throws Exception {
        thriftParser = new ThriftParser();
        finder = new JarFinder();
        filter = new FileExtensionFilter("proto", "thrift");
        jar = new FileExtensionFilter("jar");
    }

    private Stream<Path> files(Path path) throws IOException {
        return Files.find(path, 2, (p, attributes) -> !attributes.isDirectory());
    }

    Map<Path, Reader> find(Path path) throws IOException {
        final Map<Path, Reader> idlMap = new HashMap<>();
        if (Files.isDirectory(path)) {
            Files.list(path).forEach(sp -> {
                if (!Files.isDirectory(sp)) {
                    try {
                        idlMap.putAll(find(sp));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            File file = path.toFile();
            String name = file.getName();
            if (filter.accept(name)) {
                idlMap.put(path, new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            } else if (jar.accept(name)) {
                JarFile jarFile = new JarFile(file);
                Map<Path, Reader> map = finder.list(jarFile, filter);
                if (null != map) {
                    idlMap.putAll(map);
                }
            }
        }
        return idlMap;
    }

    @Test
    public void testAll() throws Exception {
        String classpath = System.getProperty("java.class.path");
        String[] paths = classpath.split(File.pathSeparator);
        Map<Path, Reader> idlMap = new HashMap<>();
        for (String path : paths) {
            Path p = Paths.get(path);
            idlMap.putAll(find(p));
        }
        idlMap.forEach((path, inputStream) -> {
            String name = path.toFile().getName();
            System.out.print(name);
            System.out.print("->");
            try {
                if (name.endsWith(".proto") && !name.endsWith("descriptor.proto")) {
                    ThriftProgram ThriftProgram = thriftParser.program(inputStream);
                    System.out.println(ThriftProgram);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        System.out.println(idlMap);
        System.out.println(classpath);
    }

    @Test
    public void testIDL() throws Exception {


    }
}
