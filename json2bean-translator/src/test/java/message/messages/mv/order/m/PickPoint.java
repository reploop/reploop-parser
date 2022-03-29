package message.messages.mv.order.m;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.pickPoint.M;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.pickPoint.M m;
    
    public message.messages.mv.order.m.pickPoint.M getM() {
        return m;
    }
    
    public void setM(message.messages.mv.order.m.pickPoint.M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newPickPointBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final PickPoint data = new PickPoint();
        
        public Builder m(message.messages.mv.order.m.pickPoint.M m) {
            data.setM(m);
            return this;
        }
        
        public PickPoint build() {
            return data;
        }
        
    }
    
}
