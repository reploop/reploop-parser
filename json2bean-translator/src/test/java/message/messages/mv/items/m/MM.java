package message.messages.mv.items.m;

import message.messages.mv.items.m.m.Name;
import message.messages.mv.items.m.m.Qty;
import java.io.Serializable;
import message.messages.mv.items.m.m.Code;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.items.m.m.TotalPrice;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MM implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.items.m.m.Code code;
    private message.messages.mv.items.m.m.Name name;
    private message.messages.mv.items.m.m.Qty qty;
    private message.messages.mv.items.m.m.TotalPrice totalPrice;
    
    public message.messages.mv.items.m.m.Code getCode() {
        return code;
    }
    
    public void setCode(message.messages.mv.items.m.m.Code code) {
        this.code = code;
    }
    
    public message.messages.mv.items.m.m.Name getName() {
        return name;
    }
    
    public void setName(message.messages.mv.items.m.m.Name name) {
        this.name = name;
    }
    
    public message.messages.mv.items.m.m.Qty getQty() {
        return qty;
    }
    
    public void setQty(message.messages.mv.items.m.m.Qty qty) {
        this.qty = qty;
    }
    
    public message.messages.mv.items.m.m.TotalPrice getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(message.messages.mv.items.m.m.TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("name", getName())
                .add("qty", getQty())
                .add("totalPrice", getTotalPrice())
                .toString();
    }
    
    public static Builder newMMBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final MM data = new MM();
        
        public Builder code(message.messages.mv.items.m.m.Code code) {
            data.setCode(code);
            return this;
        }
        
        public Builder name(message.messages.mv.items.m.m.Name name) {
            data.setName(name);
            return this;
        }
        
        public Builder qty(message.messages.mv.items.m.m.Qty qty) {
            data.setQty(qty);
            return this;
        }
        
        public Builder totalPrice(message.messages.mv.items.m.m.TotalPrice totalPrice) {
            data.setTotalPrice(totalPrice);
            return this;
        }
        
        public MM build() {
            return data;
        }
        
    }
    
}
