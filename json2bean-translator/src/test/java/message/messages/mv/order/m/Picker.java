package message.messages.mv.order.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.picker.M; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Picker implements Serializable {
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
                .add("m", m)
                .toString();
    }
    
    public static Builder newPickerBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Picker data = new Picker();
        
        public Builder m(M m) {
            data.setM(m);
            return this;
        }
        
        public Picker build() {
            return data;
        }
        
    }
    
}
