package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.request.PostData;
import har.log.entries.request.postData.Params;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private String method;
    private PostData postData;
    private List<Params> queryString;
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

    public List<Params> getQueryString() {
        return queryString;
    }

    public void setQueryString(List<Params> queryString) {
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

    public static Builder newBuilder() {
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

        public Builder queryString(List<Params> queryString) {
            data.setQueryString(queryString);
            return this;
        }

        public Builder url(String url) {
            data.setUrl(url);
            return this;
        }

        public Request build() {
            return data;
        }

    }

}
