package res1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import res1.data.DataList; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<DataList> list;
    
    public List<DataList> getList() {
        return list;
    }
    
    public void setList(List<DataList> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("list", list)
                .toString();
    }
    
    public static Builder newDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Data data = new Data();
        
        public Builder list(List<DataList> list) {
            data.setList(list);
            return this;
        }
        
        public Data build() {
            return data;
        }
        
    }
    
}
