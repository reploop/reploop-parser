package message.messages.mv.order.m.items.m.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Qty implements Serializable {
    private static final long serialVersionUID = 1L;
    private String n;
    
    public String getN() {
        return n;
    }
    
    public void setN(String n) {
        this.n = n;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("n", n)
                .toString();
    }
    
    public static Builder newQtyBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Qty data = new Qty();
        
        public Builder n(String n) {
            data.setN(n);
            return this;
        }
        
        public Qty build() {
            return data;
        }
        
    }
    
}
