package message.messages.mv.order;

import message.messages.mv.order.m.Code;
import message.messages.mv.order.m.States;
import java.io.Serializable;
import message.messages.mv.order.m.Created;
import message.messages.mv.order.m.PickPoint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
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
                .add("code", getCode())
                .add("created", getCreated())
                .add("flight", getFlight())
                .add("items", getItems())
                .add("pickPoint", getPickPoint())
                .add("picker", getPicker())
                .add("states", getStates())
                .toString();
    }
    
    public static Builder newMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final M data = new M();
        
        public Builder code(Code code) {
            data.setCode(code);
            return this;
        }
        
        public Builder created(Created created) {
            data.setCreated(created);
            return this;
        }
        
        public Builder flight(Flight flight) {
            data.setFlight(flight);
            return this;
        }
        
        public Builder items(Items items) {
            data.setItems(items);
            return this;
        }
        
        public Builder pickPoint(PickPoint pickPoint) {
            data.setPickPoint(pickPoint);
            return this;
        }
        
        public Builder picker(Picker picker) {
            data.setPicker(picker);
            return this;
        }
        
        public Builder states(States states) {
            data.setStates(states);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
