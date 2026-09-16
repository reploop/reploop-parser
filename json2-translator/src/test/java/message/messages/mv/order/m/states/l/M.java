package message.messages.mv.order.m.states.l;

import message.messages.mv.order.m.states.l.m.Time;
import message.messages.mv.order.m.states.l.m.Status;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private Status status;
    private Time time;
    
    public Status getStatus() {
        return status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Time getTime() {
        return time;
    }
    
    public void setTime(Time time) {
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
        
        public Builder status(Status status) {
            data.setStatus(status);
            return this;
        }
        
        public Builder time(Time time) {
            data.setTime(time);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
