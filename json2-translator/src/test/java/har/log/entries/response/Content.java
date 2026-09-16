package har.log.entries.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.response.content.Text;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mimeType;
    private Integer size;
    private Text text;

    public static Builder newContentBuilder() {
        return new Builder();
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mimeType", getMimeType())
                .add("size", getSize())
                .add("text", getText())
                .toString();
    }

    public static class Builder {
        private final Content data = new Content();

        public Builder mimeType(String mimeType) {
            data.setMimeType(mimeType);
            return this;
        }

        public Builder size(Integer size) {
            data.setSize(size);
            return this;
        }

        public Builder text(Text text) {
            data.setText(text);
            return this;
        }

        public Content build() {
            return data;
        }

    }

}
