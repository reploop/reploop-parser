package org.reploop.translator.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.QualifiedName;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyser {
    private static class MapType extends TypeReference<Map<String, Object>> {

    }

    static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
        mapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);

    }

    public static void main(String... args) throws IOException {
        File file = Paths.get("/tmp").toFile();
        Json2Bean jb = new Json2Bean(file, "org.reploop.cloud.oven.workshop.model.parse");
        Map<String, List<Map<String, Object>>> groupByNames = new HashMap<>();
        Pattern p = Pattern.compile("recieve(.*)?callback(.*)?data=\\[(.*?)](\\s*sign=\\[.*])?$");
        Files.lines(Paths.get("d:\\pipelineproxy.log"))
                .filter(s -> s.contains("CallbackController"))
                .forEach(s -> {
                    Matcher matcher = p.matcher(s.trim());
                    if (matcher.find()) {
                        String name = matcher.group(1).trim();
                        String json = matcher.group(3).trim();
                        try {
                            Map<String, Object> map = mapper.readValue(json, new MapType());
                            groupByNames.computeIfAbsent(name, key -> new ArrayList<>()).add(map);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

        System.out.println(groupByNames.size());
        groupByNames.forEach((name, list) -> {
            String text = merge(list);
            if (null != text) {
                String[] elements = name.split("\\s");
                QualifiedName q = null;
                StringBuilder sb = new StringBuilder();
                for (String ele : elements) {
                    String l = ele.toLowerCase();
                    if (null == q) {
                        q = QualifiedName.of(l);
                    } else {
                        q = QualifiedName.of(q, l);
                    }
                    sb.append(StringUtils.capitalize(l));
                }
                QualifiedName qn = QualifiedName.of(q, sb.toString());
                QualifiedName fqn = Optional.ofNullable(jb.getPkg())
                        .map(QualifiedName::of)
                        .map(n -> QualifiedName.of(n, qn))
                        .orElse(qn);
                jb.execute(fqn, new StringReader(text));
            }
        });
    }

    private static String merge(List<Map<String, Object>> list) {
        Map<String, Object> value = new HashMap<>();
        for (Map<String, Object> map : list) {
            mergeMap(value, map);
        }
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object mergeObj(Object obj1, Object obj2) {
        if (null == obj1) {
            return obj2;
        }
        if (null == obj2) {
            return obj1;
        }
        Class<?> c1 = obj1.getClass();
        Class<?> c2 = obj2.getClass();
        if (!c1.equals(c2)) {
            System.out.println("ERROR");
        }

        return obj1;
    }

    public static List<Object> mergeColl(List<Object> col1, List<Object> col2) {
        return ImmutableList.builder()
                .addAll(col1)
                .addAll(col2)
                .build();
    }

    public static Map<String, Object> mergeMap(Map<String, Object> total, Map<String, Object> value) {
        ImmutableSet<String> keys = ImmutableSet.<String>builder()
                .addAll(total.keySet())
                .addAll(value.keySet())
                .build();
        for (String key : keys) {
            Object val1 = total.get(key);
            Object val2 = value.get(key);
            if (null != val2) {
                if (null == val1) {
                    total.put(key, val2);
                } else {
                    if (val1 instanceof Map && val2 instanceof Map) {
                        Map<String, Object> m1 = (Map<String, Object>) val1;
                        Map<String, Object> m2 = (Map<String, Object>) val2;
                        total.put(key, mergeMap(m1, m2));
                    } else if (val1 instanceof List && val2 instanceof List) {
                        List<Object> col1 = (List<Object>) val1;
                        List<Object> col2 = (List<Object>) val2;
                        total.put(key, mergeColl(col1, col2));
                    } else {
                        Class<?> c1 = val1.getClass();
                        Class<?> c2 = val1.getClass();
                        if (!c1.equals(c2)) {
                            System.out.println(key);
                        }
                    }
                }
            }
        }
        return total;
    }
}
