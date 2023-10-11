package user;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
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
    private List<String> tag;
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
    
    public List<String> getTag() {
        return tag;
    }
    
    public void setTag(List<String> tag) {
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
                .add("areaId", getAreaId())
                .add("areaName", getAreaName())
                .add("gdEdu", getGdEdu())
                .add("gdJob", getGdJob())
                .add("gdMajor", getGdMajor())
                .add("gdSchool", getGdSchool())
                .add("guidePrice", getGuidePrice())
                .add("price", getPrice())
                .add("remark", getRemark())
                .add("serFace", getSerFace())
                .add("serHot", getSerHot())
                .add("serRmkc", getSerRmkc())
                .add("serSort", getSerSort())
                .add("serStarC", getSerStarC())
                .add("serStatus", getSerStatus())
                .add("serTitle", getSerTitle())
                .add("serUTime", getSerUTime())
                .add("serviceFace", getServiceFace())
                .add("tag", getTag())
                .add("userAvatar", getUserAvatar())
                .add("userGender", getUserGender())
                .add("userId", getUserId())
                .add("userName", getUserName())
                .toString();
    }
    
    public static Builder newResultBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Result data = new Result();
        
        public Builder areaId(String areaId) {
            data.setAreaId(areaId);
            return this;
        }
        
        public Builder areaName(String areaName) {
            data.setAreaName(areaName);
            return this;
        }
        
        public Builder gdEdu(String gdEdu) {
            data.setGdEdu(gdEdu);
            return this;
        }
        
        public Builder gdJob(String gdJob) {
            data.setGdJob(gdJob);
            return this;
        }
        
        public Builder gdMajor(String gdMajor) {
            data.setGdMajor(gdMajor);
            return this;
        }
        
        public Builder gdSchool(String gdSchool) {
            data.setGdSchool(gdSchool);
            return this;
        }
        
        public Builder guidePrice(Map<Integer, Integer> guidePrice) {
            data.setGuidePrice(guidePrice);
            return this;
        }
        
        public Builder price(Integer price) {
            data.setPrice(price);
            return this;
        }
        
        public Builder remark(List<String> remark) {
            data.setRemark(remark);
            return this;
        }
        
        public Builder serFace(String serFace) {
            data.setSerFace(serFace);
            return this;
        }
        
        public Builder serHot(String serHot) {
            data.setSerHot(serHot);
            return this;
        }
        
        public Builder serRmkc(String serRmkc) {
            data.setSerRmkc(serRmkc);
            return this;
        }
        
        public Builder serSort(String serSort) {
            data.setSerSort(serSort);
            return this;
        }
        
        public Builder serStarC(String serStarC) {
            data.setSerStarC(serStarC);
            return this;
        }
        
        public Builder serStatus(String serStatus) {
            data.setSerStatus(serStatus);
            return this;
        }
        
        public Builder serTitle(String serTitle) {
            data.setSerTitle(serTitle);
            return this;
        }
        
        public Builder serUTime(String serUTime) {
            data.setSerUTime(serUTime);
            return this;
        }
        
        public Builder serviceFace(String serviceFace) {
            data.setServiceFace(serviceFace);
            return this;
        }
        
        public Builder tag(List<String> tag) {
            data.setTag(tag);
            return this;
        }
        
        public Builder userAvatar(String userAvatar) {
            data.setUserAvatar(userAvatar);
            return this;
        }
        
        public Builder userGender(String userGender) {
            data.setUserGender(userGender);
            return this;
        }
        
        public Builder userId(String userId) {
            data.setUserId(userId);
            return this;
        }
        
        public Builder userName(String userName) {
            data.setUserName(userName);
            return this;
        }
        
        public Result build() {
            return data;
        }
        
    }
    
}
