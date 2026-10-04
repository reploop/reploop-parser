package org.reploop.translator.json.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.util.Map;

public class SelfTest {

    final ObjectMapper mapper = JsonMapper.builder()
            .changeDefaultPropertyInclusion(value -> value.withContentInclusion(JsonInclude.Include.NON_NULL))
            .build();


    @Test
    public void testToJson() throws Exception {
        Self s = new Self(1, "name");
        This t = new This(s);
        t.setMap(ImmutableMap.of("k", s));

        System.out.println(mapper.writeValueAsString(s));
        System.out.println(mapper.writeValueAsString(t));
    }

}

class This extends Self {

    Map<String, Self> map;

    public This(Self self) {
        super(self);
    }

    @Override
    public Map<String, Self> getMap() {
        return map;
    }

    @Override
    public void setMap(Map<String, Self> map) {
        this.map = map;
    }

}

class Self {

    private int id;

    private String name;

    private Map<String, Self> map;

    public Self(Self o) {
        this(o.id, o.name);
    }

    public Self(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Self> getMap() {
        return map;
    }

    public void setMap(Map<String, Self> map) {
        this.map = map;
    }

}
