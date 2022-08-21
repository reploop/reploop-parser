package org.reploop.json2.web.controller;

import org.reploop.translator.json.driver.Json2Conf;
import org.reploop.translator.json.driver.Json2Driver;
import org.reploop.translator.json.support.Target;
import org.springframework.http.MediaType;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    @PostMapping(value = "/json2/{target:\\s+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String json2(@RequestBody String body, @PathVariable Target target) throws IOException {
        Json2Conf conf = conf().target(target);
        Path file = conf.getInputDirectories().stream()
            .map(Paths::get)
            .map(p -> p.resolve("body.json"))
            .findFirst()
            .orElseThrow();
        Files.writeString(file, body);
        Json2Driver driver = new Json2Driver(conf);
        driver.run();
        return cleanup(conf);
    }

    private Json2Conf conf() throws IOException {
        var inDir = Files.createTempDirectory("/json2/sources");
        var outDir = Files.createTempDirectory("/json2/generated");
        Json2Conf conf = new Json2Conf()
            .inputDirectory(inDir.toString())
            .outputDirectory(outDir.toString());
        return conf;
    }

    private String cleanup(Json2Conf conf) throws IOException {
        StringBuilder response = new StringBuilder();
        Path outDir = Path.of(conf.getOutputDirectory());
        List<Path> files = Files.list(outDir).collect(Collectors.toList());
        for (Path path : files) {
            response.append(Files.readString(path));
            response.append(System.lineSeparator());
        }
        List<String> inDir = conf.getInputDirectories();
        for (String dir : inDir) {
            FileSystemUtils.deleteRecursively(Path.of(dir));
        }
        FileSystemUtils.deleteRecursively(outDir);
        return response.toString();
    }

    @PostMapping(value = "url/json2/{target:\\s+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String url2json2(@RequestBody String url, @PathVariable Target target) throws IOException {
        Json2Conf conf = conf().uri(url).target(target);
        Json2Driver driver = new Json2Driver(conf);
        driver.run();
        return cleanup(conf);
    }
}
