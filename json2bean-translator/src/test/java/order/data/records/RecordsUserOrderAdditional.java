package order.data.records;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RecordsUserOrderAdditional implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object operator;
    private Object vehicleBrand;
    private Object actionSource;
    private Object orderId;
    private Object preDriverId;
    private Object settlementPrice;
    private Object delay;
    private Boolean night;
    private Object driverOrderId;
    private Object driverPhone;
    private String createTime;
    
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
    
    public Object getPreDriverId() {
        return preDriverId;
    }
    
    public void setPreDriverId(Object preDriverId) {
        this.preDriverId = preDriverId;
    }
    
    public Object getSettlementPrice() {
        return settlementPrice;
    }
    
    public void setSettlementPrice(Object settlementPrice) {
        this.settlementPrice = settlementPrice;
    }
    
    public Object getDelay() {
        return delay;
    }
    
    public void setDelay(Object delay) {
        this.delay = delay;
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
    
    public Object getDriverPhone() {
        return driverPhone;
    }
    
    public void setDriverPhone(Object driverPhone) {
        this.driverPhone = driverPhone;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("operator", getOperator())
                .add("vehicleBrand", getVehicleBrand())
                .add("actionSource", getActionSource())
                .add("orderId", getOrderId())
                .add("preDriverId", getPreDriverId())
                .add("settlementPrice", getSettlementPrice())
                .add("delay", getDelay())
                .add("night", getNight())
                .add("driverOrderId", getDriverOrderId())
                .add("driverPhone", getDriverPhone())
                .add("createTime", getCreateTime())
                .toString();
    }
    
}
