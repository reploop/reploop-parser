import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import order.Data; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable {
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
                .add("code", code)
                .add("data", data)
                .add("msg", msg)
                .toString();
    }
    
    public static Builder newOrderBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Order data = new Order();
        
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
        
        public Order build() {
            return data;
        }
        
    }
    
}
