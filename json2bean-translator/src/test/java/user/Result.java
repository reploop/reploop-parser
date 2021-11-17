package user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.Map; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("area_id")
    private String areaId;
    @JsonProperty("area_name")
    private String areaName;
    @JsonProperty("gd_edu")
    private String gdEdu;
    @JsonProperty("gd_job")
    private String gdJob;
    @JsonProperty("gd_major")
    private String gdMajor;
    @JsonProperty("gd_school")
    private String gdSchool;
    @JsonProperty("guide_price")
    private Map<Integer, Integer> guidePrice;
    private Integer price;
    private List<String> remark;
    @JsonProperty("ser_face")
    private String serFace;
    @JsonProperty("ser_hot")
    private String serHot;
    @JsonProperty("ser_rmkc")
    private String serRmkc;
    @JsonProperty("ser_sort")
    private String serSort;
    @JsonProperty("ser_starc")
    private String serStarC;
    @JsonProperty("ser_status")
    private String serStatus;
    @JsonProperty("ser_title")
    private String serTitle;
    @JsonProperty("ser_utime")
    private String serUTime;
    @JsonProperty("service_face")
    private String serviceFace;
    private Map<Integer, String> tag;
    @JsonProperty("user_avatar")
    private String userAvatar;
    @JsonProperty("user_gender")
    private String userGender;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_name")
    private String userName;
    
    public String getAreaId() {
        return areaId;
    }
    
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    
    public String getAreaName() {
        return areaName;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    public String getGdEdu() {
        return gdEdu;
    }
    
    public void setGdEdu(String gdEdu) {
        this.gdEdu = gdEdu;
    }
    
    public String getGdJob() {
        return gdJob;
    }
    
    public void setGdJob(String gdJob) {
        this.gdJob = gdJob;
    }
    
    public String getGdMajor() {
        return gdMajor;
    }
    
    public void setGdMajor(String gdMajor) {
        this.gdMajor = gdMajor;
    }
    
    public String getGdSchool() {
        return gdSchool;
    }
    
    public void setGdSchool(String gdSchool) {
        this.gdSchool = gdSchool;
    }
    
    public Map<Integer, Integer> getGuidePrice() {
        return guidePrice;
    }
    
    public void setGuidePrice(Map<Integer, Integer> guidePrice) {
        this.guidePrice = guidePrice;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public List<String> getRemark() {
        return remark;
    }
    
    public void setRemark(List<String> remark) {
        this.remark = remark;
    }
    
    public String getSerFace() {
        return serFace;
    }
    
    public void setSerFace(String serFace) {
        this.serFace = serFace;
    }
    
    public String getSerHot() {
        return serHot;
    }
    
    public void setSerHot(String serHot) {
        this.serHot = serHot;
    }
    
    public String getSerRmkc() {
        return serRmkc;
    }
    
    public void setSerRmkc(String serRmkc) {
        this.serRmkc = serRmkc;
    }
    
    public String getSerSort() {
        return serSort;
    }
    
    public void setSerSort(String serSort) {
        this.serSort = serSort;
    }
    
    public String getSerStarC() {
        return serStarC;
    }
    
    public void setSerStarC(String serStarC) {
        this.serStarC = serStarC;
    }
    
    public String getSerStatus() {
        return serStatus;
    }
    
    public void setSerStatus(String serStatus) {
        this.serStatus = serStatus;
    }
    
    public String getSerTitle() {
        return serTitle;
    }
    
    public void setSerTitle(String serTitle) {
        this.serTitle = serTitle;
    }
    
    public String getSerUTime() {
        return serUTime;
    }
    
    public void setSerUTime(String serUTime) {
        this.serUTime = serUTime;
    }
    
    public String getServiceFace() {
        return serviceFace;
    }
    
    public void setServiceFace(String serviceFace) {
        this.serviceFace = serviceFace;
    }
    
    public Map<Integer, String> getTag() {
        return tag;
    }
    
    public void setTag(Map<Integer, String> tag) {
        this.tag = tag;
    }
    
    public String getUserAvatar() {
        return userAvatar;
    }
    
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
    
    public String getUserGender() {
        return userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("areaId", areaId)
                .add("areaName", areaName)
                .add("gdEdu", gdEdu)
                .add("gdJob", gdJob)
                .add("gdMajor", gdMajor)
                .add("gdSchool", gdSchool)
                .add("guidePrice", guidePrice)
                .add("price", price)
                .add("remark", remark)
                .add("serFace", serFace)
                .add("serHot", serHot)
                .add("serRmkc", serRmkc)
                .add("serSort", serSort)
                .add("serStarC", serStarC)
                .add("serStatus", serStatus)
                .add("serTitle", serTitle)
                .add("serUTime", serUTime)
                .add("serviceFace", serviceFace)
                .add("tag", tag)
                .add("userAvatar", userAvatar)
                .add("userGender", userGender)
                .add("userId", userId)
                .add("userName", userName)
                .toString();
    }
    
}
