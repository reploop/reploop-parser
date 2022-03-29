package message.messages.mv.order.m.items;

import message.messages.mv.order.m.items.m.MM;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.items.m.MM m;
    
    public message.messages.mv.order.m.items.m.MM getM() {
        return m;
    }
    
    public void setM(message.messages.mv.order.m.items.m.MM m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder m(message.messages.mv.order.m.items.m.MM m) {
            data.setM(m);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
