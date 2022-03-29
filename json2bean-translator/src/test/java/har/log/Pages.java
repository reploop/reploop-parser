package har.log;

import har.log.pages.PageTimings;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pages implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private har.log.pages.PageTimings pageTimings;
    private String startedDateTime;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public har.log.pages.PageTimings getPageTimings() {
        return pageTimings;
    }
    
    public void setPageTimings(har.log.pages.PageTimings pageTimings) {
        this.pageTimings = pageTimings;
    }
    
    public String getStartedDateTime() {
        return startedDateTime;
    }
    
    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("pageTimings", getPageTimings())
                .add("startedDateTime", getStartedDateTime())
                .toString();
    }
    
    public static Builder newPagesBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Pages data = new Pages();
        
        public Builder id(String id) {
            data.setId(id);
            return this;
        }
        
        public Builder pageTimings(har.log.pages.PageTimings pageTimings) {
            data.setPageTimings(pageTimings);
            return this;
        }
        
        public Builder startedDateTime(String startedDateTime) {
            data.setStartedDateTime(startedDateTime);
            return this;
        }
        
        public Pages build() {
            return data;
        }
        
    }
    
}
