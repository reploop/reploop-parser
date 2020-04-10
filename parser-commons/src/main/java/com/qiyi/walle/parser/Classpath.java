package com.qiyi.walle.parser;

import com.qiyi.walle.parser.commons.LevenshteinDistance;

import java.nio.file.Path;
import java.util.*;

/**
 * Both thrift and protobuf dependencies.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-10 10
 */
public class Classpath<E> {
    // The namespace.
    private QualifiedName namespace;
    /**
     * The path to start search dependencies for. Thrift use relative path to declare dependencies,
     * while protobuf use absolute path to specify dependencies' paths. And the start point can set
     * to any path.
     * <p>
     * Put it another way, both thrift and protobuf use relative path. The only different is thrift
     * use path relative to the current file's path, but protobuf use path relative to a specific
     * path.
     */
    private Path path;
    /**
     * The current file.
     */
    private Path current;

    // All entities a file contains.
    private Map<Path, E> entities = new HashMap<>();
    private Map<Path, Set<QualifiedName>> names = new HashMap<>();
    // File and files included by the file.
    private Map<Path, Set<Path>> files = new HashMap<>();

    public Map<Path, Set<Path>> files() {
        return files;
    }

    public void files(Map<Path, Set<Path>> files) {
        this.files = files;
    }

    public Path current() {
        return current;
    }

    public Map<Path, Set<QualifiedName>> names() {
        return names;
    }

    public Map<Path, Set<QualifiedName>> names(Map<Path, Set<QualifiedName>> names) {
        if (null != names) {
            this.names.putAll(names);
        }
        return this.names;
    }

    public void clear() {
        names.clear();
    }

    public Set<QualifiedName> names(Path file) {
        return names.getOrDefault(file, Collections.emptySet());
    }

    public void name(QualifiedName name) {
        name(current(), name);
    }

    public void name(Path file, QualifiedName name) {
        names.computeIfAbsent(file, f -> new LinkedHashSet<>()).add(name);
    }

    public void current(Path file) {
        this.current = file;
    }

    public Map<Path, E> entities() {
        return entities;
    }

    public E entity(Path path) {
        return entities.get(path);
    }

    public boolean parsed(Path file) {
        return names.containsKey(file);
    }

    public boolean contains(Path path) {
        return entities.containsKey(path);
    }

    public void entity(Path path, E file) {
        this.entities.put(path, file);
    }

    public void entities(Map<Path, E> files) {
        this.entities.putAll(files);
    }

    public Set<Path> files(Path file) {
        return files.get(file);
    }

    public void file(Path include) {
        file(current, include);
    }

    public void file(Path file, Path include) {
        files.computeIfAbsent(file, f -> new LinkedHashSet<>()).add(include);
    }

    public QualifiedName namespace() {
        return namespace;
    }

    public void namespace(QualifiedName namespace) {
        this.namespace = namespace;
    }

    public void path(Path workingDirectory) {
        this.path = workingDirectory;
    }

    public Path path() {
        return path;
    }

    public static boolean contains(Set<QualifiedName> dependencies, QualifiedName name) {
        return dependencies.contains(name);
    }

    public static QualifiedName find(Set<QualifiedName> dependencies, QualifiedName name) {
        if (contains(dependencies, name)) {
            return name;
        }
        String classname = name.suffix();
        TreeMap<Integer, QualifiedName> map = new TreeMap<>();
        for (QualifiedName qualifiedName : dependencies) {
            int distance = LevenshteinDistance.compute(classname, qualifiedName.suffix());
            map.put(distance, qualifiedName);
        }
        return map.firstEntry().getValue();
    }


    public Classpath<E> copy() {
        Classpath<E> classpath = new Classpath<E>();
        classpath.current(current());
        classpath.path(path());
        classpath.namespace(namespace());
        classpath.entities(entities());
        classpath.files(files());
        return classpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classpath)) return false;
        Classpath<?> classpath = (Classpath<?>) o;
        return Objects.equals(current, classpath.current);
    }

    @Override
    public int hashCode() {
        return Objects.hash(current);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Classpath{");
        sb.append("namespace=").append(namespace);
        sb.append(", path=").append(path);
        sb.append(", current=").append(current);
        sb.append(", entities=").append(entities);
        sb.append(", files=").append(files);
        sb.append('}');
        return sb.toString();
    }
}
