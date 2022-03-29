package message.messages.mv.states.l;

import message.messages.mv.states.l.m.Time;
import java.io.Serializable;
import message.messages.mv.states.l.m.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.states.l.m.Status status;
    private message.messages.mv.states.l.m.Time time;
    
    public message.messages.mv.states.l.m.Status getStatus() {
        return status;
    }
    
    public void setStatus(message.messages.mv.states.l.m.Status status) {
        this.status = status;
    }
    
    public message.messages.mv.states.l.m.Time getTime() {
        return time;
    }
    
    public void setTime(message.messages.mv.states.l.m.Time time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", getStatus())
                .add("time", getTime())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder status(message.messages.mv.states.l.m.Status status) {
            data.setStatus(status);
            return this;
        }
        
        public Builder time(message.messages.mv.states.l.m.Time time) {
            data.setTime(time);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
