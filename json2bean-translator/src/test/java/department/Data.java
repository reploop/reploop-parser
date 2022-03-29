package department;

import department.data.Items;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private List<department.data.Items> items;
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public List<department.data.Items> getItems() {
        return items;
    }
    
    public void setItems(List<department.data.Items> items) {
        this.items = items;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hasMore", getHasMore())
                .add("items", getItems())
                .toString();
    }
    
    public static Builder newDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Data data = new Data();
        
        public Builder hasMore(Boolean hasMore) {
            data.setHasMore(hasMore);
            return this;
        }
        
        public Builder items(List<department.data.Items> items) {
            data.setItems(items);
            return this;
        }
        
        public Data build() {
            return data;
        }
        
    }
    
}
