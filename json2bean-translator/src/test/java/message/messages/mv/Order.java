package message.messages.mv;

import java.io.Serializable;
import message.messages.mv.order.M;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.M m;
    
    public message.messages.mv.order.M getM() {
        return m;
    }
    
    public void setM(message.messages.mv.order.M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newOrderBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Order data = new Order();
        
        public Builder m(message.messages.mv.order.M m) {
            data.setM(m);
            return this;
        }
        
        public Order build() {
            return data;
        }
        
    }
    
}
