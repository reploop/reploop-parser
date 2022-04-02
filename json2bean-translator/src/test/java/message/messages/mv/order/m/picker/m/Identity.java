package message.messages.mv.order.m.picker.m;

import message.messages.mv.order.m.picker.m.identity.M;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity implements Serializable {
    private static final long serialVersionUID = 1L;
    private M m;
    
    public M getM() {
        return m;
    }
    
    public void setM(M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newIdentityBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Identity data = new Identity();
        
        public Builder m(M m) {
            data.setM(m);
            return this;
        }
        
        public Identity build() {
            return data;
        }
        
    }
    
}
