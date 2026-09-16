package department;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import department.data.Items;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private List<Items> items;

    public static Builder newDataBuilder() {
        return new Builder();
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hasMore", getHasMore())
                .add("items", getItems())
                .toString();
    }

    public static class Builder {
        private final Data data = new Data();

        public Builder hasMore(Boolean hasMore) {
            data.setHasMore(hasMore);
            return this;
        }

        public Builder items(List<Items> items) {
            data.setItems(items);
            return this;
        }

        public Data build() {
            return data;
        }

    }

}
