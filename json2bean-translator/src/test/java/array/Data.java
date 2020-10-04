package array;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("comment_rate")
    private Integer commentRate;
    @JsonProperty("count_history")
    private Integer countHistory;
    @JsonProperty("count_last_week")
    private Integer countLastWeek;
    @JsonProperty("count_yesterday")
    private Integer countYesterday;
    @JsonProperty("play_url")
    private String playUrl;
    @JsonProperty("rank_trend")
    private Integer rankTrend;
    @JsonProperty("tv_id")
    private Long tvId;
    @JsonProperty("tv_name")
    private String tvName;
    @JsonProperty("vv_week")
    private Integer vvWeek;
    
    public Integer getCommentRate() {
        return commentRate;
    }
    
    public void setCommentRate(Integer commentRate) {
        this.commentRate = commentRate;
    }
    
    public Integer getCountHistory() {
        return countHistory;
    }
    
    public void setCountHistory(Integer countHistory) {
        this.countHistory = countHistory;
    }
    
    public Integer getCountLastWeek() {
        return countLastWeek;
    }
    
    public void setCountLastWeek(Integer countLastWeek) {
        this.countLastWeek = countLastWeek;
    }
    
    public Integer getCountYesterday() {
        return countYesterday;
    }
    
    public void setCountYesterday(Integer countYesterday) {
        this.countYesterday = countYesterday;
    }
    
    public String getPlayUrl() {
        return playUrl;
    }
    
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }
    
    public Integer getRankTrend() {
        return rankTrend;
    }
    
    public void setRankTrend(Integer rankTrend) {
        this.rankTrend = rankTrend;
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
                .add("commentRate", commentRate)
                .add("countHistory", countHistory)
                .add("countLastWeek", countLastWeek)
                .add("countYesterday", countYesterday)
                .add("playUrl", playUrl)
                .add("rankTrend", rankTrend)
                .add("tvId", tvId)
                .add("tvName", tvName)
                .add("vvWeek", vvWeek)
                .toString();
    }
    
}
