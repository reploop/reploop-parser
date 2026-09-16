package bitBucketRepositories.values.links;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequests implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("href")
    private String hreF;

    public static Builder newPullRequestsBuilder() {
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
        private final PullRequests data = new PullRequests();

        public Builder hreF(String hreF) {
            data.setHreF(hreF);
            return this;
        }

        public PullRequests build() {
            return data;
        }

    }

}
