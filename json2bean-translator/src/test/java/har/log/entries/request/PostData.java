package har.log.entries.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import har.log.entries.TextMimeType; 
import har.log.entries.ValueName; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData extends TextMimeType implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ValueName> params;
    
    public List<ValueName> getParams() {
        return params;
    }
    
    public void setParams(List<ValueName> params) {
        this.params = params;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("params", params)
                .toString();
    }
    
}
