package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameValue implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("value", value)
            .toString();
    }

}
