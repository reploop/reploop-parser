package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ValueName> cookies;
    private List<ValueName> headers;
    private String httpVersion;
    private Integer bodySize;
    private Integer headersSize;
    
    public List<ValueName> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<ValueName> cookies) {
        this.cookies = cookies;
    }
    
    public List<ValueName> getHeaders() {
        return headers;
    }
    
    public void setHeaders(List<ValueName> headers) {
        this.headers = headers;
    }
    
    public String getHttpVersion() {
        return httpVersion;
    }
    
    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }
    
    public Integer getBodySize() {
        return bodySize;
    }
    
    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
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
                .add("cookies", cookies)
                .add("headers", headers)
                .add("httpVersion", httpVersion)
                .add("bodySize", bodySize)
                .add("headersSize", headersSize)
                .toString();
    }
    
}
