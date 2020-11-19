package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<NameValue> headers;
    private Integer headersSize;
    private Integer bodySize;
    private List<NameValue> cookies;
    private String httpVersion;
    
    public List<NameValue> getHeaders() {
        return headers;
    }
    
    public void setHeaders(List<NameValue> headers) {
        this.headers = headers;
    }
    
    public Integer getHeadersSize() {
        return headersSize;
    }
    
    public void setHeadersSize(Integer headersSize) {
        this.headersSize = headersSize;
    }
    
    public Integer getBodySize() {
        return bodySize;
    }
    
    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
    }
    
    public List<NameValue> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<NameValue> cookies) {
        this.cookies = cookies;
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
                .add("headers", headers)
                .add("headersSize", headersSize)
                .add("bodySize", bodySize)
                .add("cookies", cookies)
                .add("httpVersion", httpVersion)
                .toString();
    }
    
}
