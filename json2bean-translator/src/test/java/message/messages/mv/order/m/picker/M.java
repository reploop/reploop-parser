package message.messages.mv.order.m.picker;

import message.messages.mv.order.m.picker.m.Phone;
import message.messages.mv.order.m.picker.m.Identity;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.picker.m.RealName;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.picker.m.Identity identity;
    private message.messages.mv.order.m.picker.m.Phone phone;
    private message.messages.mv.order.m.picker.m.RealName realName;
    
    public message.messages.mv.order.m.picker.m.Identity getIdentity() {
        return identity;
    }
    
    public void setIdentity(message.messages.mv.order.m.picker.m.Identity identity) {
        this.identity = identity;
    }
    
    public message.messages.mv.order.m.picker.m.Phone getPhone() {
        return phone;
    }
    
    public void setPhone(message.messages.mv.order.m.picker.m.Phone phone) {
        this.phone = phone;
    }
    
    public message.messages.mv.order.m.picker.m.RealName getRealName() {
        return realName;
    }
    
    public void setRealName(message.messages.mv.order.m.picker.m.RealName realName) {
        this.realName = realName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("identity", getIdentity())
                .add("phone", getPhone())
                .add("realName", getRealName())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder identity(message.messages.mv.order.m.picker.m.Identity identity) {
            data.setIdentity(identity);
            return this;
        }
        
        public Builder phone(message.messages.mv.order.m.picker.m.Phone phone) {
            data.setPhone(phone);
            return this;
        }
        
        public Builder realName(message.messages.mv.order.m.picker.m.RealName realName) {
            data.setRealName(realName);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
