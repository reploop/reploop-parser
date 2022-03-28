package message.messages.mv.order.m.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.items.m.MM; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private MM m;
    
    public MM getM() {
        return m;
    }
    
    public void setM(MM m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", m)
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder m(MM m) {
            data.setM(m);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
