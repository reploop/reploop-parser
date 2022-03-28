package order.data.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RecordsUserOrderAdditional implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object settlementPrice;
    private Boolean night;
    private Object driverOrderId;
    private String createTime;
    private Object driverPhone;
    private Object operator;
    private Object vehicleBrand;
    private Object actionSource;
    private Object orderId;
    private Object delay;
    private Object preDriverId;
    
    public Object getSettlementPrice() {
        return settlementPrice;
    }
    
    public void setSettlementPrice(Object settlementPrice) {
        this.settlementPrice = settlementPrice;
    }
    
    public Boolean getNight() {
        return night;
    }
    
    public void setNight(Boolean night) {
        this.night = night;
    }
    
    public Object getDriverOrderId() {
        return driverOrderId;
    }
    
    public void setDriverOrderId(Object driverOrderId) {
        this.driverOrderId = driverOrderId;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public Object getDriverPhone() {
        return driverPhone;
    }
    
    public void setDriverPhone(Object driverPhone) {
        this.driverPhone = driverPhone;
    }
    
    public Object getOperator() {
        return operator;
    }
    
    public void setOperator(Object operator) {
        this.operator = operator;
    }
    
    public Object getVehicleBrand() {
        return vehicleBrand;
    }
    
    public void setVehicleBrand(Object vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
    
    public Object getActionSource() {
        return actionSource;
    }
    
    public void setActionSource(Object actionSource) {
        this.actionSource = actionSource;
    }
    
    public Object getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }
    
    public Object getDelay() {
        return delay;
    }
    
    public void setDelay(Object delay) {
        this.delay = delay;
    }
    
    public Object getPreDriverId() {
        return preDriverId;
    }
    
    public void setPreDriverId(Object preDriverId) {
        this.preDriverId = preDriverId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("settlementPrice", settlementPrice)
                .add("night", night)
                .add("driverOrderId", driverOrderId)
                .add("createTime", createTime)
                .add("driverPhone", driverPhone)
                .add("operator", operator)
                .add("vehicleBrand", vehicleBrand)
                .add("actionSource", actionSource)
                .add("orderId", orderId)
                .add("delay", delay)
                .add("preDriverId", preDriverId)
                .toString();
    }
    
}
