package department;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import department.data.Items;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private List<Items> items;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<department.data.Items> getItems() {
        return items;
    }

    public void setItems(List<department.data.Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("hasMore", hasMore)
                .add("items", items)
                .toString();
    }

    public static Builder newDataBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Data data = new Data();

        public Builder hasMore(Boolean hasMore) {
            data.setHasMore(hasMore);
            return this;
        }

        public Builder items(List<department.data.Items> items) {
            data.setItems(items);
            return this;
        }

        public Data build() {
            return data;
        }

    }

}
