package har.log.entries.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.entries.MimeTypeText; 
import java.util.List; 
import har.log.entries.NameValue; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData extends MimeTypeText implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<NameValue> params;
    
    public List<NameValue> getParams() {
        return params;
    }
    
    public void setParams(List<NameValue> params) {
        this.params = params;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("params", params)
                .toString();
    }
    
}
