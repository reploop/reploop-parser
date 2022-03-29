package message.messages.mv.order.m.picker.m.identity;

import java.io.Serializable;
import message.messages.mv.order.m.picker.m.identity.m.No;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.picker.m.identity.m.Type;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.picker.m.identity.m.No no;
    private message.messages.mv.order.m.picker.m.identity.m.Type type;
    
    public message.messages.mv.order.m.picker.m.identity.m.No getNo() {
        return no;
    }
    
    public void setNo(message.messages.mv.order.m.picker.m.identity.m.No no) {
        this.no = no;
    }
    
    public message.messages.mv.order.m.picker.m.identity.m.Type getType() {
        return type;
    }
    
    public void setType(message.messages.mv.order.m.picker.m.identity.m.Type type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("no", getNo())
                .add("type", getType())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder no(message.messages.mv.order.m.picker.m.identity.m.No no) {
            data.setNo(no);
            return this;
        }
        
        public Builder type(message.messages.mv.order.m.picker.m.identity.m.Type type) {
            data.setType(type);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
