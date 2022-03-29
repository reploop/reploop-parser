package message.messages.mv.order.m.pickPoint;

import message.messages.mv.order.m.pickPoint.m.Airport;
import java.io.Serializable;
import message.messages.mv.order.m.pickPoint.m.Terminal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.pickPoint.m.Name;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.pickPoint.m.Airport airport;
    private message.messages.mv.order.m.pickPoint.m.Name name;
    private message.messages.mv.order.m.pickPoint.m.Terminal terminal;
    
    public message.messages.mv.order.m.pickPoint.m.Airport getAirport() {
        return airport;
    }
    
    public void setAirport(message.messages.mv.order.m.pickPoint.m.Airport airport) {
        this.airport = airport;
    }
    
    public message.messages.mv.order.m.pickPoint.m.Name getName() {
        return name;
    }
    
    public void setName(message.messages.mv.order.m.pickPoint.m.Name name) {
        this.name = name;
    }
    
    public message.messages.mv.order.m.pickPoint.m.Terminal getTerminal() {
        return terminal;
    }
    
    public void setTerminal(message.messages.mv.order.m.pickPoint.m.Terminal terminal) {
        this.terminal = terminal;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("airport", getAirport())
                .add("name", getName())
                .add("terminal", getTerminal())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder airport(message.messages.mv.order.m.pickPoint.m.Airport airport) {
            data.setAirport(airport);
            return this;
        }
        
        public Builder name(message.messages.mv.order.m.pickPoint.m.Name name) {
            data.setName(name);
            return this;
        }
        
        public Builder terminal(message.messages.mv.order.m.pickPoint.m.Terminal terminal) {
            data.setTerminal(terminal);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
