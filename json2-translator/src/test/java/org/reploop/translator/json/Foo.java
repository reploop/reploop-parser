package org.reploop.translator.json;

public abstract class Foo {
    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo{" +
            "name='" + name + '\'' +
            ", id=" + id +
            '}';
    }
}
