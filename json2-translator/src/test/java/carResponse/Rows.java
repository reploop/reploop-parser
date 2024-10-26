package carResponse;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

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

	private Long driverUberId;

	private String driverUberName;

	private String driverUberPhone;

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

	public Long getDriverUberId() {
		return driverUberId;
	}

	public void setDriverUberId(Long driverUberId) {
		this.driverUberId = driverUberId;
	}

	public String getDriverUberName() {
		return driverUberName;
	}

	public void setDriverUberName(String driverUberName) {
		this.driverUberName = driverUberName;
	}

	public String getDriverUberPhone() {
		return driverUberPhone;
	}

	public void setDriverUberPhone(String driverUberPhone) {
		this.driverUberPhone = driverUberPhone;
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
			.add("brand", getBrand())
			.add("businessNature", getBusinessNature())
			.add("carType", getCarType())
			.add("colour", getColour())
			.add("createTime", getCreateTime())
			.add("createUser", getCreateUser())
			.add("delFlag", getDelFlag())
			.add("driverUberId", getDriverUberId())
			.add("driverUberName", getDriverUberName())
			.add("driverUberPhone", getDriverUberPhone())
			.add("endTime", getEndTime())
			.add("engineNo", getEngineNo())
			.add("files", getFiles())
			.add("fuelConsumption", getFuelConsumption())
			.add("id", getId())
			.add("kilometre", getKilometre())
			.add("kilometreStr", getKilometreStr())
			.add("obdStatus", getObdStatus())
			.add("officeId", getOfficeId())
			.add("plate", getPlate())
			.add("plateColour", getPlateColour())
			.add("remarks", getRemarks())
			.add("seating", getSeating())
			.add("settlementPrice", getSettlementPrice())
			.add("settlementPriceStr", getSettlementPriceStr())
			.add("startTime", getStartTime())
			.add("trafficCarType", getTrafficCarType())
			.add("type", getType())
			.add("updateTime", getUpdateTime())
			.add("updateUser", getUpdateUser())
			.add("vehicleDesc", getVehicleDesc())
			.add("vehicleNature", getVehicleNature())
			.add("vehicleNo", getVehicleNo())
			.add("vehicleStatus", getVehicleStatus())
			.add("vin", getVin())
			.toString();
	}

	public static Builder newRowsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Rows data = new Rows();

		public Builder brand(String brand) {
			data.setBrand(brand);
			return this;
		}

		public Builder businessNature(String businessNature) {
			data.setBusinessNature(businessNature);
			return this;
		}

		public Builder carType(String carType) {
			data.setCarType(carType);
			return this;
		}

		public Builder colour(String colour) {
			data.setColour(colour);
			return this;
		}

		public Builder createTime(String createTime) {
			data.setCreateTime(createTime);
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

		public Builder driverUberId(Long driverUberId) {
			data.setDriverUberId(driverUberId);
			return this;
		}

		public Builder driverUberName(String driverUberName) {
			data.setDriverUberName(driverUberName);
			return this;
		}

		public Builder driverUberPhone(String driverUberPhone) {
			data.setDriverUberPhone(driverUberPhone);
			return this;
		}

		public Builder endTime(Object endTime) {
			data.setEndTime(endTime);
			return this;
		}

		public Builder engineNo(String engineNo) {
			data.setEngineNo(engineNo);
			return this;
		}

		public Builder files(Object files) {
			data.setFiles(files);
			return this;
		}

		public Builder fuelConsumption(Object fuelConsumption) {
			data.setFuelConsumption(fuelConsumption);
			return this;
		}

		public Builder id(Integer id) {
			data.setId(id);
			return this;
		}

		public Builder kilometre(Object kilometre) {
			data.setKilometre(kilometre);
			return this;
		}

		public Builder kilometreStr(String kilometreStr) {
			data.setKilometreStr(kilometreStr);
			return this;
		}

		public Builder obdStatus(String obdStatus) {
			data.setObdStatus(obdStatus);
			return this;
		}

		public Builder officeId(String officeId) {
			data.setOfficeId(officeId);
			return this;
		}

		public Builder plate(String plate) {
			data.setPlate(plate);
			return this;
		}

		public Builder plateColour(String plateColour) {
			data.setPlateColour(plateColour);
			return this;
		}

		public Builder remarks(String remarks) {
			data.setRemarks(remarks);
			return this;
		}

		public Builder seating(Integer seating) {
			data.setSeating(seating);
			return this;
		}

		public Builder settlementPrice(Float settlementPrice) {
			data.setSettlementPrice(settlementPrice);
			return this;
		}

		public Builder settlementPriceStr(String settlementPriceStr) {
			data.setSettlementPriceStr(settlementPriceStr);
			return this;
		}

		public Builder startTime(Object startTime) {
			data.setStartTime(startTime);
			return this;
		}

		public Builder trafficCarType(String trafficCarType) {
			data.setTrafficCarType(trafficCarType);
			return this;
		}

		public Builder type(String type) {
			data.setType(type);
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

		public Builder vehicleDesc(String vehicleDesc) {
			data.setVehicleDesc(vehicleDesc);
			return this;
		}

		public Builder vehicleNature(String vehicleNature) {
			data.setVehicleNature(vehicleNature);
			return this;
		}

		public Builder vehicleNo(String vehicleNo) {
			data.setVehicleNo(vehicleNo);
			return this;
		}

		public Builder vehicleStatus(String vehicleStatus) {
			data.setVehicleStatus(vehicleStatus);
			return this;
		}

		public Builder vin(String vin) {
			data.setVin(vin);
			return this;
		}

		public Rows build() {
			return data;
		}

	}

}
