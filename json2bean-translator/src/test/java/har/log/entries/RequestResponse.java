package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import har.log.entries.ValueName; 
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ValueName> headers;
    private Integer bodySize;
    private String httpVersion;
    private List<ValueName> cookies;
    private Integer headersSize;
    
    public List<ValueName> getHeaders() {
        return headers;
    }
    
    public void setHeaders(List<ValueName> headers) {
        this.headers = headers;
    }
    
    public Integer getBodySize() {
        return bodySize;
    }
    
    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
    }
    
    public String getHttpVersion() {
        return httpVersion;
    }
    
    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }
    
    public List<ValueName> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<ValueName> cookies) {
        this.cookies = cookies;
    }
    
    public Integer getHeadersSize() {
        return headersSize;
    }
    
    public void setHeadersSize(Integer headersSize) {
        this.headersSize = headersSize;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("headers", headers)
                .add("bodySize", bodySize)
                .add("httpVersion", httpVersion)
                .add("cookies", cookies)
                .add("headersSize", headersSize)
                .toString();
    }
    
}
