package message.messages.mv.order.m.flight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.flight.m.DepartureTime; 
import message.messages.mv.order.m.flight.m.No; 
import message.messages.mv.order.m.flight.m.Terminal; 
import message.messages.mv.order.m.flight.m.Airport; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private Airport airport;
    private DepartureTime departureTime;
    private No no;
    private Terminal terminal;
    
    public Airport getAirport() {
        return airport;
    }
    
    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    
    public DepartureTime getDepartureTime() {
        return departureTime;
    }
    
    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }
    
    public No getNo() {
        return no;
    }
    
    public void setNo(No no) {
        this.no = no;
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
                .add("airport", airport)
                .add("departureTime", departureTime)
                .add("no", no)
                .add("terminal", terminal)
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
        
        public Builder departureTime(DepartureTime departureTime) {
            data.setDepartureTime(departureTime);
            return this;
        }
        
        public Builder no(No no) {
            data.setNo(no);
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
