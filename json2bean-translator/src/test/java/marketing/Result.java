package marketing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private String beginTime;
    private String createTime;
    private String endTime;
    private Integer marketingId;
    private String marketingName;
    private Integer marketingType;
    private Boolean pause;
    
    public String getBeginTime() {
        return beginTime;
    }
    
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public Integer getMarketingId() {
        return marketingId;
    }
    
    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }
    
    public String getMarketingName() {
        return marketingName;
    }
    
    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }
    
    public Integer getMarketingType() {
        return marketingType;
    }
    
    public void setMarketingType(Integer marketingType) {
        this.marketingType = marketingType;
    }
    
    public Boolean getPause() {
        return pause;
    }
    
    public void setPause(Boolean pause) {
        this.pause = pause;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("beginTime", beginTime)
                .add("createTime", createTime)
                .add("endTime", endTime)
                .add("marketingId", marketingId)
                .add("marketingName", marketingName)
                .add("marketingType", marketingType)
                .add("pause", pause)
                .toString();
    }
    
}
