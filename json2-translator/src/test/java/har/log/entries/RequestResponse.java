package har.log.entries;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<NameValue> headers;
    private String httpVersion;
    private Integer bodySize;
    private Integer headersSize;
    private List<NameValue> cookies;
    
    public List<NameValue> getHeaders() {
        return headers;
    }
    
    public void setHeaders(List<NameValue> headers) {
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
    
    public List<NameValue> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<NameValue> cookies) {
        this.cookies = cookies;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("headers", getHeaders())
                .add("httpVersion", getHttpVersion())
                .add("bodySize", getBodySize())
                .add("headersSize", getHeadersSize())
                .add("cookies", getCookies())
                .toString();
    }
    
}
