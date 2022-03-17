import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import driver.Data; 
import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    private Data data;
    @JsonProperty("errmsg")
    private String errMsg;
    @JsonProperty("errno")
    private Integer errNo;
    @JsonProperty("trace_id")
    private String traceId;
    
    public Data getData() {
        return data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }
    
    public String getErrMsg() {
        return errMsg;
    }
    
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    
    public Integer getErrNo() {
        return errNo;
    }
    
    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }
    
    public String getTraceId() {
        return traceId;
    }
    
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("data", data)
                .add("errMsg", errMsg)
                .add("errNo", errNo)
                .add("traceId", traceId)
                .toString();
    }
    
}
