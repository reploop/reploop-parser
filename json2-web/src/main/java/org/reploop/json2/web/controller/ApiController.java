package org.reploop.json2.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RestController
public class ApiController {
    @PostMapping(value = "/json2/{target:\\s+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String json2(@RequestBody String body, @PathVariable Target target) {
        return "hello world";
    }
}
