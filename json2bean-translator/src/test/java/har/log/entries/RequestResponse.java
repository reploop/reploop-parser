package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer headersSize;
    private List<ValueName> cookies;
    private Integer bodySize;
    private List<ValueName> headers;
    private String httpVersion;
    
    public Integer getHeadersSize() {
        return headersSize;
    }
    
    public void setHeadersSize(Integer headersSize) {
        this.headersSize = headersSize;
    }
    
    public List<ValueName> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<ValueName> cookies) {
        this.cookies = cookies;
    }
    
    public Integer getBodySize() {
        return bodySize;
    }
    
    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
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
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("headersSize", headersSize)
                .add("cookies", cookies)
                .add("bodySize", bodySize)
                .add("headers", headers)
                .add("httpVersion", httpVersion)
                .toString();
    }
    
}
