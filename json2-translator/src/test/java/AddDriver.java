import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddDriver implements Serializable {

	private static final long serialVersionUID = 1L;

	private String driverLicenseNo;

	private List<Object> files;

	private String id;

	private String idNo;

	private String name;

	private String officeId;

	private Long phone;

	private String remarks;

	private String sex;

	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
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

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("driverLicenseNo", getDriverLicenseNo())
			.add("files", getFiles())
			.add("id", getId())
			.add("idNo", getIdNo())
			.add("name", getName())
			.add("officeId", getOfficeId())
			.add("phone", getPhone())
			.add("remarks", getRemarks())
			.add("sex", getSex())
			.toString();
	}

	public static Builder newAddDriverBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final AddDriver data = new AddDriver();

		public Builder driverLicenseNo(String driverLicenseNo) {
			data.setDriverLicenseNo(driverLicenseNo);
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

		public Builder idNo(String idNo) {
			data.setIdNo(idNo);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder officeId(String officeId) {
			data.setOfficeId(officeId);
			return this;
		}

		public Builder phone(Long phone) {
			data.setPhone(phone);
			return this;
		}

		public Builder remarks(String remarks) {
			data.setRemarks(remarks);
			return this;
		}

		public Builder sex(String sex) {
			data.setSex(sex);
			return this;
		}

		public AddDriver build() {
			return data;
		}

	}

}
