package res1.data.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import res1.data.list.hotels.AdditionalInfo; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotels implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("additional_info")
    private AdditionalInfo additionalInfo;
    @JsonProperty("checkin")
    private String checkIn;
    private String checkout;
    @JsonProperty("coord")
    private String cooRd;
    @JsonProperty("hotel_id")
    private String hotelId;
    private String name;
    @JsonProperty("name_en")
    private String nameEn;
    private Integer price;
    private Integer star;
    private List<String> tags;
    
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }
    
    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
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
    
    public String getCooRd() {
        return cooRd;
    }
    
    public void setCooRd(String cooRd) {
        this.cooRd = cooRd;
    }
    
    public String getHotelId() {
        return hotelId;
    }
    
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNameEn() {
        return nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getStar() {
        return star;
    }
    
    public void setStar(Integer star) {
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
                .add("additionalInfo", additionalInfo)
                .add("checkIn", checkIn)
                .add("checkout", checkout)
                .add("cooRd", cooRd)
                .add("hotelId", hotelId)
                .add("name", name)
                .add("nameEn", nameEn)
                .add("price", price)
                .add("star", star)
                .add("tags", tags)
                .toString();
    }
    
}
