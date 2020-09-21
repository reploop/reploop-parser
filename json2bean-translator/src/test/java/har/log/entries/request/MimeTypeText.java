package har.log.entries.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MimeTypeText implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mimeType;
    private String text;

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
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
            .add("mimeType", mimeType)
            .add("text", text)
            .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final MimeTypeText data = new MimeTypeText();

        public Builder mimeType(String mimeType) {
            data.setMimeType(mimeType);
            return this;
        }

        public Builder text(String text) {
            data.setText(text);
            return this;
        }

        public MimeTypeText build() {
            return data;
        }

    }

}
