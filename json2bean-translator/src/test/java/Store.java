import store.ListStore;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<store.ListStore> list;
    private String msg;
    private Boolean success;
    
    public List<store.ListStore> getList() {
        return list;
    }
    
    public void setList(List<store.ListStore> list) {
        this.list = list;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
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
                .add("list", getList())
                .add("msg", getMsg())
                .add("success", getSuccess())
                .toString();
    }
    
    public static Builder newStoreBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Store data = new Store();
        
        public Builder list(List<store.ListStore> list) {
            data.setList(list);
            return this;
        }
        
        public Builder msg(String msg) {
            data.setMsg(msg);
            return this;
        }
        
        public Builder success(Boolean success) {
            data.setSuccess(success);
            return this;
        }
        
        public Store build() {
            return data;
        }
        
    }
    
}
