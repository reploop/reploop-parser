import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import goods.Result; 
import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object reason;
    private List<Result> result;
    private String resultCode;
    private Boolean success;
    
    public Object getReason() {
        return reason;
    }
    
    public void setReason(Object reason) {
        this.reason = reason;
    }
    
    public List<Result> getResult() {
        return result;
    }
    
    public void setResult(List<Result> result) {
        this.result = result;
    }
    
    public String getResultCode() {
        return resultCode;
    }
    
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("reason", reason)
                .add("result", result)
                .add("resultCode", resultCode)
                .add("success", success)
                .toString();
    }
    
    public static Builder newGoodsBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Goods data = new Goods();
        
        public Builder reason(Object reason) {
            data.setReason(reason);
            return this;
        }
        
        public Builder result(List<Result> result) {
            data.setResult(result);
            return this;
        }
        
        public Builder resultCode(String resultCode) {
            data.setResultCode(resultCode);
            return this;
        }
        
        public Builder success(Boolean success) {
            data.setSuccess(success);
            return this;
        }
        
        public Goods build() {
            return data;
        }
        
    }
    
}
