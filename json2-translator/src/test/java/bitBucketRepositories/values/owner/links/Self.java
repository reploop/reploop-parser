package bitBucketRepositories.values.owner.links;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Self implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("href")
    private String hreF;

    public static Builder newSelfBuilder() {
        return new Builder();
    }

    public String getHreF() {
        return hreF;
    }

    public void setHreF(String hreF) {
        this.hreF = hreF;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hreF", getHreF())
                .toString();
    }

    public static class Builder {
        private final Self data = new Self();

        public Builder hreF(String hreF) {
            data.setHreF(hreF);
            return this;
        }

        public Self build() {
            return data;
        }

    }

}
