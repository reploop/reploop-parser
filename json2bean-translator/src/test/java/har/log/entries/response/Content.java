package har.log.entries.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("size", size)
                .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Content data = new Content();

        public Builder size(Integer size) {
            data.setSize(size);
            return this;
        }

        public Content build() {
            return data;
        }

    }

}
