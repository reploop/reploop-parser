import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
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
                .add("driverLicenseNo", driverLicenseNo)
                .add("files", files)
                .add("id", id)
                .add("idNo", idNo)
                .add("name", name)
                .add("officeId", officeId)
                .add("phone", phone)
                .add("remarks", remarks)
                .add("sex", sex)
                .toString();
    }
    
}
