package order.data.records;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RecordsUserOrderAdditional implements Serializable {

	private static final long serialVersionUID = 1L;

	private String createTime;

	private Object delay;

	private Object vehicleBrand;

	private Object actionSource;

	private Boolean night;

	private Object operator;

	private Object settlementPrice;

	private Object orderId;

	private Object preDriverId;

	private Object driverPhone;

	private Object driverOrderId;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Object getDelay() {
		return delay;
	}

	public void setDelay(Object delay) {
		this.delay = delay;
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

	public Boolean getNight() {
		return night;
	}

	public void setNight(Boolean night) {
		this.night = night;
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

	public Object getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(Object driverPhone) {
		this.driverPhone = driverPhone;
	}

	public Object getDriverOrderId() {
		return driverOrderId;
	}

	public void setDriverOrderId(Object driverOrderId) {
		this.driverOrderId = driverOrderId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("createTime", getCreateTime())
			.add("delay", getDelay())
			.add("vehicleBrand", getVehicleBrand())
			.add("actionSource", getActionSource())
			.add("night", getNight())
			.add("operator", getOperator())
			.add("settlementPrice", getSettlementPrice())
			.add("orderId", getOrderId())
			.add("preDriverId", getPreDriverId())
			.add("driverPhone", getDriverPhone())
			.add("driverOrderId", getDriverOrderId())
			.toString();
	}

}
