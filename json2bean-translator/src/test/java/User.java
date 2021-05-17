import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import user.Result; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private Integer count;
    private String date;
    private String error;
    private List<Result> result;
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    public List<Result> getResult() {
        return result;
    }
    
    public void setResult(List<Result> result) {
        this.result = result;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("count", count)
                .add("date", date)
                .add("error", error)
                .add("result", result)
                .toString();
    }
    
}
