package message.messages.mv.order.m.picker.m.identity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.picker.m.identity.m.No; 
import message.messages.mv.order.m.picker.m.identity.m.Type; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private No no;
    private Type type;
    
    public No getNo() {
        return no;
    }
    
    public void setNo(No no) {
        this.no = no;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("no", no)
                .add("type", type)
                .toString();
    }
    
}
