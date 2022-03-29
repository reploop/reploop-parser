import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import document.BoilingPoint;
import document.Density;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("boiling_point")
    private document.BoilingPoint boilingPoint;
    private Boolean dangerous;
    private document.Density density;
    private String name;
    private String type;
    
    public document.BoilingPoint getBoilingPoint() {
        return boilingPoint;
    }
    
    public void setBoilingPoint(document.BoilingPoint boilingPoint) {
        this.boilingPoint = boilingPoint;
    }
    
    public Boolean getDangerous() {
        return dangerous;
    }
    
    public void setDangerous(Boolean dangerous) {
        this.dangerous = dangerous;
    }
    
    public document.Density getDensity() {
        return density;
    }
    
    public void setDensity(document.Density density) {
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
                .add("boilingPoint", getBoilingPoint())
                .add("dangerous", getDangerous())
                .add("density", getDensity())
                .add("name", getName())
                .add("type", getType())
                .toString();
    }
    
    public static Builder newDocumentBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Document data = new Document();
        
        public Builder boilingPoint(document.BoilingPoint boilingPoint) {
            data.setBoilingPoint(boilingPoint);
            return this;
        }
        
        public Builder dangerous(Boolean dangerous) {
            data.setDangerous(dangerous);
            return this;
        }
        
        public Builder density(document.Density density) {
            data.setDensity(density);
            return this;
        }
        
        public Builder name(String name) {
            data.setName(name);
            return this;
        }
        
        public Builder type(String type) {
            data.setType(type);
            return this;
        }
        
        public Document build() {
            return data;
        }
        
    }
    
}
