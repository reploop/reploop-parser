package res1.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
import res1.data.list.Hotels; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataList implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("city_id")
    private String cityId;
    private List<Hotels> hotels;
    @JsonProperty("max_price")
    private Integer maxPrice;
    @JsonProperty("min_price")
    private Integer minPrice;
    
    public String getCityId() {
        return cityId;
    }
    
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    
    public List<Hotels> getHotels() {
        return hotels;
    }
    
    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }
    
    public Integer getMaxPrice() {
        return maxPrice;
    }
    
    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
    
    public Integer getMinPrice() {
        return minPrice;
    }
    
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cityId", cityId)
                .add("hotels", hotels)
                .add("maxPrice", maxPrice)
                .add("minPrice", minPrice)
                .toString();
    }
    
    public static Builder newDataListBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final DataList data = new DataList();
        
        public Builder cityId(String cityId) {
            data.setCityId(cityId);
            return this;
        }
        
        public Builder hotels(List<Hotels> hotels) {
            data.setHotels(hotels);
            return this;
        }
        
        public Builder maxPrice(Integer maxPrice) {
            data.setMaxPrice(maxPrice);
            return this;
        }
        
        public Builder minPrice(Integer minPrice) {
            data.setMinPrice(minPrice);
            return this;
        }
        
        public DataList build() {
            return data;
        }
        
    }
    
}
