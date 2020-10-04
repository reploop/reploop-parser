package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.entries.RequestResponse; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import har.log.entries.response.Content; 
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
                .add("content", content)
                .add("redirectUrL", redirectUrL)
                .add("status", status)
                .add("statusText", statusText)
                .toString();
    }
    
}
