package message.messages.mv.order.m.pickPoint;

import message.messages.mv.order.m.pickPoint.m.Airport;
import message.messages.mv.order.m.pickPoint.m.Terminal;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.pickPoint.m.Name;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private Airport airport;
    private Name name;
    private Terminal terminal;
    
    public Airport getAirport() {
        return airport;
    }
    
    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public Terminal getTerminal() {
        return terminal;
    }
    
    public void setTerminal(Terminal terminal) {
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
        
        public Builder airport(Airport airport) {
            data.setAirport(airport);
            return this;
        }
        
        public Builder name(Name name) {
            data.setName(name);
            return this;
        }
        
        public Builder terminal(Terminal terminal) {
            data.setTerminal(terminal);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
