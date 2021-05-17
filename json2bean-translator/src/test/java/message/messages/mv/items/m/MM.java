package message.messages.mv.items.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.items.m.m.Name; 
import message.messages.mv.items.m.m.Qty; 
import message.messages.mv.items.m.m.Code; 
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
                .add("code", code)
                .add("name", name)
                .add("qty", qty)
                .add("totalPrice", totalPrice)
                .toString();
    }
    
}
