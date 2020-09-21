package har.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Creator implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("version", version)
            .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Creator data = new Creator();

        public Builder name(String name) {
            data.setName(name);
            return this;
        }

        public Builder version(String version) {
            data.setVersion(version);
            return this;
        }

        public Creator build() {
            return data;
        }

    }

}
