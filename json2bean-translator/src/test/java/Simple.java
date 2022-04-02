import java.util.Map;
import simple.Area;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Simple implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Area> area;
    private Map<String, String> city;
    private Integer code;
    private String date;
    private String error;
    private String result;
    
    public Map<Integer, Area> getArea() {
        return area;
    }
    
    public void setArea(Map<Integer, Area> area) {
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
                .add("area", getArea())
                .add("city", getCity())
                .add("code", getCode())
                .add("date", getDate())
                .add("error", getError())
                .add("result", getResult())
                .toString();
    }
    
    public static Builder newSimpleBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Simple data = new Simple();
        
        public Builder area(Map<Integer, Area> area) {
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
        
        public Builder date(String date) {
            data.setDate(date);
            return this;
        }
        
        public Builder error(String error) {
            data.setError(error);
            return this;
        }
        
        public Builder result(String result) {
            data.setResult(result);
            return this;
        }
        
        public Simple build() {
            return data;
        }
        
    }
    
}
