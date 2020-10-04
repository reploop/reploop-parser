package har.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.pages.PageTimings; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pages implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private PageTimings pageTimings;
    private String startedDateTime;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public PageTimings getPageTimings() {
        return pageTimings;
    }
    
    public void setPageTimings(PageTimings pageTimings) {
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
                .add("id", id)
                .add("pageTimings", pageTimings)
                .add("startedDateTime", startedDateTime)
                .toString();
    }
    
}
