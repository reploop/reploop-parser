package har.log.entries;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<NameValue> cookies;
    private List<NameValue> headers;
    private Integer headersSize;
    private String httpVersion;
    private Integer bodySize;
    
    public List<NameValue> getCookies() {
        return cookies;
    }
    
    public void setCookies(List<NameValue> cookies) {
        this.cookies = cookies;
    }
    
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
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cookies", getCookies())
                .add("headers", getHeaders())
                .add("headersSize", getHeadersSize())
                .add("httpVersion", getHttpVersion())
                .add("bodySize", getBodySize())
                .toString();
    }
    
}
