package message.messages.mv.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.Code; 
import message.messages.mv.order.m.States; 
import message.messages.mv.order.m.Created; 
import message.messages.mv.order.m.PickPoint; 
import message.messages.mv.order.m.Items; 
import message.messages.mv.order.m.Flight; 
import message.messages.mv.order.m.Picker; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private Code code;
    private Created created;
    private Flight flight;
    private Items items;
    private PickPoint pickPoint;
    private Picker picker;
    private States states;
    
    public Code getCode() {
        return code;
    }
    
    public void setCode(Code code) {
        this.code = code;
    }
    
    public Created getCreated() {
        return created;
    }
    
    public void setCreated(Created created) {
        this.created = created;
    }
    
    public Flight getFlight() {
        return flight;
    }
    
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    public Items getItems() {
        return items;
    }
    
    public void setItems(Items items) {
        this.items = items;
    }
    
    public PickPoint getPickPoint() {
        return pickPoint;
    }
    
    public void setPickPoint(PickPoint pickPoint) {
        this.pickPoint = pickPoint;
    }
    
    public Picker getPicker() {
        return picker;
    }
    
    public void setPicker(Picker picker) {
        this.picker = picker;
    }
    
    public States getStates() {
        return states;
    }
    
    public void setStates(States states) {
        this.states = states;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("created", created)
                .add("flight", flight)
                .add("items", items)
                .add("pickPoint", pickPoint)
                .add("picker", picker)
                .add("states", states)
                .toString();
    }
    
}
