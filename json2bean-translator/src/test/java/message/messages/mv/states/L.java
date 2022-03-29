package message.messages.mv.states;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.states.l.M;
@JsonIgnoreProperties(ignoreUnknown = true)
public class L implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.states.l.M m;
    
    public message.messages.mv.states.l.M getM() {
        return m;
    }
    
    public void setM(message.messages.mv.states.l.M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }
    
    public static Builder newLBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final L data = new L();
        
        public Builder m(message.messages.mv.states.l.M m) {
            data.setM(m);
            return this;
        }
        
        public L build() {
            return data;
        }
        
    }
    
}
