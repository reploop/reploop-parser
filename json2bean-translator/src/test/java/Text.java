import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import text.Area;

import java.io.Serializable;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Text implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Area> area;
    private Map<String, String> city;
    private Integer code;
    private String date;
    private String error;
    private String result;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("area", area)
                .add("city", city)
                .add("code", code)
                .add("date", date)
                .add("error", error)
                .add("result", result)
                .toString();
    }

}
