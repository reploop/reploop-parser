package req1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import req1.plan_prefer.Price; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanPrefer implements Serializable {
    private static final long serialVersionUID = 1L;
    private Price price;
    private List<Integer> star;
    private List<String> tags;
    
    public Price getPrice() {
        return price;
    }
    
    public void setPrice(Price price) {
        this.price = price;
    }
    
    public List<Integer> getStar() {
        return star;
    }
    
    public void setStar(List<Integer> star) {
        this.star = star;
    }
    
    public List<String> getTags() {
        return tags;
    }
    
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("star", star)
                .add("tags", tags)
                .toString();
    }
    
}
