import jsonObject.Array;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import jsonObject.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<jsonObject.Array> array;
    private jsonObject.Data data;
    
    public List<jsonObject.Array> getArray() {
        return array;
    }
    
    public void setArray(List<jsonObject.Array> array) {
        this.array = array;
    }
    
    public jsonObject.Data getData() {
        return data;
    }
    
    public void setData(jsonObject.Data data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("array", getArray())
                .add("data", getData())
                .toString();
    }
    
    public static Builder newJsonObjectBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final JsonObject data = new JsonObject();
        
        public Builder array(List<jsonObject.Array> array) {
            data.setArray(array);
            return this;
        }
        
        public Builder data(jsonObject.Data data) {
            this.data.setData(data);
            return this;
        }
        
        public JsonObject build() {
            return data;
        }
        
    }
    
}
