package har.log.entries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cache implements Serializable {
    private static final long serialVersionUID = 1L;

    public static Builder newCacheBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }

    public static class Builder {
        private final Cache data = new Cache();

        public Cache build() {
            return data;
        }

    }

}
