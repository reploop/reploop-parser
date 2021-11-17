package department.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("open_department_id")
    private String openDepartmentId;
    
    public String getOpenDepartmentId() {
        return openDepartmentId;
    }
    
    public void setOpenDepartmentId(String openDepartmentId) {
        this.openDepartmentId = openDepartmentId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("openDepartmentId", openDepartmentId)
                .toString();
    }
    
}
