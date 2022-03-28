package message.messages.mv.order.m.picker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.picker.m.Phone; 
import message.messages.mv.order.m.picker.m.Identity; 
import message.messages.mv.order.m.picker.m.RealName; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private Identity identity;
    private Phone phone;
    private RealName realName;
    
    public Identity getIdentity() {
        return identity;
    }
    
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
    
    public Phone getPhone() {
        return phone;
    }
    
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    
    public RealName getRealName() {
        return realName;
    }
    
    public void setRealName(RealName realName) {
        this.realName = realName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("identity", identity)
                .add("phone", phone)
                .add("realName", realName)
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder identity(Identity identity) {
            data.setIdentity(identity);
            return this;
        }
        
        public Builder phone(Phone phone) {
            data.setPhone(phone);
            return this;
        }
        
        public Builder realName(RealName realName) {
            data.setRealName(realName);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
