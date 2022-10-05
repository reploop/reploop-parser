package har.log.entries;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MimeTypeText implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mimeType;
    private String text;
    
    public String getMimeType() {
        return mimeType;
    }
    
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mimeType", getMimeType())
                .add("text", getText())
                .toString();
    }
    
}
