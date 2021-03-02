import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
import document.BoilingPoint; 
import document.Density; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("boiling_point")
    private BoilingPoint boilingPoint;
    private Boolean dangerous;
    private Density density;
    private String name;
    private String type;
    
    public BoilingPoint getBoilingPoint() {
        return boilingPoint;
    }
    
    public void setBoilingPoint(BoilingPoint boilingPoint) {
        this.boilingPoint = boilingPoint;
    }
    
    public Boolean getDangerous() {
        return dangerous;
    }
    
    public void setDangerous(Boolean dangerous) {
        this.dangerous = dangerous;
    }
    
    public Density getDensity() {
        return density;
    }
    
    public void setDensity(Density density) {
        this.density = density;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("boilingPoint", boilingPoint)
                .add("dangerous", dangerous)
                .add("density", density)
                .add("name", name)
                .add("type", type)
                .toString();
    }
    
}
