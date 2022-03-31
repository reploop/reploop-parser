package message;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean success;
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("success", getSuccess())
                .toString();
    }
    
    public static Builder newResultBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Result data = new Result();
        
        public Builder success(Boolean success) {
            data.setSuccess(success);
            return this;
        }
        
        public Result build() {
            return data;
        }
        
    }
    
}
