package driver.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String address;

	@JsonProperty("agent_id")
	private Integer agentId;

	@JsonProperty("ban_status")
	private Integer banStatus;

	private String channel;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("contact_phone")
	private String contactPhone;

	@JsonProperty("id_card_location")
	private Integer idCardLocation;

	@JsonProperty("id_no")
	private String idNo;

	@JsonProperty("idno_back_url")
	private String idnOBackUrl;

	@JsonProperty("idno_front_url")
	private String idnOFrontUrl;

	@JsonProperty("licence_back_url")
	private String licenceBackUrl;

	@JsonProperty("licence_front_url")
	private String licenceFrontUrl;

	private String name;

	@JsonProperty("online_gvid")
	private String onlineGvid;

	@JsonProperty("qualification_url")
	private String qualificationUrl;

	@JsonProperty("reg_time")
	private String regTime;

	private String sex;

	@JsonProperty("supplier_id")
	private Integer supplierId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getBanStatus() {
		return banStatus;
	}

	public void setBanStatus(Integer banStatus) {
		this.banStatus = banStatus;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Integer getIdCardLocation() {
		return idCardLocation;
	}

	public void setIdCardLocation(Integer idCardLocation) {
		this.idCardLocation = idCardLocation;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdnOBackUrl() {
		return idnOBackUrl;
	}

	public void setIdnOBackUrl(String idnOBackUrl) {
		this.idnOBackUrl = idnOBackUrl;
	}

	public String getIdnOFrontUrl() {
		return idnOFrontUrl;
	}

	public void setIdnOFrontUrl(String idnOFrontUrl) {
		this.idnOFrontUrl = idnOFrontUrl;
	}

	public String getLicenceBackUrl() {
		return licenceBackUrl;
	}

	public void setLicenceBackUrl(String licenceBackUrl) {
		this.licenceBackUrl = licenceBackUrl;
	}

	public String getLicenceFrontUrl() {
		return licenceFrontUrl;
	}

	public void setLicenceFrontUrl(String licenceFrontUrl) {
		this.licenceFrontUrl = licenceFrontUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnlineGvid() {
		return onlineGvid;
	}

	public void setOnlineGvid(String onlineGvid) {
		this.onlineGvid = onlineGvid;
	}

	public String getQualificationUrl() {
		return qualificationUrl;
	}

	public void setQualificationUrl(String qualificationUrl) {
		this.qualificationUrl = qualificationUrl;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("address", getAddress())
			.add("agentId", getAgentId())
			.add("banStatus", getBanStatus())
			.add("channel", getChannel())
			.add("cityName", getCityName())
			.add("contactPhone", getContactPhone())
			.add("idCardLocation", getIdCardLocation())
			.add("idNo", getIdNo())
			.add("idnOBackUrl", getIdnOBackUrl())
			.add("idnOFrontUrl", getIdnOFrontUrl())
			.add("licenceBackUrl", getLicenceBackUrl())
			.add("licenceFrontUrl", getLicenceFrontUrl())
			.add("name", getName())
			.add("onlineGvid", getOnlineGvid())
			.add("qualificationUrl", getQualificationUrl())
			.add("regTime", getRegTime())
			.add("sex", getSex())
			.add("supplierId", getSupplierId())
			.toString();
	}

	public static Builder newDriverDataBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final DriverData data = new DriverData();

		public Builder address(String address) {
			data.setAddress(address);
			return this;
		}

		public Builder agentId(Integer agentId) {
			data.setAgentId(agentId);
			return this;
		}

		public Builder banStatus(Integer banStatus) {
			data.setBanStatus(banStatus);
			return this;
		}

		public Builder channel(String channel) {
			data.setChannel(channel);
			return this;
		}

		public Builder cityName(String cityName) {
			data.setCityName(cityName);
			return this;
		}

		public Builder contactPhone(String contactPhone) {
			data.setContactPhone(contactPhone);
			return this;
		}

		public Builder idCardLocation(Integer idCardLocation) {
			data.setIdCardLocation(idCardLocation);
			return this;
		}

		public Builder idNo(String idNo) {
			data.setIdNo(idNo);
			return this;
		}

		public Builder idnOBackUrl(String idnOBackUrl) {
			data.setIdnOBackUrl(idnOBackUrl);
			return this;
		}

		public Builder idnOFrontUrl(String idnOFrontUrl) {
			data.setIdnOFrontUrl(idnOFrontUrl);
			return this;
		}

		public Builder licenceBackUrl(String licenceBackUrl) {
			data.setLicenceBackUrl(licenceBackUrl);
			return this;
		}

		public Builder licenceFrontUrl(String licenceFrontUrl) {
			data.setLicenceFrontUrl(licenceFrontUrl);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder onlineGvid(String onlineGvid) {
			data.setOnlineGvid(onlineGvid);
			return this;
		}

		public Builder qualificationUrl(String qualificationUrl) {
			data.setQualificationUrl(qualificationUrl);
			return this;
		}

		public Builder regTime(String regTime) {
			data.setRegTime(regTime);
			return this;
		}

		public Builder sex(String sex) {
			data.setSex(sex);
			return this;
		}

		public Builder supplierId(Integer supplierId) {
			data.setSupplierId(supplierId);
			return this;
		}

		public DriverData build() {
			return data;
		}

	}

}
