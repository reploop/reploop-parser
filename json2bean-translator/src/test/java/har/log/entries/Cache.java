package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

public class Cache implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
    
    public static Builder newCacheBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Cache data = new Cache();
        
        public Cache build() {
            return data;
        }
        
    }
    
}
