package message.messages.mv.order.m.states.l;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.states.l.m.Time; 
import message.messages.mv.order.m.states.l.m.Status; 
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
                .add("status", status)
                .add("time", time)
                .toString();
    }
    
}
