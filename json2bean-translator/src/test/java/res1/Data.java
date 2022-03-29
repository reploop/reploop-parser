package res1;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import res1.data.ListData;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ListData> list;
    
    public List<ListData> getList() {
        return list;
    }
    
    public void setList(List<ListData> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("list", getList())
                .toString();
    }
    
    public static Builder newDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Data data = new Data();
        
        public Builder list(List<ListData> list) {
            data.setList(list);
            return this;
        }
        
        public Data build() {
            return data;
        }
        
    }
    
}
