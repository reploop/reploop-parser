package detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Float discount;
    private Float full;
    private String marketingDetailId;
    private Integer marketingId;
    
    public Float getDiscount() {
        return discount;
    }
    
    public void setDiscount(Float discount) {
        this.discount = discount;
    }
    
    public Float getFull() {
        return full;
    }
    
    public void setFull(Float full) {
        this.full = full;
    }
    
    public String getMarketingDetailId() {
        return marketingDetailId;
    }
    
    public void setMarketingDetailId(String marketingDetailId) {
        this.marketingDetailId = marketingDetailId;
    }
    
    public Integer getMarketingId() {
        return marketingId;
    }
    
    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("discount", discount)
                .add("full", full)
                .add("marketingDetailId", marketingDetailId)
                .add("marketingId", marketingId)
                .toString();
    }
    
}
