package MessageVo.messages.mv.order.m.pickPoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import MessageVo.messages.mv.order.m.pickPoint.m.Airport; 
import MessageVo.messages.mv.order.m.pickPoint.m.Terminal; 
import MessageVo.messages.mv.order.m.pickPoint.m.Name; 
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
                .add("airport", airport)
                .add("name", name)
                .add("terminal", terminal)
                .toString();
    }
    
}
