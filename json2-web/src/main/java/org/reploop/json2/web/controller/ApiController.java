package org.reploop.json2.web.controller;

import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ApiController {
    @PostMapping(value = "/json2/{target:\\s+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String json2(@RequestBody String body, @PathVariable("target") Target target) throws IOException {
        var dir = Files.createTempDirectory(target.ext());
        var file = dir.resolve("body.json");
        var out = dir.resolve("generated-sources");
        Files.writeString(file, body);
        Json2Conf conf = new Json2Conf()
            .inputDirectory(dir.toString())
            .outputDirectory(out.toString())
            .target(target)
            .enableFailFast(true);
        Json2Driver driver = new Json2Driver(conf);
        driver.run();

        List<String> merge = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(out, FileVisitOption.FOLLOW_LINKS)) {
            stream.forEach(path -> {
                int fc = path.getNameCount();
                int oc = out.getNameCount();
                merge.add(path.subpath(oc, fc).toString());
                try {
                    merge.addAll(Files.readAllLines(path));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return String.join(System.lineSeparator(), merge);
    }
}
