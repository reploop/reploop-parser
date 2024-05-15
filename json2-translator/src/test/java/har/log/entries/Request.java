package har.log.entries;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.request.PostData;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request extends RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String method;
    private PostData postData;
    private List<NameValue> queryString;
    private String url;
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public PostData getPostData() {
        return postData;
    }
    
    public void setPostData(PostData postData) {
        this.postData = postData;
    }
    
    public List<NameValue> getQueryString() {
        return queryString;
    }
    
    public void setQueryString(List<NameValue> queryString) {
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
                .add("method", getMethod())
                .add("postData", getPostData())
                .add("queryString", getQueryString())
                .add("url", getUrl())
                .add("cookies", getCookies())
                .add("httpVersion", getHttpVersion())
                .add("headers", getHeaders())
                .add("headersSize", getHeadersSize())
                .add("bodySize", getBodySize())
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
        
        public Builder postData(PostData postData) {
            data.setPostData(postData);
            return this;
        }
        
        public Builder queryString(List<NameValue> queryString) {
            data.setQueryString(queryString);
            return this;
        }
        
        public Builder url(String url) {
            data.setUrl(url);
            return this;
        }
        
        public Builder cookies(List<NameValue> cookies) {
            data.setCookies(cookies);
            return this;
        }
        
        public Builder httpVersion(String httpVersion) {
            data.setHttpVersion(httpVersion);
            return this;
        }
        
        public Builder headers(List<NameValue> headers) {
            data.setHeaders(headers);
            return this;
        }
        
        public Builder headersSize(Integer headersSize) {
            data.setHeadersSize(headersSize);
            return this;
        }
        
        public Builder bodySize(Integer bodySize) {
            data.setBodySize(bodySize);
            return this;
        }
        
        public Request build() {
            return data;
        }
        
    }
    
}
