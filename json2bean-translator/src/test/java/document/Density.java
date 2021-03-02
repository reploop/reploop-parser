package document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Density implements Serializable {
    private static final long serialVersionUID = 1L;
    private String units;
    private Float value;
    
    public String getUnits() {
        return units;
    }
    
    public void setUnits(String units) {
        this.units = units;
    }
    
    public Float getValue() {
        return value;
    }
    
    public void setValue(Float value) {
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
