package res1.data.list.hotels.additional_info.plan_prefer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
    private Float lower;
    private Float upper;
    
    public Float getLower() {
        return lower;
    }
    
    public void setLower(Float lower) {
        this.lower = lower;
    }
    
    public Float getUpper() {
        return upper;
    }
    
    public void setUpper(Float upper) {
        this.upper = upper;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("lower", lower)
                .add("upper", upper)
                .toString();
    }
    
    public static Builder newPriceBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Price data = new Price();
        
        public Builder lower(Float lower) {
            data.setLower(lower);
            return this;
        }
        
        public Builder upper(Float upper) {
            data.setUpper(upper);
            return this;
        }
        
        public Price build() {
            return data;
        }
        
    }
    
}
