import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddCar implements Serializable {
    private static final long serialVersionUID = 1L;
    private String brand;
    private String colour;
    @JsonProperty("driverUberId")
    private Long driverUbeRId;
    private List<Object> files;
    private String id;
    private String officeId;
    private String plate;
    private String plateColour;
    private String remarks;
    private Integer seating;
    private Integer settlementPrice;
    private String trafficCarType;
    private String type;
    private String vehicleDesc;
    private String vehicleNature;
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public Long getDriverUbeRId() {
        return driverUbeRId;
    }
    
    public void setDriverUbeRId(Long driverUbeRId) {
        this.driverUbeRId = driverUbeRId;
    }
    
    public List<Object> getFiles() {
        return files;
    }
    
    public void setFiles(List<Object> files) {
        this.files = files;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getOfficeId() {
        return officeId;
    }
    
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
    
    public String getPlate() {
        return plate;
    }
    
    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    public String getPlateColour() {
        return plateColour;
    }
    
    public void setPlateColour(String plateColour) {
        this.plateColour = plateColour;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public Integer getSeating() {
        return seating;
    }
    
    public void setSeating(Integer seating) {
        this.seating = seating;
    }
    
    public Integer getSettlementPrice() {
        return settlementPrice;
    }
    
    public void setSettlementPrice(Integer settlementPrice) {
        this.settlementPrice = settlementPrice;
    }
    
    public String getTrafficCarType() {
        return trafficCarType;
    }
    
    public void setTrafficCarType(String trafficCarType) {
        this.trafficCarType = trafficCarType;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getVehicleDesc() {
        return vehicleDesc;
    }
    
    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }
    
    public String getVehicleNature() {
        return vehicleNature;
    }
    
    public void setVehicleNature(String vehicleNature) {
        this.vehicleNature = vehicleNature;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("brand", brand)
                .add("colour", colour)
                .add("driverUbeRId", driverUbeRId)
                .add("files", files)
                .add("id", id)
                .add("officeId", officeId)
                .add("plate", plate)
                .add("plateColour", plateColour)
                .add("remarks", remarks)
                .add("seating", seating)
                .add("settlementPrice", settlementPrice)
                .add("trafficCarType", trafficCarType)
                .add("type", type)
                .add("vehicleDesc", vehicleDesc)
                .add("vehicleNature", vehicleNature)
                .toString();
    }
    
}
