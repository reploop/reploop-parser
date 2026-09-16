package message.messages.mv;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
    
    public static Builder newUploadInfoBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final UploadInfo data = new UploadInfo();
        
        public UploadInfo build() {
            return data;
        }
        
    }
    
}
