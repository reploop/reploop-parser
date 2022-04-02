import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
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
                .add("code", getCode())
                .add("count", getCount())
                .add("date", getDate())
                .add("error", getError())
                .add("result", getResult())
                .toString();
    }
    
    public static Builder newUserBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final User data = new User();
        
        public Builder code(Integer code) {
            data.setCode(code);
            return this;
        }
        
        public Builder count(Integer count) {
            data.setCount(count);
            return this;
        }
        
        public Builder date(String date) {
            data.setDate(date);
            return this;
        }
        
        public Builder error(String error) {
            data.setError(error);
            return this;
        }
        
        public Builder result(List<Result> result) {
            data.setResult(result);
            return this;
        }
        
        public User build() {
            return data;
        }
        
    }
    
}
