package text;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Area> child;
    @JsonProperty("area_currency")
    private String areaCurrency;
    @JsonProperty("area_en")
    private String areaEn;
    @JsonProperty("area_fid")
    private String areaFid;
    @JsonProperty("area_id")
    private String areaId;
    @JsonProperty("area_image")
    private String areaImage;
    @JsonProperty("area_index")
    private String areaIndex;
    @JsonProperty("area_level")
    private String areaLevel;
    @JsonProperty("area_name")
    private String areaName;
    @JsonProperty("area_note")
    private String areaNote;
    @JsonProperty("area_pin")
    private String areaPin;
    @JsonProperty("area_px")
    private String areaPx;
    @JsonProperty("area_py")
    private String areaPy;
    @JsonProperty("area_show")
    private String areaShow;
    @JsonProperty("area_timezone")
    private String areaTimeZone;
    
    public List<Area> getChild() {
        return child;
    }
    
    public void setChild(List<Area> child) {
        this.child = child;
    }
    
    public String getAreaCurrency() {
        return areaCurrency;
    }
    
    public void setAreaCurrency(String areaCurrency) {
        this.areaCurrency = areaCurrency;
    }
    
    public String getAreaEn() {
        return areaEn;
    }
    
    public void setAreaEn(String areaEn) {
        this.areaEn = areaEn;
    }
    
    public String getAreaFid() {
        return areaFid;
    }
    
    public void setAreaFid(String areaFid) {
        this.areaFid = areaFid;
    }
    
    public String getAreaId() {
        return areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    
    public String getAreaImage() {
        return areaImage;
    }
    
    public void setAreaImage(String areaImage) {
        this.areaImage = areaImage;
    }
    
    public String getAreaIndex() {
        return areaIndex;
    }
    
    public void setAreaIndex(String areaIndex) {
        this.areaIndex = areaIndex;
    }
    
    public String getAreaLevel() {
        return areaLevel;
    }
    
    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }
    
    public String getAreaName() {
        return areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public String getAreaNote() {
        return areaNote;
    }
    
    public void setAreaNote(String areaNote) {
        this.areaNote = areaNote;
    }
    
    public String getAreaPin() {
        return areaPin;
    }
    
    public void setAreaPin(String areaPin) {
        this.areaPin = areaPin;
    }
    
    public String getAreaPx() {
        return areaPx;
    }
    
    public void setAreaPx(String areaPx) {
        this.areaPx = areaPx;
    }
    
    public String getAreaPy() {
        return areaPy;
    }
    
    public void setAreaPy(String areaPy) {
        this.areaPy = areaPy;
    }
    
    public String getAreaShow() {
        return areaShow;
    }
    
    public void setAreaShow(String areaShow) {
        this.areaShow = areaShow;
    }
    
    public String getAreaTimeZone() {
        return areaTimeZone;
    }
    
    public void setAreaTimeZone(String areaTimeZone) {
        this.areaTimeZone = areaTimeZone;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("child", child)
                .add("areaCurrency", areaCurrency)
                .add("areaEn", areaEn)
                .add("areaFid", areaFid)
                .add("areaId", areaId)
                .add("areaImage", areaImage)
                .add("areaIndex", areaIndex)
                .add("areaLevel", areaLevel)
                .add("areaName", areaName)
                .add("areaNote", areaNote)
                .add("areaPin", areaPin)
                .add("areaPx", areaPx)
                .add("areaPy", areaPy)
                .add("areaShow", areaShow)
                .add("areaTimeZone", areaTimeZone)
                .toString();
    }
    
}
