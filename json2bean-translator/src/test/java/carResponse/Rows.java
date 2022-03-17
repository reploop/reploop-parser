package carResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rows implements Serializable {
    private static final long serialVersionUID = 1L;
    private String brand;
    private String businessNature;
    private String carType;
    private String colour;
    private String createTime;
    private String createUser;
    private String delFlag;
    @JsonProperty("driverUberId")
    private Long driverUbeRId;
    @JsonProperty("driverUberName")
    private String driverUbeRName;
    @JsonProperty("driverUberPhone")
    private String driverUbeRPhone;
    private Object endTime;
    private String engineNo;
    private Object files;
    private Object fuelConsumption;
    private Integer id;
    private Object kilometre;
    private String kilometreStr;
    private String obdStatus;
    private String officeId;
    private String plate;
    private String plateColour;
    private String remarks;
    private Integer seating;
    private Float settlementPrice;
    private String settlementPriceStr;
    private Object startTime;
    private String trafficCarType;
    private String type;
    private String updateTime;
    private String updateUser;
    private String vehicleDesc;
    private String vehicleNature;
    private String vehicleNo;
    private String vehicleStatus;
    private String vin;
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getBusinessNature() {
        return businessNature;
    }
    
    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }
    
    public String getCarType() {
        return carType;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    public String getDelFlag() {
        return delFlag;
    }
    
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    
    public Long getDriverUbeRId() {
        return driverUbeRId;
    }
    
    public void setDriverUbeRId(Long driverUbeRId) {
        this.driverUbeRId = driverUbeRId;
    }
    
    public String getDriverUbeRName() {
        return driverUbeRName;
    }
    
    public void setDriverUbeRName(String driverUbeRName) {
        this.driverUbeRName = driverUbeRName;
    }
    
    public String getDriverUbeRPhone() {
        return driverUbeRPhone;
    }
    
    public void setDriverUbeRPhone(String driverUbeRPhone) {
        this.driverUbeRPhone = driverUbeRPhone;
    }
    
    public Object getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }
    
    public String getEngineNo() {
        return engineNo;
    }
    
    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }
    
    public Object getFiles() {
        return files;
    }
    
    public void setFiles(Object files) {
        this.files = files;
    }
    
    public Object getFuelConsumption() {
        return fuelConsumption;
    }
    
    public void setFuelConsumption(Object fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Object getKilometre() {
        return kilometre;
    }
    
    public void setKilometre(Object kilometre) {
        this.kilometre = kilometre;
    }
    
    public String getKilometreStr() {
        return kilometreStr;
    }
    
    public void setKilometreStr(String kilometreStr) {
        this.kilometreStr = kilometreStr;
    }
    
    public String getObdStatus() {
        return obdStatus;
    }
    
    public void setObdStatus(String obdStatus) {
        this.obdStatus = obdStatus;
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
    
    public Float getSettlementPrice() {
        return settlementPrice;
    }
    
    public void setSettlementPrice(Float settlementPrice) {
        this.settlementPrice = settlementPrice;
    }
    
    public String getSettlementPriceStr() {
        return settlementPriceStr;
    }
    
    public void setSettlementPriceStr(String settlementPriceStr) {
        this.settlementPriceStr = settlementPriceStr;
    }
    
    public Object getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Object startTime) {
        this.startTime = startTime;
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
    
    public String getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
    
    public String getVehicleNo() {
        return vehicleNo;
    }
    
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    
    public String getVehicleStatus() {
        return vehicleStatus;
    }
    
    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("brand", brand)
                .add("businessNature", businessNature)
                .add("carType", carType)
                .add("colour", colour)
                .add("createTime", createTime)
                .add("createUser", createUser)
                .add("delFlag", delFlag)
                .add("driverUbeRId", driverUbeRId)
                .add("driverUbeRName", driverUbeRName)
                .add("driverUbeRPhone", driverUbeRPhone)
                .add("endTime", endTime)
                .add("engineNo", engineNo)
                .add("files", files)
                .add("fuelConsumption", fuelConsumption)
                .add("id", id)
                .add("kilometre", kilometre)
                .add("kilometreStr", kilometreStr)
                .add("obdStatus", obdStatus)
                .add("officeId", officeId)
                .add("plate", plate)
                .add("plateColour", plateColour)
                .add("remarks", remarks)
                .add("seating", seating)
                .add("settlementPrice", settlementPrice)
                .add("settlementPriceStr", settlementPriceStr)
                .add("startTime", startTime)
                .add("trafficCarType", trafficCarType)
                .add("type", type)
                .add("updateTime", updateTime)
                .add("updateUser", updateUser)
                .add("vehicleDesc", vehicleDesc)
                .add("vehicleNature", vehicleNature)
                .add("vehicleNo", vehicleNo)
                .add("vehicleStatus", vehicleStatus)
                .add("vin", vin)
                .toString();
    }
    
}
