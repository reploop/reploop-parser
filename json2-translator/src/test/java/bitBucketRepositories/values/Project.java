package bitBucketRepositories.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import bitBucketRepositories.values.project.Links;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends ProjectWorkspace implements Serializable {
    private static final long serialVersionUID = 1L;
    private String key;
    private Links links;
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public Links getLinks() {
        return links;
    }
    
    public void setLinks(Links links) {
        this.links = links;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", getKey())
                .add("links", getLinks())
                .add("uUid", getUUid())
                .add("type", getType())
                .add("name", getName())
                .toString();
    }
    
    public static Builder newProjectBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Project data = new Project();
        
        public Builder key(String key) {
            data.setKey(key);
            return this;
        }
        
        public Builder links(Links links) {
            data.setLinks(links);
            return this;
        }
        
        public Builder uUid(String uUid) {
            data.setUUid(uUid);
            return this;
        }
        
        public Builder type(String type) {
            data.setType(type);
            return this;
        }
        
        public Builder name(String name) {
            data.setName(name);
            return this;
        }
        
        public Project build() {
            return data;
        }
        
    }
    
}
