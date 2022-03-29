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
    private message.messages.mv.order.m.Code code;
    private message.messages.mv.order.m.Created created;
    private message.messages.mv.order.m.Flight flight;
    private message.messages.mv.order.m.Items items;
    private message.messages.mv.order.m.PickPoint pickPoint;
    private message.messages.mv.order.m.Picker picker;
    private message.messages.mv.order.m.States states;
    
    public message.messages.mv.order.m.Code getCode() {
        return code;
    }
    
    public void setCode(message.messages.mv.order.m.Code code) {
        this.code = code;
    }
    
    public message.messages.mv.order.m.Created getCreated() {
        return created;
    }
    
    public void setCreated(message.messages.mv.order.m.Created created) {
        this.created = created;
    }
    
    public message.messages.mv.order.m.Flight getFlight() {
        return flight;
    }
    
    public void setFlight(message.messages.mv.order.m.Flight flight) {
        this.flight = flight;
    }
    
    public message.messages.mv.order.m.Items getItems() {
        return items;
    }
    
    public void setItems(message.messages.mv.order.m.Items items) {
        this.items = items;
    }
    
    public message.messages.mv.order.m.PickPoint getPickPoint() {
        return pickPoint;
    }
    
    public void setPickPoint(message.messages.mv.order.m.PickPoint pickPoint) {
        this.pickPoint = pickPoint;
    }
    
    public message.messages.mv.order.m.Picker getPicker() {
        return picker;
    }
    
    public void setPicker(message.messages.mv.order.m.Picker picker) {
        this.picker = picker;
    }
    
    public message.messages.mv.order.m.States getStates() {
        return states;
    }
    
    public void setStates(message.messages.mv.order.m.States states) {
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
        
        public Builder code(message.messages.mv.order.m.Code code) {
            data.setCode(code);
            return this;
        }
        
        public Builder created(message.messages.mv.order.m.Created created) {
            data.setCreated(created);
            return this;
        }
        
        public Builder flight(message.messages.mv.order.m.Flight flight) {
            data.setFlight(flight);
            return this;
        }
        
        public Builder items(message.messages.mv.order.m.Items items) {
            data.setItems(items);
            return this;
        }
        
        public Builder pickPoint(message.messages.mv.order.m.PickPoint pickPoint) {
            data.setPickPoint(pickPoint);
            return this;
        }
        
        public Builder picker(message.messages.mv.order.m.Picker picker) {
            data.setPicker(picker);
            return this;
        }
        
        public Builder states(message.messages.mv.order.m.States states) {
            data.setStates(states);
            return this;
        }
        
        public M build() {
            return data;
        }
        
    }
    
}
