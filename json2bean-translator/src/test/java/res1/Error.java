package res1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String reason;
    private String show;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getShow() {
        return show;
    }
    
    public void setShow(String show) {
        this.show = show;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("reason", reason)
                .add("show", show)
                .toString();
    }
    
}
