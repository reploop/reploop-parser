package har.log.entries;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

public class Request extends har.log.entries.RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String method;
    private har.log.entries.request.PostData postData;
    private List<NameValue> queryString;
    private String url;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public har.log.entries.request.PostData getPostData() {
        return postData;
    }

    public void setPostData(har.log.entries.request.PostData postData) {
        this.postData = postData;
    }

    public List<har.log.entries.NameValue> getQueryString() {
        return queryString;
    }

    public void setQueryString(List<har.log.entries.NameValue> queryString) {
        this.queryString = queryString;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("method", method)
                .add("postData", postData)
                .add("queryString", queryString)
                .add("url", url)
                .toString();
    }

    public static Builder newRequestBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Request data = new Request();

        public Builder method(String method) {
            data.setMethod(method);
            return this;
        }

        public Builder postData(har.log.entries.request.PostData postData) {
            data.setPostData(postData);
            return this;
        }

        public Builder queryString(List<har.log.entries.NameValue> queryString) {
            data.setQueryString(queryString);
            return this;
        }

        public Builder url(String url) {
            data.setUrl(url);
            return this;
        }

        public Builder bodySize(Integer bodySize) {
            data.setBodySize(bodySize);
            return this;
        }

        public Builder headers(List<har.log.entries.NameValue> headers) {
            data.setHeaders(headers);
            return this;
        }

        public Builder httpVersion(String httpVersion) {
            data.setHttpVersion(httpVersion);
            return this;
        }

        public Builder cookies(List<har.log.entries.NameValue> cookies) {
            data.setCookies(cookies);
            return this;
        }

        public Builder headersSize(Integer headersSize) {
            data.setHeadersSize(headersSize);
            return this;
        }

        public Request build() {
            return data;
        }

    }

}
