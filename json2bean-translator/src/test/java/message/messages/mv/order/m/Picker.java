package message.messages.mv.order.m;

import java.io.Serializable;
import message.messages.mv.order.m.picker.M;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Picker implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.picker.M m;
    
    public message.messages.mv.order.m.picker.M getM() {
        return m;
    }
    
    public void setM(message.messages.mv.order.m.picker.M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newPickerBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Picker data = new Picker();
        
        public Builder m(message.messages.mv.order.m.picker.M m) {
            data.setM(m);
            return this;
        }
        
        public Picker build() {
            return data;
        }
        
    }
    
}
