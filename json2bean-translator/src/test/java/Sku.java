import java.io.Serializable;
import java.util.List;
import sku.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object reason;
    private List<sku.Result> result;
    private String resultCode;
    private Boolean success;
    
    public Object getReason() {
        return reason;
    }
    
    public void setReason(Object reason) {
        this.reason = reason;
    }
    
    public List<sku.Result> getResult() {
        return result;
    }
    
    public void setResult(List<sku.Result> result) {
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
                .add("reason", getReason())
                .add("result", getResult())
                .add("resultCode", getResultCode())
                .add("success", getSuccess())
                .toString();
    }
    
    public static Builder newSkuBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Sku data = new Sku();
        
        public Builder reason(Object reason) {
            data.setReason(reason);
            return this;
        }
        
        public Builder result(List<sku.Result> result) {
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
        
        public Sku build() {
            return data;
        }
        
    }
    
}
