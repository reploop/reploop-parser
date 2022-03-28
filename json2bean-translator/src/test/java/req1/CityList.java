package req1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityList implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("checkin")
    private String checkIn;
    private String checkout;
    private String id;
    
    public String getCheckIn() {
        return checkIn;
    }
    
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    
    public String getCheckout() {
        return checkout;
    }
    
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("checkIn", checkIn)
                .add("checkout", checkout)
                .add("id", id)
                .toString();
    }
    
    public static Builder newCityListBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final CityList data = new CityList();
        
        public Builder checkIn(String checkIn) {
            data.setCheckIn(checkIn);
            return this;
        }
        
        public Builder checkout(String checkout) {
            data.setCheckout(checkout);
            return this;
        }
        
        public Builder id(String id) {
            data.setId(id);
            return this;
        }
        
        public CityList build() {
            return data;
        }
        
    }
    
}
