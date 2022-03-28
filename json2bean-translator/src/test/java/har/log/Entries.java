package har.log;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("_securityState")
    private String securityState;
    private har.log.entries.Cache cache;
    private String connection;
    @JsonProperty("pageref")
    private String pageRef;
    private har.log.entries.Request request;
    private har.log.entries.Response response;
    @JsonProperty("serverIPAddress")
    private String serverIpAddress;
    private String startedDateTime;
    private Integer time;
    private har.log.entries.Timings timings;

    public String getSecurityState() {
        return securityState;
    }

    public void setSecurityState(String securityState) {
        this.securityState = securityState;
    }

    public har.log.entries.Cache getCache() {
        return cache;
    }

    public void setCache(har.log.entries.Cache cache) {
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

    public har.log.entries.Request getRequest() {
        return request;
    }

    public void setRequest(har.log.entries.Request request) {
        this.request = request;
    }

    public har.log.entries.Response getResponse() {
        return response;
    }

    public void setResponse(har.log.entries.Response response) {
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

    public har.log.entries.Timings getTimings() {
        return timings;
    }

    public void setTimings(har.log.entries.Timings timings) {
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

    public static Builder newEntriesBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Entries data = new Entries();

        public Builder securityState(String securityState) {
            data.setSecurityState(securityState);
            return this;
        }

        public Builder cache(har.log.entries.Cache cache) {
            data.setCache(cache);
            return this;
        }

        public Builder connection(String connection) {
            data.setConnection(connection);
            return this;
        }

        public Builder pageRef(String pageRef) {
            data.setPageRef(pageRef);
            return this;
        }

        public Builder request(har.log.entries.Request request) {
            data.setRequest(request);
            return this;
        }

        public Builder response(har.log.entries.Response response) {
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

        public Builder timings(har.log.entries.Timings timings) {
            data.setTimings(timings);
            return this;
        }

        public Entries build() {
            return data;
        }

    }

}
