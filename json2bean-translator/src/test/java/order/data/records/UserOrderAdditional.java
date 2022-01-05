package order.data.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOrderAdditional extends RecordsUserOrderAdditional implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object adultNum;
    private Object beginSiteName;
    private Object createUser;
    private Object delFlag;
    private Object driverId;
    private Object driverIdNo;
    private String driverName;
    private Object endSiteName;
    private Object flightNumber;
    private Object id;
    private Object newDriverOrderId;
    private Object orderRemark;
    private Object remarks;
    private Object scheduleDate;
    private Object status;
    private Object updateTime;
    private Object updateUser;
    private Object vehicleColour;
    private Integer vehicleId;
    private String vehiclePlate;
    private String vehicleType;
    
    public Object getAdultNum() {
        return adultNum;
    }
    
    public void setAdultNum(Object adultNum) {
        this.adultNum = adultNum;
    }
    
    public Object getBeginSiteName() {
        return beginSiteName;
    }
    
    public void setBeginSiteName(Object beginSiteName) {
        this.beginSiteName = beginSiteName;
    }
    
    public Object getCreateUser() {
        return createUser;
    }
    
    public void setCreateUser(Object createUser) {
        this.createUser = createUser;
    }
    
    public Object getDelFlag() {
        return delFlag;
    }
    
    public void setDelFlag(Object delFlag) {
        this.delFlag = delFlag;
    }
    
    public Object getDriverId() {
        return driverId;
    }
    
    public void setDriverId(Object driverId) {
        this.driverId = driverId;
    }
    
    public Object getDriverIdNo() {
        return driverIdNo;
    }
    
    public void setDriverIdNo(Object driverIdNo) {
        this.driverIdNo = driverIdNo;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public Object getEndSiteName() {
        return endSiteName;
    }
    
    public void setEndSiteName(Object endSiteName) {
        this.endSiteName = endSiteName;
    }
    
    public Object getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(Object flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public Object getId() {
        return id;
    }
    
    public void setId(Object id) {
        this.id = id;
    }
    
    public Object getNewDriverOrderId() {
        return newDriverOrderId;
    }
    
    public void setNewDriverOrderId(Object newDriverOrderId) {
        this.newDriverOrderId = newDriverOrderId;
    }
    
    public Object getOrderRemark() {
        return orderRemark;
    }
    
    public void setOrderRemark(Object orderRemark) {
        this.orderRemark = orderRemark;
    }
    
    public Object getRemarks() {
        return remarks;
    }
    
    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }
    
    public Object getScheduleDate() {
        return scheduleDate;
    }
    
    public void setScheduleDate(Object scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
    
    public Object getStatus() {
        return status;
    }
    
    public void setStatus(Object status) {
        this.status = status;
    }
    
    public Object getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }
    
    public Object getUpdateUser() {
        return updateUser;
    }
    
    public void setUpdateUser(Object updateUser) {
        this.updateUser = updateUser;
    }
    
    public Object getVehicleColour() {
        return vehicleColour;
    }
    
    public void setVehicleColour(Object vehicleColour) {
        this.vehicleColour = vehicleColour;
    }
    
    public Integer getVehicleId() {
        return vehicleId;
    }
    
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("adultNum", adultNum)
                .add("beginSiteName", beginSiteName)
                .add("createUser", createUser)
                .add("delFlag", delFlag)
                .add("driverId", driverId)
                .add("driverIdNo", driverIdNo)
                .add("driverName", driverName)
                .add("endSiteName", endSiteName)
                .add("flightNumber", flightNumber)
                .add("id", id)
                .add("newDriverOrderId", newDriverOrderId)
                .add("orderRemark", orderRemark)
                .add("remarks", remarks)
                .add("scheduleDate", scheduleDate)
                .add("status", status)
                .add("updateTime", updateTime)
                .add("updateUser", updateUser)
                .add("vehicleColour", vehicleColour)
                .add("vehicleId", vehicleId)
                .add("vehiclePlate", vehiclePlate)
                .add("vehicleType", vehicleType)
                .toString();
    }
    
}
