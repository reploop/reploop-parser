package bitBucketRepositories.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProjectWorkspace implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
    private String name;
    @JsonProperty("uuid")
    private String uUid;
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUUid() {
        return uUid;
    }
    
    public void setUUid(String uUid) {
        this.uUid = uUid;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("type", getType())
                .add("name", getName())
                .add("uUid", getUUid())
                .toString();
    }
    
}
