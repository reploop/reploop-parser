package har.log.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import har.log.entries.response.Content;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response extends RequestResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Content content;
    @JsonProperty("redirectURL")
    private String redirectUrL;
    private Integer status;
    private String statusText;
    
    public Content getContent() {
        return content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }
    
    public String getRedirectUrL() {
        return redirectUrL;
    }
    
    public void setRedirectUrL(String redirectUrL) {
        this.redirectUrL = redirectUrL;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getStatusText() {
        return statusText;
    }
    
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("content", getContent())
                .add("redirectUrL", getRedirectUrL())
                .add("status", getStatus())
                .add("statusText", getStatusText())
                .add("cookies", getCookies())
                .add("headersSize", getHeadersSize())
                .add("httpVersion", getHttpVersion())
                .add("headers", getHeaders())
                .add("bodySize", getBodySize())
                .toString();
    }
    
    public static Builder newResponseBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Response data = new Response();
        
        public Builder content(Content content) {
            data.setContent(content);
            return this;
        }
        
        public Builder redirectUrL(String redirectUrL) {
            data.setRedirectUrL(redirectUrL);
            return this;
        }
        
        public Builder status(Integer status) {
            data.setStatus(status);
            return this;
        }
        
        public Builder statusText(String statusText) {
            data.setStatusText(statusText);
            return this;
        }
        
        public Builder cookies(List<NameValue> cookies) {
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
        
        public Builder headers(List<NameValue> headers) {
            data.setHeaders(headers);
            return this;
        }
        
        public Builder bodySize(Integer bodySize) {
            data.setBodySize(bodySize);
            return this;
        }
        
        public Response build() {
            return data;
        }
        
    }
    
}
