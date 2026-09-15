package body;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CanShippedOrderParcelList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String parcelId;
    private String parcelName;
    
    public String getParcelId() {
        return parcelId;
    }
    
    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }
    
    public String getParcelName() {
        return parcelName;
    }
    
    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("parcelId", getParcelId())
                .add("parcelName", getParcelName())
                .toString();
    }
    
    public static Builder newCanShippedOrderParcelListBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final CanShippedOrderParcelList data = new CanShippedOrderParcelList();
        
        public Builder parcelId(String parcelId) {
            data.setParcelId(parcelId);
            return this;
        }
        
        public Builder parcelName(String parcelName) {
            data.setParcelName(parcelName);
            return this;
        }
        
        public CanShippedOrderParcelList build() {
            return data;
        }
        
    }
    
}
