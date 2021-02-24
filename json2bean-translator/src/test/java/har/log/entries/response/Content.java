package har.log.entries.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.entries.MimeTypeText; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content extends MimeTypeText implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer size;
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("size", size)
                .toString();
    }
    
}
