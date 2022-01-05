package order.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import order.data.records.RecordsUserOrderAdditional; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
import order.data.records.UserOrderAdditional; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Records extends RecordsUserOrderAdditional implements Serializable {
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
    private List<UserOrderAdditional> userOrderAdditional;
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
    
    public List<UserOrderAdditional> getUserOrderAdditional() {
        return userOrderAdditional;
    }
    
    public void setUserOrderAdditional(List<UserOrderAdditional> userOrderAdditional) {
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
                .add("adultNum", adultNum)
                .add("beginGpsLat", beginGpsLat)
                .add("beginGpsLong", beginGpsLong)
                .add("beginSiteCode", beginSiteCode)
                .add("beginSiteName", beginSiteName)
                .add("boardingTime", boardingTime)
                .add("bookInAdvance", bookInAdvance)
                .add("busTicketReqList", busTicketReqList)
                .add("cancelDuration", cancelDuration)
                .add("cancelType", cancelType)
                .add("childNum", childNum)
                .add("contactName", contactName)
                .add("contactPhone", contactPhone)
                .add("contactSex", contactSex)
                .add("createUser", createUser)
                .add("delFlag", delFlag)
                .add("dName", dName)
                .add("driverArrivedTime", driverArrivedTime)
                .add("driverId", driverId)
                .add("driverName", driverName)
                .add("driverOrderStatus", driverOrderStatus)
                .add("driverOrderUpdateTime", driverOrderUpdateTime)
                .add("endGpsLat", endGpsLat)
                .add("endGpsLong", endGpsLong)
                .add("endSiteCode", endSiteCode)
                .add("endSiteName", endSiteName)
                .add("evaluation", evaluation)
                .add("flightNumber", flightNumber)
                .add("id", id)
                .add("lineType", lineType)
                .add("nextOrderNotifyType", nextOrderNotifyType)
                .add("no", no)
                .add("notifyType", notifyType)
                .add("offTime", offTime)
                .add("openId", openId)
                .add("orderPeriodValid", orderPeriodValid)
                .add("orderRemark", orderRemark)
                .add("orderSource", orderSource)
                .add("orderTime", orderTime)
                .add("points", points)
                .add("remarks", remarks)
                .add("scheduleDate", scheduleDate)
                .add("score", score)
                .add("status", status)
                .add("ticketStatus", ticketStatus)
                .add("updateTime", updateTime)
                .add("updateUser", updateUser)
                .add("useUpType", useUpType)
                .add("userAct", userAct)
                .add("userNotifyType", userNotifyType)
                .add("userOrderAdditional", userOrderAdditional)
                .add("vehiclePlate", vehiclePlate)
                .add("vPlate", vPlate)
                .add("vType", vType)
                .add("vVehicleId", vVehicleId)
                .toString();
    }
    
}
