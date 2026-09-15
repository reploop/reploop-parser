package message.messages.mv.order.m;

import message.messages.mv.order.m.flight.M;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight implements Serializable {
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
                .add("m", getM())
                .toString();
    }
    
    public static Builder newFlightBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Flight data = new Flight();
        
        public Builder m(M m) {
            data.setM(m);
            return this;
        }
        
        public Flight build() {
            return data;
        }
        
    }
    
}
