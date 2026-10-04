package jsonObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data extends Array implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("count_history")
    private Integer countHistory;
    @JsonProperty("count_last_week")
    private Integer countLastWeek;
    @JsonProperty("play_url")
    private String playUrl;
    @JsonProperty("rank_trend")
    private Integer rankTrend;
    
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
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("countHistory", getCountHistory())
                .add("countLastWeek", getCountLastWeek())
                .add("playUrl", getPlayUrl())
                .add("rankTrend", getRankTrend())
                .add("countYesterday", getCountYesterday())
                .add("tvId", getTvId())
                .add("tvName", getTvName())
                .add("vvWeek", getVvWeek())
                .toString();
    }
    
    public static Builder newDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Data data = new Data();
        
        public Builder countHistory(Integer countHistory) {
            data.setCountHistory(countHistory);
            return this;
        }
        
        public Builder countLastWeek(Integer countLastWeek) {
            data.setCountLastWeek(countLastWeek);
            return this;
        }
        
        public Builder playUrl(String playUrl) {
            data.setPlayUrl(playUrl);
            return this;
        }
        
        public Builder rankTrend(Integer rankTrend) {
            data.setRankTrend(rankTrend);
            return this;
        }
        
        public Builder countYesterday(Integer countYesterday) {
            data.setCountYesterday(countYesterday);
            return this;
        }
        
        public Builder tvId(Long tvId) {
            data.setTvId(tvId);
            return this;
        }
        
        public Builder tvName(String tvName) {
            data.setTvName(tvName);
            return this;
        }
        
        public Builder vvWeek(Integer vvWeek) {
            data.setVvWeek(vvWeek);
            return this;
        }
        
        public Data build() {
            return data;
        }
        
    }
    
}
