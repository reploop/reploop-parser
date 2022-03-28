import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import jsonObject.Array; 
import java.util.List; 
import jsonObject.Data; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Array> array;
    private Data data;
    
    public List<Array> getArray() {
        return array;
    }
    
    public void setArray(List<Array> array) {
        this.array = array;
    }
    
    public Data getData() {
        return data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("array", array)
                .add("data", data)
                .toString();
    }
    
    public static Builder newJsonObjectBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final JsonObject data = new JsonObject();
        
        public Builder array(List<Array> array) {
            data.setArray(array);
            return this;
        }
        
        public Builder data(Data data) {
            this.data.setData(data);
            return this;
        }
        
        public JsonObject build() {
            return data;
        }
        
    }
    
}
