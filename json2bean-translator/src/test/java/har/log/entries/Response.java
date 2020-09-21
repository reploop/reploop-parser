package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import har.log.entries.response.Content;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private Content content;
    @JsonProperty("redirectURL")
    private String redirectUrl;
    private Integer status;
    private String statusText;
    
    public Content getContent() {
        return content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }
    
    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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
                .add("content", content)
                .add("redirectUrl", redirectUrl)
                .add("status", status)
                .add("statusText", statusText)
                .toString();
    }
    
    public static Builder newBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Response data = new Response();
        
        public Builder content(Content content) {
            data.setContent(content);
            return this;
        }
        
        public Builder redirectUrl(String redirectUrl) {
            data.setRedirectUrl(redirectUrl);
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
        
        public Response build() {
            return data;
        }
        
    }
    
}
