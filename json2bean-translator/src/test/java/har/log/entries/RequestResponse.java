package har.log.entries;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

public abstract class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bodySize;
    private List<NameValue> headers;
    private String httpVersion;
    private List<har.log.entries.NameValue> cookies;
    private Integer headersSize;

    public Integer getBodySize() {
        return bodySize;
    }

    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
    }

    public List<har.log.entries.NameValue> getHeaders() {
        return headers;
    }

    public void setHeaders(List<har.log.entries.NameValue> headers) {
        this.headers = headers;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public List<har.log.entries.NameValue> getCookies() {
        return cookies;
    }

    public void setCookies(List<har.log.entries.NameValue> cookies) {
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
                .add("bodySize", bodySize)
                .add("headers", headers)
                .add("httpVersion", httpVersion)
                .add("cookies", cookies)
                .add("headersSize", headersSize)
                .toString();
    }

}
