package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.request.postData.Params;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bodySize;
    private List<Params> headers;
    private List<Params> cookies;
    private Integer headersSize;
    private String httpVersion;

    public Integer getBodySize() {
        return bodySize;
    }

    public void setBodySize(Integer bodySize) {
        this.bodySize = bodySize;
    }

    public List<Params> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Params> headers) {
        this.headers = headers;
    }

    public List<Params> getCookies() {
        return cookies;
    }

    public void setCookies(List<Params> cookies) {
        this.cookies = cookies;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("bodySize", bodySize)
            .add("headers", headers)
            .add("cookies", cookies)
            .add("headersSize", headersSize)
            .add("httpVersion", httpVersion)
            .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final RequestResponse data = new RequestResponse();

        public Builder bodySize(Integer bodySize) {
            data.setBodySize(bodySize);
            return this;
        }

        public Builder headers(List<Params> headers) {
            data.setHeaders(headers);
            return this;
        }

        public Builder cookies(List<Params> cookies) {
            data.setCookies(cookies);
            return this;
        }

        public Builder headersSize(Integer headersSize) {
            data.setHeadersSize(headersSize);
            return this;
        }

        public Builder httpVersion(String httpVersion) {
            data.setHttpVersion(httpVersion);
            return this;
        }

        public RequestResponse build() {
            return data;
        }

    }

}
