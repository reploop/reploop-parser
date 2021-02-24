package MessageVo.messages.mv.items.m.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    private String n;
    
    public String getN() {
        return n;
    }
    
    public void setN(String n) {
        this.n = n;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("n", n)
                .toString();
    }
    
}
