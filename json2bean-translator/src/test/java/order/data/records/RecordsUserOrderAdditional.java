package order.data.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RecordsUserOrderAdditional implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object orderId;
    private Object actionSource;
    private Object delay;
    private Object operator;
    private Object settlementPrice;
    private Object vehicleBrand;
    private Object driverOrderId;
    private Object preDriverId;
    private Boolean night;
    private String createTime;
    private Object driverPhone;
    
    public Object getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }
    
    public Object getActionSource() {
        return actionSource;
    }
    
    public void setActionSource(Object actionSource) {
        this.actionSource = actionSource;
    }
    
    public Object getDelay() {
        return delay;
    }
    
    public void setDelay(Object delay) {
        this.delay = delay;
    }
    
    public Object getOperator() {
        return operator;
    }
    
    public void setOperator(Object operator) {
        this.operator = operator;
    }
    
    public Object getSettlementPrice() {
        return settlementPrice;
    }
    
    public void setSettlementPrice(Object settlementPrice) {
        this.settlementPrice = settlementPrice;
    }
    
    public Object getVehicleBrand() {
        return vehicleBrand;
    }
    
    public void setVehicleBrand(Object vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
    
    public Object getDriverOrderId() {
        return driverOrderId;
    }
    
    public void setDriverOrderId(Object driverOrderId) {
        this.driverOrderId = driverOrderId;
    }
    
    public Object getPreDriverId() {
        return preDriverId;
    }
    
    public void setPreDriverId(Object preDriverId) {
        this.preDriverId = preDriverId;
    }
    
    public Boolean getNight() {
        return night;
    }
    
    public void setNight(Boolean night) {
        this.night = night;
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
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("orderId", orderId)
                .add("actionSource", actionSource)
                .add("delay", delay)
                .add("operator", operator)
                .add("settlementPrice", settlementPrice)
                .add("vehicleBrand", vehicleBrand)
                .add("driverOrderId", driverOrderId)
                .add("preDriverId", preDriverId)
                .add("night", night)
                .add("createTime", createTime)
                .add("driverPhone", driverPhone)
                .toString();
    }
    
}
