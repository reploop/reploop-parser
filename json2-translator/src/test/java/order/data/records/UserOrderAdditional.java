package order.data.records;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
                .add("adultNum", getAdultNum())
                .add("beginSiteName", getBeginSiteName())
                .add("createUser", getCreateUser())
                .add("delFlag", getDelFlag())
                .add("driverId", getDriverId())
                .add("driverIdNo", getDriverIdNo())
                .add("driverName", getDriverName())
                .add("endSiteName", getEndSiteName())
                .add("flightNumber", getFlightNumber())
                .add("id", getId())
                .add("newDriverOrderId", getNewDriverOrderId())
                .add("orderRemark", getOrderRemark())
                .add("remarks", getRemarks())
                .add("scheduleDate", getScheduleDate())
                .add("status", getStatus())
                .add("updateTime", getUpdateTime())
                .add("updateUser", getUpdateUser())
                .add("vehicleColour", getVehicleColour())
                .add("vehicleId", getVehicleId())
                .add("vehiclePlate", getVehiclePlate())
                .add("vehicleType", getVehicleType())
                .add("orderId", getOrderId())
                .add("settlementPrice", getSettlementPrice())
                .add("createTime", getCreateTime())
                .add("driverPhone", getDriverPhone())
                .add("actionSource", getActionSource())
                .add("night", getNight())
                .add("preDriverId", getPreDriverId())
                .add("driverOrderId", getDriverOrderId())
                .add("operator", getOperator())
                .add("vehicleBrand", getVehicleBrand())
                .add("delay", getDelay())
                .toString();
    }
    
    public static Builder newUserOrderAdditionalBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final UserOrderAdditional data = new UserOrderAdditional();
        
        public Builder adultNum(Object adultNum) {
            data.setAdultNum(adultNum);
            return this;
        }
        
        public Builder beginSiteName(Object beginSiteName) {
            data.setBeginSiteName(beginSiteName);
            return this;
        }
        
        public Builder createUser(Object createUser) {
            data.setCreateUser(createUser);
            return this;
        }
        
        public Builder delFlag(Object delFlag) {
            data.setDelFlag(delFlag);
            return this;
        }
        
        public Builder driverId(Object driverId) {
            data.setDriverId(driverId);
            return this;
        }
        
        public Builder driverIdNo(Object driverIdNo) {
            data.setDriverIdNo(driverIdNo);
            return this;
        }
        
        public Builder driverName(String driverName) {
            data.setDriverName(driverName);
            return this;
        }
        
        public Builder endSiteName(Object endSiteName) {
            data.setEndSiteName(endSiteName);
            return this;
        }
        
        public Builder flightNumber(Object flightNumber) {
            data.setFlightNumber(flightNumber);
            return this;
        }
        
        public Builder id(Object id) {
            data.setId(id);
            return this;
        }
        
        public Builder newDriverOrderId(Object newDriverOrderId) {
            data.setNewDriverOrderId(newDriverOrderId);
            return this;
        }
        
        public Builder orderRemark(Object orderRemark) {
            data.setOrderRemark(orderRemark);
            return this;
        }
        
        public Builder remarks(Object remarks) {
            data.setRemarks(remarks);
            return this;
        }
        
        public Builder scheduleDate(Object scheduleDate) {
            data.setScheduleDate(scheduleDate);
            return this;
        }
        
        public Builder status(Object status) {
            data.setStatus(status);
            return this;
        }
        
        public Builder updateTime(Object updateTime) {
            data.setUpdateTime(updateTime);
            return this;
        }
        
        public Builder updateUser(Object updateUser) {
            data.setUpdateUser(updateUser);
            return this;
        }
        
        public Builder vehicleColour(Object vehicleColour) {
            data.setVehicleColour(vehicleColour);
            return this;
        }
        
        public Builder vehicleId(Integer vehicleId) {
            data.setVehicleId(vehicleId);
            return this;
        }
        
        public Builder vehiclePlate(String vehiclePlate) {
            data.setVehiclePlate(vehiclePlate);
            return this;
        }
        
        public Builder vehicleType(String vehicleType) {
            data.setVehicleType(vehicleType);
            return this;
        }
        
        public Builder orderId(Object orderId) {
            data.setOrderId(orderId);
            return this;
        }
        
        public Builder settlementPrice(Object settlementPrice) {
            data.setSettlementPrice(settlementPrice);
            return this;
        }
        
        public Builder createTime(String createTime) {
            data.setCreateTime(createTime);
            return this;
        }
        
        public Builder driverPhone(Object driverPhone) {
            data.setDriverPhone(driverPhone);
            return this;
        }
        
        public Builder actionSource(Object actionSource) {
            data.setActionSource(actionSource);
            return this;
        }
        
        public Builder night(Boolean night) {
            data.setNight(night);
            return this;
        }
        
        public Builder preDriverId(Object preDriverId) {
            data.setPreDriverId(preDriverId);
            return this;
        }
        
        public Builder driverOrderId(Object driverOrderId) {
            data.setDriverOrderId(driverOrderId);
            return this;
        }
        
        public Builder operator(Object operator) {
            data.setOperator(operator);
            return this;
        }
        
        public Builder vehicleBrand(Object vehicleBrand) {
            data.setVehicleBrand(vehicleBrand);
            return this;
        }
        
        public Builder delay(Object delay) {
            data.setDelay(delay);
            return this;
        }
        
        public UserOrderAdditional build() {
            return data;
        }
        
    }
    
}
