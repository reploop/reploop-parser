package drivers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
                .add("createTime", createTime)
                .add("createUser", createUser)
                .add("delFlag", delFlag)
                .add("driverLicenseExpiredTime", driverLicenseExpiredTime)
                .add("driverLicenseNo", driverLicenseNo)
                .add("driverLicenseType", driverLicenseType)
                .add("endTime", endTime)
                .add("files", files)
                .add("id", id)
                .add("idNo", idNo)
                .add("inServiceStatus", inServiceStatus)
                .add("jobNo", jobNo)
                .add("name", name)
                .add("numOrders", numOrders)
                .add("officeId", officeId)
                .add("passWord", passWord)
                .add("phone", phone)
                .add("remarks", remarks)
                .add("sex", sex)
                .add("startTime", startTime)
                .add("totalAmount", totalAmount)
                .add("updateTime", updateTime)
                .add("updateUser", updateUser)
                .add("userId", userId)
                .add("workStatus", workStatus)
                .toString();
    }
    
}
