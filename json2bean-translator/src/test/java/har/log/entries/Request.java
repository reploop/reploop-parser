package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
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
                .add("method", method)
                .add("postData", postData)
                .add("queryString", queryString)
                .add("url", url)
                .toString();
    }
    
}
