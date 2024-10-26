import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddCar implements Serializable {

	private static final long serialVersionUID = 1L;

	private String brand;

	private String colour;

	private Long driverUberId;

	private List<Object> files;

	private String id;

	private String officeId;

	private String plate;

	private String plateColour;

	private String remarks;

	private Integer seating;

	private Integer settlementPrice;

	private String trafficCarType;

	private String type;

	private String vehicleDesc;

	private String vehicleNature;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Long getDriverUberId() {
		return driverUberId;
	}

	public void setDriverUberId(Long driverUberId) {
		this.driverUberId = driverUberId;
	}

	public List<Object> getFiles() {
		return files;
	}

	public void setFiles(List<Object> files) {
		this.files = files;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(Integer settlementPrice) {
		this.settlementPrice = settlementPrice;
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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("brand", getBrand())
			.add("colour", getColour())
			.add("driverUberId", getDriverUberId())
			.add("files", getFiles())
			.add("id", getId())
			.add("officeId", getOfficeId())
			.add("plate", getPlate())
			.add("plateColour", getPlateColour())
			.add("remarks", getRemarks())
			.add("seating", getSeating())
			.add("settlementPrice", getSettlementPrice())
			.add("trafficCarType", getTrafficCarType())
			.add("type", getType())
			.add("vehicleDesc", getVehicleDesc())
			.add("vehicleNature", getVehicleNature())
			.toString();
	}

	public static Builder newAddCarBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final AddCar data = new AddCar();

		public Builder brand(String brand) {
			data.setBrand(brand);
			return this;
		}

		public Builder colour(String colour) {
			data.setColour(colour);
			return this;
		}

		public Builder driverUberId(Long driverUberId) {
			data.setDriverUberId(driverUberId);
			return this;
		}

		public Builder files(List<Object> files) {
			data.setFiles(files);
			return this;
		}

		public Builder id(String id) {
			data.setId(id);
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

		public Builder settlementPrice(Integer settlementPrice) {
			data.setSettlementPrice(settlementPrice);
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

		public Builder vehicleDesc(String vehicleDesc) {
			data.setVehicleDesc(vehicleDesc);
			return this;
		}

		public Builder vehicleNature(String vehicleNature) {
			data.setVehicleNature(vehicleNature);
			return this;
		}

		public AddCar build() {
			return data;
		}

	}

}
