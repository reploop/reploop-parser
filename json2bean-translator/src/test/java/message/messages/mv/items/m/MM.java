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
    private Code code;
    private Name name;
    private Qty qty;
    private TotalPrice totalPrice;
    
    public Code getCode() {
        return code;
    }
    
    public void setCode(Code code) {
        this.code = code;
    }
    
    public Name getName() {
        return name;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public Qty getQty() {
        return qty;
    }
    
    public void setQty(Qty qty) {
        this.qty = qty;
    }
    
    public TotalPrice getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(TotalPrice totalPrice) {
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
        
        public Builder code(Code code) {
            data.setCode(code);
            return this;
        }
        
        public Builder name(Name name) {
            data.setName(name);
            return this;
        }
        
        public Builder qty(Qty qty) {
            data.setQty(qty);
            return this;
        }
        
        public Builder totalPrice(TotalPrice totalPrice) {
            data.setTotalPrice(totalPrice);
            return this;
        }
        
        public MM build() {
            return data;
        }
        
    }
    
}
