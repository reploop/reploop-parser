import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private department.Data data;
    private String msg;
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public department.Data getData() {
        return data;
    }
    
    public void setData(department.Data data) {
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
    
    public static Builder newDepartmentBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Department data = new Department();
        
        public Builder code(Integer code) {
            data.setCode(code);
            return this;
        }
        
        public Builder data(department.Data data) {
            this.data.setData(data);
            return this;
        }
        
        public Builder msg(String msg) {
            data.setMsg(msg);
            return this;
        }
        
        public Department build() {
            return data;
        }
        
    }
    
}
