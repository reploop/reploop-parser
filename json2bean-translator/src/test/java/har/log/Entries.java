package har.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.entries.Cache;
import har.log.entries.Request;
import har.log.entries.Response;
import har.log.entries.Timings;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("_securityState")
    private String securityState;
    private Cache cache;
    private String connection;
    @JsonProperty("pageref")
    private String pagerEf;
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
    
    public String getPagerEf() {
        return pagerEf;
    }
    
    public void setPagerEf(String pagerEf) {
        this.pagerEf = pagerEf;
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
                .add("pagerEf", pagerEf)
                .add("request", request)
                .add("response", response)
                .add("serverIpAddress", serverIpAddress)
                .add("startedDateTime", startedDateTime)
                .add("time", time)
                .add("timings", timings)
                .toString();
    }
    
    public static Builder newBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Entries data = new Entries();
        
        public Builder securityState(String securityState) {
            data.setSecurityState(securityState);
            return this;
        }
        
        public Builder cache(Cache cache) {
            data.setCache(cache);
            return this;
        }
        
        public Builder connection(String connection) {
            data.setConnection(connection);
            return this;
        }
        
        public Builder pagerEf(String pagerEf) {
            data.setPagerEf(pagerEf);
            return this;
        }
        
        public Builder request(Request request) {
            data.setRequest(request);
            return this;
        }
        
        public Builder response(Response response) {
            data.setResponse(response);
            return this;
        }
        
        public Builder serverIpAddress(String serverIpAddress) {
            data.setServerIpAddress(serverIpAddress);
            return this;
        }
        
        public Builder startedDateTime(String startedDateTime) {
            data.setStartedDateTime(startedDateTime);
            return this;
        }
        
        public Builder time(Integer time) {
            data.setTime(time);
            return this;
        }
        
        public Builder timings(Timings timings) {
            data.setTimings(timings);
            return this;
        }
        
        public Entries build() {
            return data;
        }
        
    }
    
}
