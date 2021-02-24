package har.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty; 
import har.log.entries.Request; 
import har.log.entries.Response; 
import har.log.entries.Timings; 
import har.log.entries.Cache; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("_securityState")
    private String securityState;
    private Cache cache;
    private String connection;
    @JsonProperty("pageref")
    private String pageRef;
    private Request request;
    private Response response;
    @JsonProperty("serverIPAddress")
    private String serverIpAddress;
    private String startedDateTime;
    private Integer time;
    private Timings timings;
    
    public String getSecurityState() {
        return securityState;
    }
    
    public void setSecurityState(String securityState) {
        this.securityState = securityState;
    }
    
    public Cache getCache() {
        return cache;
    }
    
    public void setCache(Cache cache) {
        this.cache = cache;
    }
    
    public String getConnection() {
        return connection;
    }
    
    public void setConnection(String connection) {
        this.connection = connection;
    }
    
    public String getPageRef() {
        return pageRef;
    }
    
    public void setPageRef(String pageRef) {
        this.pageRef = pageRef;
    }
    
    public Request getRequest() {
        return request;
    }
    
    public void setRequest(Request request) {
        this.request = request;
    }
    
    public Response getResponse() {
        return response;
    }
    
    public void setResponse(Response response) {
        this.response = response;
    }
    
    public String getServerIpAddress() {
        return serverIpAddress;
    }
    
    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }
    
    public String getStartedDateTime() {
        return startedDateTime;
    }
    
    public void setStartedDateTime(String startedDateTime) {
        this.startedDateTime = startedDateTime;
    }
    
    public Integer getTime() {
        return time;
    }
    
    public void setTime(Integer time) {
        this.time = time;
    }
    
    public Timings getTimings() {
        return timings;
    }
    
    public void setTimings(Timings timings) {
        this.timings = timings;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("securityState", securityState)
                .add("cache", cache)
                .add("connection", connection)
                .add("pageRef", pageRef)
                .add("request", request)
                .add("response", response)
                .add("serverIpAddress", serverIpAddress)
                .add("startedDateTime", startedDateTime)
                .add("time", time)
                .add("timings", timings)
                .toString();
    }
    
}
