package har.log.entries.request;

import java.io.Serializable;
import har.log.entries.MimeTypeText;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.NameValue;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData extends har.log.entries.MimeTypeText implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<har.log.entries.NameValue> params;
    
    public List<har.log.entries.NameValue> getParams() {
        return params;
    }
    
    public void setParams(List<har.log.entries.NameValue> params) {
        this.params = params;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("params", getParams())
                .add("mimeType", getMimeType())
                .add("text", getText())
                .toString();
    }
    
    public static Builder newPostDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final PostData data = new PostData();
        
        public Builder params(List<har.log.entries.NameValue> params) {
            data.setParams(params);
            return this;
        }
        
        public Builder mimeType(String mimeType) {
            data.setMimeType(mimeType);
            return this;
        }
        
        public Builder text(String text) {
            data.setText(text);
            return this;
        }
        
        public PostData build() {
            return data;
        }
        
    }
    
}
