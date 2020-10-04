package vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Array implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("count_yesterday")
    private Integer countYesterday;
    @JsonProperty("tv_id")
    private Long tvId;
    @JsonProperty("tv_name")
    private String tvName;
    @JsonProperty("vv_week")
    private Integer vvWeek;
    
    public Integer getCountYesterday() {
        return countYesterday;
    }
    
    public void setCountYesterday(Integer countYesterday) {
        this.countYesterday = countYesterday;
    }
    
    public Long getTvId() {
        return tvId;
    }
    
    public void setTvId(Long tvId) {
        this.tvId = tvId;
    }
    
    public String getTvName() {
        return tvName;
    }
    
    public void setTvName(String tvName) {
        this.tvName = tvName;
    }
    
    public Integer getVvWeek() {
        return vvWeek;
    }
    
    public void setVvWeek(Integer vvWeek) {
        this.vvWeek = vvWeek;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("countYesterday", countYesterday)
                .add("tvId", tvId)
                .add("tvName", tvName)
                .add("vvWeek", vvWeek)
                .toString();
    }
    
}
