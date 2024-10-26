package drivers;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rows implements Serializable {

	private static final long serialVersionUID = 1L;

	private String createTime;

	private Object createUser;

	private String delFlag;

	private Object driverLicenseExpiredTime;

	private String driverLicenseNo;

	private Object driverLicenseType;

	private Object endTime;

	private Object files;

	private Long id;

	private String idNo;

	private String inServiceStatus;

	private Object jobNo;

	private String name;

	private Integer numOrders;

	private String officeId;

	private String passWord;

	private String phone;

	private Object remarks;

	private String sex;

	private Object startTime;

	private Integer totalAmount;

	private String updateTime;

	private Object updateUser;

	private Object userId;

	private String workStatus;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Object getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Object createUser) {
		this.createUser = createUser;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Object getDriverLicenseExpiredTime() {
		return driverLicenseExpiredTime;
	}

	public void setDriverLicenseExpiredTime(Object driverLicenseExpiredTime) {
		this.driverLicenseExpiredTime = driverLicenseExpiredTime;
	}

	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}

	public Object getDriverLicenseType() {
		return driverLicenseType;
	}

	public void setDriverLicenseType(Object driverLicenseType) {
		this.driverLicenseType = driverLicenseType;
	}

	public Object getEndTime() {
		return endTime;
	}

	public void setEndTime(Object endTime) {
		this.endTime = endTime;
	}

	public Object getFiles() {
		return files;
	}

	public void setFiles(Object files) {
		this.files = files;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getInServiceStatus() {
		return inServiceStatus;
	}

	public void setInServiceStatus(String inServiceStatus) {
		this.inServiceStatus = inServiceStatus;
	}

	public Object getJobNo() {
		return jobNo;
	}

	public void setJobNo(Object jobNo) {
		this.jobNo = jobNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumOrders() {
		return numOrders;
	}

	public void setNumOrders(Integer numOrders) {
		this.numOrders = numOrders;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Object getRemarks() {
		return remarks;
	}

	public void setRemarks(Object remarks) {
		this.remarks = remarks;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Object getStartTime() {
		return startTime;
	}

	public void setStartTime(Object startTime) {
		this.startTime = startTime;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Object getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Object updateUser) {
		this.updateUser = updateUser;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("createTime", getCreateTime())
			.add("createUser", getCreateUser())
			.add("delFlag", getDelFlag())
			.add("driverLicenseExpiredTime", getDriverLicenseExpiredTime())
			.add("driverLicenseNo", getDriverLicenseNo())
			.add("driverLicenseType", getDriverLicenseType())
			.add("endTime", getEndTime())
			.add("files", getFiles())
			.add("id", getId())
			.add("idNo", getIdNo())
			.add("inServiceStatus", getInServiceStatus())
			.add("jobNo", getJobNo())
			.add("name", getName())
			.add("numOrders", getNumOrders())
			.add("officeId", getOfficeId())
			.add("passWord", getPassWord())
			.add("phone", getPhone())
			.add("remarks", getRemarks())
			.add("sex", getSex())
			.add("startTime", getStartTime())
			.add("totalAmount", getTotalAmount())
			.add("updateTime", getUpdateTime())
			.add("updateUser", getUpdateUser())
			.add("userId", getUserId())
			.add("workStatus", getWorkStatus())
			.toString();
	}

	public static Builder newRowsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Rows data = new Rows();

		public Builder createTime(String createTime) {
			data.setCreateTime(createTime);
			return this;
		}

		public Builder createUser(Object createUser) {
			data.setCreateUser(createUser);
			return this;
		}

		public Builder delFlag(String delFlag) {
			data.setDelFlag(delFlag);
			return this;
		}

		public Builder driverLicenseExpiredTime(Object driverLicenseExpiredTime) {
			data.setDriverLicenseExpiredTime(driverLicenseExpiredTime);
			return this;
		}

		public Builder driverLicenseNo(String driverLicenseNo) {
			data.setDriverLicenseNo(driverLicenseNo);
			return this;
		}

		public Builder driverLicenseType(Object driverLicenseType) {
			data.setDriverLicenseType(driverLicenseType);
			return this;
		}

		public Builder endTime(Object endTime) {
			data.setEndTime(endTime);
			return this;
		}

		public Builder files(Object files) {
			data.setFiles(files);
			return this;
		}

		public Builder id(Long id) {
			data.setId(id);
			return this;
		}

		public Builder idNo(String idNo) {
			data.setIdNo(idNo);
			return this;
		}

		public Builder inServiceStatus(String inServiceStatus) {
			data.setInServiceStatus(inServiceStatus);
			return this;
		}

		public Builder jobNo(Object jobNo) {
			data.setJobNo(jobNo);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder numOrders(Integer numOrders) {
			data.setNumOrders(numOrders);
			return this;
		}

		public Builder officeId(String officeId) {
			data.setOfficeId(officeId);
			return this;
		}

		public Builder passWord(String passWord) {
			data.setPassWord(passWord);
			return this;
		}

		public Builder phone(String phone) {
			data.setPhone(phone);
			return this;
		}

		public Builder remarks(Object remarks) {
			data.setRemarks(remarks);
			return this;
		}

		public Builder sex(String sex) {
			data.setSex(sex);
			return this;
		}

		public Builder startTime(Object startTime) {
			data.setStartTime(startTime);
			return this;
		}

		public Builder totalAmount(Integer totalAmount) {
			data.setTotalAmount(totalAmount);
			return this;
		}

		public Builder updateTime(String updateTime) {
			data.setUpdateTime(updateTime);
			return this;
		}

		public Builder updateUser(Object updateUser) {
			data.setUpdateUser(updateUser);
			return this;
		}

		public Builder userId(Object userId) {
			data.setUserId(userId);
			return this;
		}

		public Builder workStatus(String workStatus) {
			data.setWorkStatus(workStatus);
			return this;
		}

		public Rows build() {
			return data;
		}

	}

}
