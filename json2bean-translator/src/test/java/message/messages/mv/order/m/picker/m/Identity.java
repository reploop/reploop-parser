package message.messages.mv.order.m.picker.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.order.m.picker.m.identity.M; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity implements Serializable {
    private static final long serialVersionUID = 1L;
    private M m;
    
    public M getM() {
        return m;
    }
    
    public void setM(M m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", m)
                .toString();
    }
    
}
