package har.log.entries.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.NameValue;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mimeType;
    private List<NameValue> params;
    private String text;

    public static Builder newPostDataBuilder() {
        return new Builder();
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public List<NameValue> getParams() {
        return params;
    }

    public void setParams(List<NameValue> params) {
        this.params = params;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mimeType", getMimeType())
                .add("params", getParams())
                .add("text", getText())
                .toString();
    }

    public static class Builder {
        private final PostData data = new PostData();

        public Builder mimeType(String mimeType) {
            data.setMimeType(mimeType);
            return this;
        }

        public Builder params(List<NameValue> params) {
            data.setParams(params);
            return this;
        }

        public Builder text(String text) {
            data.setText(text);
            return this;
        }

        public PostData build() {
            return data;
        }

    }

}
