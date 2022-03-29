package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bodySize;
    private Integer headersSize;
    private String httpVersion;
    private List<har.log.entries.NameValue> headers;
    private List<har.log.entries.NameValue> cookies;

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

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public List<har.log.entries.NameValue> getHeaders() {
        return headers;
    }

    public void setHeaders(List<har.log.entries.NameValue> headers) {
        this.headers = headers;
    }

    public List<har.log.entries.NameValue> getCookies() {
        return cookies;
    }

    public void setCookies(List<har.log.entries.NameValue> cookies) {
        this.cookies = cookies;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bodySize", getBodySize())
                .add("headersSize", getHeadersSize())
                .add("httpVersion", getHttpVersion())
                .add("headers", getHeaders())
                .add("cookies", getCookies())
                .toString();
    }

}
