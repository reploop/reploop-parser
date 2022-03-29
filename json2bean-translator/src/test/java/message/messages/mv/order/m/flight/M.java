package message.messages.mv.order.m.flight;

import message.messages.mv.order.m.flight.m.DepartureTime;
import message.messages.mv.order.m.flight.m.No;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.flight.m.Terminal;
import message.messages.mv.order.m.flight.m.Airport;
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.order.m.flight.m.Airport airport;
    private message.messages.mv.order.m.flight.m.DepartureTime departureTime;
    private message.messages.mv.order.m.flight.m.No no;
    private message.messages.mv.order.m.flight.m.Terminal terminal;
    
    public message.messages.mv.order.m.flight.m.Airport getAirport() {
        return airport;
    }
    
    public void setAirport(message.messages.mv.order.m.flight.m.Airport airport) {
        this.airport = airport;
    }
    
    public message.messages.mv.order.m.flight.m.DepartureTime getDepartureTime() {
        return departureTime;
    }
    
    public void setDepartureTime(message.messages.mv.order.m.flight.m.DepartureTime departureTime) {
        this.departureTime = departureTime;
    }
    
    public message.messages.mv.order.m.flight.m.No getNo() {
        return no;
    }
    
    public void setNo(message.messages.mv.order.m.flight.m.No no) {
        this.no = no;
    }
    
    public message.messages.mv.order.m.flight.m.Terminal getTerminal() {
        return terminal;
    }
    
    public void setTerminal(message.messages.mv.order.m.flight.m.Terminal terminal) {
        this.terminal = terminal;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("airport", getAirport())
                .add("departureTime", getDepartureTime())
                .add("no", getNo())
                .add("terminal", getTerminal())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder airport(message.messages.mv.order.m.flight.m.Airport airport) {
            data.setAirport(airport);
            return this;
        }
        
        public Builder departureTime(message.messages.mv.order.m.flight.m.DepartureTime departureTime) {
            data.setDepartureTime(departureTime);
            return this;
        }
        
        public Builder no(message.messages.mv.order.m.flight.m.No no) {
            data.setNo(no);
            return this;
        }
        
        public Builder terminal(message.messages.mv.order.m.flight.m.Terminal terminal) {
            data.setTerminal(terminal);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
