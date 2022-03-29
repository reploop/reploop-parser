package message.messages.mv.order.m;

import java.util.Map;
import message.messages.mv.order.m.items.M;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Integer, message.messages.mv.order.m.items.M> m;
    
    public Map<Integer, message.messages.mv.order.m.items.M> getM() {
        return m;
    }
    
    public void setM(Map<Integer, message.messages.mv.order.m.items.M> m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newItemsBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Items data = new Items();
        
        public Builder m(Map<Integer, message.messages.mv.order.m.items.M> m) {
            data.setM(m);
            return this;
        }
        
        public Items build() {
            return data;
        }
        
    }
    
}
