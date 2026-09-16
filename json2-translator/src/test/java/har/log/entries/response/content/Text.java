package har.log.entries.response.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.response.content.text.Area;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Text implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Area> area;
    private Map<String, String> city;
    private Integer code;
    private Integer count;
    private String date;
    private Integer distinctPeriod;
    private Boolean enable;
    private String error;
    private String message;
    private String result;
    private Float samplingRate;
    private Long serverTime;
    private Integer total;

    public static Builder newTextBuilder() {
        return new Builder();
    }

    public Map<String, Area> getArea() {
        return area;
    }

    public void setArea(Map<String, Area> area) {
        this.area = area;
    }

    public Map<String, String> getCity() {
        return city;
    }

    public void setCity(Map<String, String> city) {
        this.city = city;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDistinctPeriod() {
        return distinctPeriod;
    }

    public void setDistinctPeriod(Integer distinctPeriod) {
        this.distinctPeriod = distinctPeriod;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Float getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(Float samplingRate) {
        this.samplingRate = samplingRate;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("area", getArea())
                .add("city", getCity())
                .add("code", getCode())
                .add("count", getCount())
                .add("date", getDate())
                .add("distinctPeriod", getDistinctPeriod())
                .add("enable", getEnable())
                .add("error", getError())
                .add("message", getMessage())
                .add("result", getResult())
                .add("samplingRate", getSamplingRate())
                .add("serverTime", getServerTime())
                .add("total", getTotal())
                .toString();
    }

    public static class Builder {
        private final Text data = new Text();

        public Builder area(Map<String, Area> area) {
            data.setArea(area);
            return this;
        }

        public Builder city(Map<String, String> city) {
            data.setCity(city);
            return this;
        }

        public Builder code(Integer code) {
            data.setCode(code);
            return this;
        }

        public Builder count(Integer count) {
            data.setCount(count);
            return this;
        }

        public Builder date(String date) {
            data.setDate(date);
            return this;
        }

        public Builder distinctPeriod(Integer distinctPeriod) {
            data.setDistinctPeriod(distinctPeriod);
            return this;
        }

        public Builder enable(Boolean enable) {
            data.setEnable(enable);
            return this;
        }

        public Builder error(String error) {
            data.setError(error);
            return this;
        }

        public Builder message(String message) {
            data.setMessage(message);
            return this;
        }

        public Builder result(String result) {
            data.setResult(result);
            return this;
        }

        public Builder samplingRate(Float samplingRate) {
            data.setSamplingRate(samplingRate);
            return this;
        }

        public Builder serverTime(Long serverTime) {
            data.setServerTime(serverTime);
            return this;
        }

        public Builder total(Integer total) {
            data.setTotal(total);
            return this;
        }

        public Text build() {
            return data;
        }

    }

}
