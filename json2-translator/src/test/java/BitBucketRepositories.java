import bitBucketRepositories.Values;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitBucketRepositories implements Serializable {
    private static final long serialVersionUID = 1L;
    private String next;
    private Integer page;
    @JsonProperty("pagelen")
    private Integer pageLen;
    private Integer size;
    private List<Values> values;
    
    public String getNext() {
        return next;
    }
    
    public void setNext(String next) {
        this.next = next;
    }
    
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getPageLen() {
        return pageLen;
    }
    
    public void setPageLen(Integer pageLen) {
        this.pageLen = pageLen;
    }
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    public List<Values> getValues() {
        return values;
    }
    
    public void setValues(List<Values> values) {
        this.values = values;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("next", getNext())
                .add("page", getPage())
                .add("pageLen", getPageLen())
                .add("size", getSize())
                .add("values", getValues())
                .toString();
    }
    
    public static Builder newBitBucketRepositoriesBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final BitBucketRepositories data = new BitBucketRepositories();
        
        public Builder next(String next) {
            data.setNext(next);
            return this;
        }
        
        public Builder page(Integer page) {
            data.setPage(page);
            return this;
        }
        
        public Builder pageLen(Integer pageLen) {
            data.setPageLen(pageLen);
            return this;
        }
        
        public Builder size(Integer size) {
            data.setSize(size);
            return this;
        }
        
        public Builder values(List<Values> values) {
            data.setValues(values);
            return this;
        }
        
        public BitBucketRepositories build() {
            return data;
        }
        
    }
    
}
