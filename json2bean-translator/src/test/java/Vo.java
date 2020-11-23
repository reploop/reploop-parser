import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import vo.Data; 
import java.util.List; 
import vo.Array; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vo implements Serializable {
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
    
}
