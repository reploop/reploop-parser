package bitBucketRepositories.values;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainBranch implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    
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
                .add("name", getName())
                .add("type", getType())
                .toString();
    }
    
    public static Builder newMainBranchBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final MainBranch data = new MainBranch();
        
        public Builder name(String name) {
            data.setName(name);
            return this;
        }
        
        public Builder type(String type) {
            data.setType(type);
            return this;
        }
        
        public MainBranch build() {
            return data;
        }
        
    }
    
}
