package MessageVo.messages.mv.order.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.Map; 
import MessageVo.messages.mv.order.m.items.M; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Integer, M> m;
    
    public Map<Integer, M> getM() {
        return m;
    }
    
    public void setM(Map<Integer, M> m) {
        this.m = m;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", m)
                .toString();
    }
    
}
