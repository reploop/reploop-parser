package order.data;

import order.data.records.RecordsUserOrderAdditional;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import order.data.records.UserOrderAdditional;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Records extends order.data.records.RecordsUserOrderAdditional implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer adultNum;
    private String beginGpsLat;
    private String beginGpsLong;
    private String beginSiteCode;
    private String beginSiteName;
    private Object boardingTime;
    private Boolean bookInAdvance;
    @JsonProperty("busticketReqList")
    private Object busTicketReqList;
    private Object cancelDuration;
    private Object cancelType;
    private Object childNum;
    private String contactName;
    private String contactPhone;
    private String contactSex;
    private String createUser;
    private String delFlag;
    @JsonProperty("dname")
    private String dName;
    private String driverArrivedTime;
    private Long driverId;
    private Object driverName;
    private String driverOrderStatus;
    private Object driverOrderUpdateTime;
    private String endGpsLat;
    private String endGpsLong;
    private String endSiteCode;
    private String endSiteName;
    private Object evaluation;
    private String flightNumber;
    private Integer id;
    private String lineType;
    private Object nextOrderNotifyType;
    private String no;
    private Object notifyType;
    private Object offTime;
    private Object openId;
    private Boolean orderPeriodValid;
    private String orderRemark;
    private String orderSource;
    private String orderTime;
    private Object points;
    private String remarks;
    private String scheduleDate;
    private Object score;
    private String status;
    private Object ticketStatus;
    private String updateTime;
    private String updateUser;
    private String useUpType;
    private Object userAct;
    private Object userNotifyType;
    private List<order.data.records.UserOrderAdditional> userOrderAdditional;
    private Object vehiclePlate;
    @JsonProperty("vplate")
    private String vPlate;
    @JsonProperty("vtype")
    private String vType;
    @JsonProperty("vvehicleId")
    private Integer vVehicleId;
    
    public Integer getAdultNum() {
        return adultNum;
    }
    
    public void setAdultNum(Integer adultNum) {
        this.adultNum = adultNum;
    }
    
    public String getBeginGpsLat() {
        return beginGpsLat;
    }
    
    public void setBeginGpsLat(String beginGpsLat) {
        this.beginGpsLat = beginGpsLat;
    }
    
    public String getBeginGpsLong() {
        return beginGpsLong;
    }
    
    public void setBeginGpsLong(String beginGpsLong) {
        this.beginGpsLong = beginGpsLong;
    }
    
    public String getBeginSiteCode() {
        return beginSiteCode;
    }
    
    public void setBeginSiteCode(String beginSiteCode) {
        this.beginSiteCode = beginSiteCode;
    }
    
    public String getBeginSiteName() {
        return beginSiteName;
    }
    
    public void setBeginSiteName(String beginSiteName) {
        this.beginSiteName = beginSiteName;
    }
    
    public Object getBoardingTime() {
        return boardingTime;
    }
    
    public void setBoardingTime(Object boardingTime) {
        this.boardingTime = boardingTime;
    }
    
    public Boolean getBookInAdvance() {
        return bookInAdvance;
    }
    
    public void setBookInAdvance(Boolean bookInAdvance) {
        this.bookInAdvance = bookInAdvance;
    }
    
    public Object getBusTicketReqList() {
        return busTicketReqList;
    }
    
    public void setBusTicketReqList(Object busTicketReqList) {
        this.busTicketReqList = busTicketReqList;
    }
    
    public Object getCancelDuration() {
        return cancelDuration;
    }
    
    public void setCancelDuration(Object cancelDuration) {
        this.cancelDuration = cancelDuration;
    }
    
    public Object getCancelType() {
        return cancelType;
    }
    
    public void setCancelType(Object cancelType) {
        this.cancelType = cancelType;
    }
    
    public Object getChildNum() {
        return childNum;
    }
    
    public void setChildNum(Object childNum) {
        this.childNum = childNum;
    }
    
    public String getContactName() {
        return contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    public String getContactPhone() {
        return contactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    public String getContactSex() {
        return contactSex;
    }
    
    public void setContactSex(String contactSex) {
        this.contactSex = contactSex;
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
    
    public String getDName() {
        return dName;
    }
    
    public void setDName(String dName) {
        this.dName = dName;
    }
    
    public String getDriverArrivedTime() {
        return driverArrivedTime;
    }
    
    public void setDriverArrivedTime(String driverArrivedTime) {
        this.driverArrivedTime = driverArrivedTime;
    }
    
    public Long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    
    public Object getDriverName() {
        return driverName;
    }
    
    public void setDriverName(Object driverName) {
        this.driverName = driverName;
    }
    
    public String getDriverOrderStatus() {
        return driverOrderStatus;
    }
    
    public void setDriverOrderStatus(String driverOrderStatus) {
        this.driverOrderStatus = driverOrderStatus;
    }
    
    public Object getDriverOrderUpdateTime() {
        return driverOrderUpdateTime;
    }
    
    public void setDriverOrderUpdateTime(Object driverOrderUpdateTime) {
        this.driverOrderUpdateTime = driverOrderUpdateTime;
    }
    
    public String getEndGpsLat() {
        return endGpsLat;
    }
    
    public void setEndGpsLat(String endGpsLat) {
        this.endGpsLat = endGpsLat;
    }
    
    public String getEndGpsLong() {
        return endGpsLong;
    }
    
    public void setEndGpsLong(String endGpsLong) {
        this.endGpsLong = endGpsLong;
    }
    
    public String getEndSiteCode() {
        return endSiteCode;
    }
    
    public void setEndSiteCode(String endSiteCode) {
        this.endSiteCode = endSiteCode;
    }
    
    public String getEndSiteName() {
        return endSiteName;
    }
    
    public void setEndSiteName(String endSiteName) {
        this.endSiteName = endSiteName;
    }
    
    public Object getEvaluation() {
        return evaluation;
    }
    
    public void setEvaluation(Object evaluation) {
        this.evaluation = evaluation;
    }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLineType() {
        return lineType;
    }
    
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }
    
    public Object getNextOrderNotifyType() {
        return nextOrderNotifyType;
    }
    
    public void setNextOrderNotifyType(Object nextOrderNotifyType) {
        this.nextOrderNotifyType = nextOrderNotifyType;
    }
    
    public String getNo() {
        return no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }
    
    public Object getNotifyType() {
        return notifyType;
    }
    
    public void setNotifyType(Object notifyType) {
        this.notifyType = notifyType;
    }
    
    public Object getOffTime() {
        return offTime;
    }
    
    public void setOffTime(Object offTime) {
        this.offTime = offTime;
    }
    
    public Object getOpenId() {
        return openId;
    }
    
    public void setOpenId(Object openId) {
        this.openId = openId;
    }
    
    public Boolean getOrderPeriodValid() {
        return orderPeriodValid;
    }
    
    public void setOrderPeriodValid(Boolean orderPeriodValid) {
        this.orderPeriodValid = orderPeriodValid;
    }
    
    public String getOrderRemark() {
        return orderRemark;
    }
    
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
    
    public String getOrderSource() {
        return orderSource;
    }
    
    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }
    
    public String getOrderTime() {
        return orderTime;
    }
    
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
    
    public Object getPoints() {
        return points;
    }
    
    public void setPoints(Object points) {
        this.points = points;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public String getScheduleDate() {
        return scheduleDate;
    }
    
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
    
    public Object getScore() {
        return score;
    }
    
    public void setScore(Object score) {
        this.score = score;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Object getTicketStatus() {
        return ticketStatus;
    }
    
    public void setTicketStatus(Object ticketStatus) {
        this.ticketStatus = ticketStatus;
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
    
    public String getUseUpType() {
        return useUpType;
    }
    
    public void setUseUpType(String useUpType) {
        this.useUpType = useUpType;
    }
    
    public Object getUserAct() {
        return userAct;
    }
    
    public void setUserAct(Object userAct) {
        this.userAct = userAct;
    }
    
    public Object getUserNotifyType() {
        return userNotifyType;
    }
    
    public void setUserNotifyType(Object userNotifyType) {
        this.userNotifyType = userNotifyType;
    }
    
    public List<order.data.records.UserOrderAdditional> getUserOrderAdditional() {
        return userOrderAdditional;
    }
    
    public void setUserOrderAdditional(List<order.data.records.UserOrderAdditional> userOrderAdditional) {
        this.userOrderAdditional = userOrderAdditional;
    }
    
    public Object getVehiclePlate() {
        return vehiclePlate;
    }
    
    public void setVehiclePlate(Object vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
    
    public String getVPlate() {
        return vPlate;
    }
    
    public void setVPlate(String vPlate) {
        this.vPlate = vPlate;
    }
    
    public String getVType() {
        return vType;
    }
    
    public void setVType(String vType) {
        this.vType = vType;
    }
    
    public Integer getVVehicleId() {
        return vVehicleId;
    }
    
    public void setVVehicleId(Integer vVehicleId) {
        this.vVehicleId = vVehicleId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("adultNum", getAdultNum())
                .add("beginGpsLat", getBeginGpsLat())
                .add("beginGpsLong", getBeginGpsLong())
                .add("beginSiteCode", getBeginSiteCode())
                .add("beginSiteName", getBeginSiteName())
                .add("boardingTime", getBoardingTime())
                .add("bookInAdvance", getBookInAdvance())
                .add("busTicketReqList", getBusTicketReqList())
                .add("cancelDuration", getCancelDuration())
                .add("cancelType", getCancelType())
                .add("childNum", getChildNum())
                .add("contactName", getContactName())
                .add("contactPhone", getContactPhone())
                .add("contactSex", getContactSex())
                .add("createUser", getCreateUser())
                .add("delFlag", getDelFlag())
                .add("dName", getDName())
                .add("driverArrivedTime", getDriverArrivedTime())
                .add("driverId", getDriverId())
                .add("driverName", getDriverName())
                .add("driverOrderStatus", getDriverOrderStatus())
                .add("driverOrderUpdateTime", getDriverOrderUpdateTime())
                .add("endGpsLat", getEndGpsLat())
                .add("endGpsLong", getEndGpsLong())
                .add("endSiteCode", getEndSiteCode())
                .add("endSiteName", getEndSiteName())
                .add("evaluation", getEvaluation())
                .add("flightNumber", getFlightNumber())
                .add("id", getId())
                .add("lineType", getLineType())
                .add("nextOrderNotifyType", getNextOrderNotifyType())
                .add("no", getNo())
                .add("notifyType", getNotifyType())
                .add("offTime", getOffTime())
                .add("openId", getOpenId())
                .add("orderPeriodValid", getOrderPeriodValid())
                .add("orderRemark", getOrderRemark())
                .add("orderSource", getOrderSource())
                .add("orderTime", getOrderTime())
                .add("points", getPoints())
                .add("remarks", getRemarks())
                .add("scheduleDate", getScheduleDate())
                .add("score", getScore())
                .add("status", getStatus())
                .add("ticketStatus", getTicketStatus())
                .add("updateTime", getUpdateTime())
                .add("updateUser", getUpdateUser())
                .add("useUpType", getUseUpType())
                .add("userAct", getUserAct())
                .add("userNotifyType", getUserNotifyType())
                .add("userOrderAdditional", getUserOrderAdditional())
                .add("vehiclePlate", getVehiclePlate())
                .add("vPlate", getVPlate())
                .add("vType", getVType())
                .add("vVehicleId", getVVehicleId())
                .add("delay", getDelay())
                .add("settlementPrice", getSettlementPrice())
                .add("driverPhone", getDriverPhone())
                .add("createTime", getCreateTime())
                .add("driverOrderId", getDriverOrderId())
                .add("operator", getOperator())
                .add("preDriverId", getPreDriverId())
                .add("actionSource", getActionSource())
                .add("night", getNight())
                .add("vehicleBrand", getVehicleBrand())
                .add("orderId", getOrderId())
                .toString();
    }
    
    public static Builder newRecordsBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Records data = new Records();
        
        public Builder adultNum(Integer adultNum) {
            data.setAdultNum(adultNum);
            return this;
        }
        
        public Builder beginGpsLat(String beginGpsLat) {
            data.setBeginGpsLat(beginGpsLat);
            return this;
        }
        
        public Builder beginGpsLong(String beginGpsLong) {
            data.setBeginGpsLong(beginGpsLong);
            return this;
        }
        
        public Builder beginSiteCode(String beginSiteCode) {
            data.setBeginSiteCode(beginSiteCode);
            return this;
        }
        
        public Builder beginSiteName(String beginSiteName) {
            data.setBeginSiteName(beginSiteName);
            return this;
        }
        
        public Builder boardingTime(Object boardingTime) {
            data.setBoardingTime(boardingTime);
            return this;
        }
        
        public Builder bookInAdvance(Boolean bookInAdvance) {
            data.setBookInAdvance(bookInAdvance);
            return this;
        }
        
        public Builder busTicketReqList(Object busTicketReqList) {
            data.setBusTicketReqList(busTicketReqList);
            return this;
        }
        
        public Builder cancelDuration(Object cancelDuration) {
            data.setCancelDuration(cancelDuration);
            return this;
        }
        
        public Builder cancelType(Object cancelType) {
            data.setCancelType(cancelType);
            return this;
        }
        
        public Builder childNum(Object childNum) {
            data.setChildNum(childNum);
            return this;
        }
        
        public Builder contactName(String contactName) {
            data.setContactName(contactName);
            return this;
        }
        
        public Builder contactPhone(String contactPhone) {
            data.setContactPhone(contactPhone);
            return this;
        }
        
        public Builder contactSex(String contactSex) {
            data.setContactSex(contactSex);
            return this;
        }
        
        public Builder createUser(String createUser) {
            data.setCreateUser(createUser);
            return this;
        }
        
        public Builder delFlag(String delFlag) {
            data.setDelFlag(delFlag);
            return this;
        }
        
        public Builder dName(String dName) {
            data.setDName(dName);
            return this;
        }
        
        public Builder driverArrivedTime(String driverArrivedTime) {
            data.setDriverArrivedTime(driverArrivedTime);
            return this;
        }
        
        public Builder driverId(Long driverId) {
            data.setDriverId(driverId);
            return this;
        }
        
        public Builder driverName(Object driverName) {
            data.setDriverName(driverName);
            return this;
        }
        
        public Builder driverOrderStatus(String driverOrderStatus) {
            data.setDriverOrderStatus(driverOrderStatus);
            return this;
        }
        
        public Builder driverOrderUpdateTime(Object driverOrderUpdateTime) {
            data.setDriverOrderUpdateTime(driverOrderUpdateTime);
            return this;
        }
        
        public Builder endGpsLat(String endGpsLat) {
            data.setEndGpsLat(endGpsLat);
            return this;
        }
        
        public Builder endGpsLong(String endGpsLong) {
            data.setEndGpsLong(endGpsLong);
            return this;
        }
        
        public Builder endSiteCode(String endSiteCode) {
            data.setEndSiteCode(endSiteCode);
            return this;
        }
        
        public Builder endSiteName(String endSiteName) {
            data.setEndSiteName(endSiteName);
            return this;
        }
        
        public Builder evaluation(Object evaluation) {
            data.setEvaluation(evaluation);
            return this;
        }
        
        public Builder flightNumber(String flightNumber) {
            data.setFlightNumber(flightNumber);
            return this;
        }
        
        public Builder id(Integer id) {
            data.setId(id);
            return this;
        }
        
        public Builder lineType(String lineType) {
            data.setLineType(lineType);
            return this;
        }
        
        public Builder nextOrderNotifyType(Object nextOrderNotifyType) {
            data.setNextOrderNotifyType(nextOrderNotifyType);
            return this;
        }
        
        public Builder no(String no) {
            data.setNo(no);
            return this;
        }
        
        public Builder notifyType(Object notifyType) {
            data.setNotifyType(notifyType);
            return this;
        }
        
        public Builder offTime(Object offTime) {
            data.setOffTime(offTime);
            return this;
        }
        
        public Builder openId(Object openId) {
            data.setOpenId(openId);
            return this;
        }
        
        public Builder orderPeriodValid(Boolean orderPeriodValid) {
            data.setOrderPeriodValid(orderPeriodValid);
            return this;
        }
        
        public Builder orderRemark(String orderRemark) {
            data.setOrderRemark(orderRemark);
            return this;
        }
        
        public Builder orderSource(String orderSource) {
            data.setOrderSource(orderSource);
            return this;
        }
        
        public Builder orderTime(String orderTime) {
            data.setOrderTime(orderTime);
            return this;
        }
        
        public Builder points(Object points) {
            data.setPoints(points);
            return this;
        }
        
        public Builder remarks(String remarks) {
            data.setRemarks(remarks);
            return this;
        }
        
        public Builder scheduleDate(String scheduleDate) {
            data.setScheduleDate(scheduleDate);
            return this;
        }
        
        public Builder score(Object score) {
            data.setScore(score);
            return this;
        }
        
        public Builder status(String status) {
            data.setStatus(status);
            return this;
        }
        
        public Builder ticketStatus(Object ticketStatus) {
            data.setTicketStatus(ticketStatus);
            return this;
        }
        
        public Builder updateTime(String updateTime) {
            data.setUpdateTime(updateTime);
            return this;
        }
        
        public Builder updateUser(String updateUser) {
            data.setUpdateUser(updateUser);
            return this;
        }
        
        public Builder useUpType(String useUpType) {
            data.setUseUpType(useUpType);
            return this;
        }
        
        public Builder userAct(Object userAct) {
            data.setUserAct(userAct);
            return this;
        }
        
        public Builder userNotifyType(Object userNotifyType) {
            data.setUserNotifyType(userNotifyType);
            return this;
        }
        
        public Builder userOrderAdditional(List<order.data.records.UserOrderAdditional> userOrderAdditional) {
            data.setUserOrderAdditional(userOrderAdditional);
            return this;
        }
        
        public Builder vehiclePlate(Object vehiclePlate) {
            data.setVehiclePlate(vehiclePlate);
            return this;
        }
        
        public Builder vPlate(String vPlate) {
            data.setVPlate(vPlate);
            return this;
        }
        
        public Builder vType(String vType) {
            data.setVType(vType);
            return this;
        }
        
        public Builder vVehicleId(Integer vVehicleId) {
            data.setVVehicleId(vVehicleId);
            return this;
        }
        
        public Builder delay(Object delay) {
            data.setDelay(delay);
            return this;
        }
        
        public Builder settlementPrice(Object settlementPrice) {
            data.setSettlementPrice(settlementPrice);
            return this;
        }
        
        public Builder driverPhone(Object driverPhone) {
            data.setDriverPhone(driverPhone);
            return this;
        }
        
        public Builder createTime(String createTime) {
            data.setCreateTime(createTime);
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
        
        public Builder preDriverId(Object preDriverId) {
            data.setPreDriverId(preDriverId);
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
        
        public Builder vehicleBrand(Object vehicleBrand) {
            data.setVehicleBrand(vehicleBrand);
            return this;
        }
        
        public Builder orderId(Object orderId) {
            data.setOrderId(orderId);
            return this;
        }
        
        public Records build() {
            return data;
        }
        
    }
    
}
