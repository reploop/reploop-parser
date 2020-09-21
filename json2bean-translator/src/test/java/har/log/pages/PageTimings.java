package har.log.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PageTimings implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer onContentLoad;
    private Integer onLoad;

    public Integer getOnContentLoad() {
        return onContentLoad;
    }

    public void setOnContentLoad(Integer onContentLoad) {
        this.onContentLoad = onContentLoad;
    }

    public Integer getOnLoad() {
        return onLoad;
    }

    public void setOnLoad(Integer onLoad) {
        this.onLoad = onLoad;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("onContentLoad", onContentLoad)
                .add("onLoad", onLoad)
                .toString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final PageTimings data = new PageTimings();

        public Builder onContentLoad(Integer onContentLoad) {
            data.setOnContentLoad(onContentLoad);
            return this;
        }

        public Builder onLoad(Integer onLoad) {
            data.setOnLoad(onLoad);
            return this;
        }

        public PageTimings build() {
            return data;
        }

    }

}
