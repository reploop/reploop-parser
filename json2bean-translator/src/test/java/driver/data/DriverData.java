package driver.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
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
                .add("address", address)
                .add("agentId", agentId)
                .add("banStatus", banStatus)
                .add("channel", channel)
                .add("cityName", cityName)
                .add("contactPhone", contactPhone)
                .add("idCardLocation", idCardLocation)
                .add("idNo", idNo)
                .add("idnOBackUrl", idnOBackUrl)
                .add("idnOFrontUrl", idnOFrontUrl)
                .add("licenceBackUrl", licenceBackUrl)
                .add("licenceFrontUrl", licenceFrontUrl)
                .add("name", name)
                .add("onlineGvid", onlineGvid)
                .add("qualificationUrl", qualificationUrl)
                .add("regTime", regTime)
                .add("sex", sex)
                .add("supplierId", supplierId)
                .toString();
    }
    
}
