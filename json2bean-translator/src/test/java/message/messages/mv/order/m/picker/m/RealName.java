package message.messages.mv.order.m.picker.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RealName implements Serializable {
    private static final long serialVersionUID = 1L;
    private String s;
    
    public String getS() {
        return s;
    }
    
    public void setS(String s) {
        this.s = s;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("s", s)
                .toString();
    }
    
    public static Builder newRealNameBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final RealName data = new RealName();
        
        public Builder s(String s) {
            data.setS(s);
            return this;
        }
        
        public RealName build() {
            return data;
        }
        
    }
    
}
