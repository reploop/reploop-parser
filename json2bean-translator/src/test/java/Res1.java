import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import res1.Error; 
import res1.Data; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Res1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private Data data;
    private Error error;
    
    public Data getData() {
        return data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    public Error getError() {
        return error;
    }
    
    public void setError(Error error) {
        this.error = error;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("data", data)
                .add("error", error)
                .toString();
    }
    
}
