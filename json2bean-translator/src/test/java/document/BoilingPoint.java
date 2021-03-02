package document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoilingPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private String units;
    private Double value;
    
    public String getUnits() {
        return units;
    }
    
    public void setUnits(String units) {
        this.units = units;
    }
    
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("units", units)
                .add("value", value)
                .toString();
    }
    
}
