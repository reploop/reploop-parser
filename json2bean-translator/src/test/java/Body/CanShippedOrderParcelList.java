package Body;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
                .add("parcelId", parcelId)
                .add("parcelName", parcelName)
                .toString();
    }
    
}
