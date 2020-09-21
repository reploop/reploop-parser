package har.log.entries.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.request.postData.Params;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Params> params;

    public List<Params> getParams() {
        return params;
    }

    public void setParams(List<Params> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("params", params)
            .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final PostData data = new PostData();

        public Builder params(List<Params> params) {
            data.setParams(params);
            return this;
        }

        public PostData build() {
            return data;
        }

    }

}
