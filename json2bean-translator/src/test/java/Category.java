import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import category.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private Data data;
    private String msg;
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public Data getData() {
        return data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("data", getData())
                .add("msg", getMsg())
                .toString();
    }
    
    public static Builder newCategoryBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Category data = new Category();
        
        public Builder code(Integer code) {
            data.setCode(code);
            return this;
        }
        
        public Builder data(Data data) {
            this.data.setData(data);
            return this;
        }
        
        public Builder msg(String msg) {
            data.setMsg(msg);
            return this;
        }
        
        public Category build() {
            return data;
        }
        
    }
    
}
