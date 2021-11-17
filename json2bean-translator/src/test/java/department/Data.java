package department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import department.data.Items; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private List<Items> items;
    
    public Boolean getHasMore() {
        return hasMore;
    }
    
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    public List<Items> getItems() {
        return items;
    }
    
    public void setItems(List<Items> items) {
        this.items = items;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hasMore", hasMore)
                .add("items", items)
                .toString();
    }
    
}
