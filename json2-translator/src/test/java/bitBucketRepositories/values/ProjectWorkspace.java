package bitBucketRepositories.values;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProjectWorkspace implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("uuid")
    private String uUid;
    private String name;
    private String type;

    public String getUUid() {
        return uUid;
    }

    public void setUUid(String uUid) {
        this.uUid = uUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uUid", getUUid())
                .add("name", getName())
                .add("type", getType())
                .toString();
    }

}
