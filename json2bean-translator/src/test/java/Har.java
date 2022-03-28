import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

public class Har implements Serializable {
    private static final long serialVersionUID = 1L;
    private har.Log log;
    
    public har.Log getLog() {
        return log;
    }
    
    public void setLog(har.Log log) {
        this.log = log;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("log", log)
                .toString();
    }
    
    public static Builder newHarBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Har data = new Har();
        
        public Builder log(har.Log log) {
            data.setLog(log);
            return this;
        }
        
        public Har build() {
            return data;
        }
        
    }
    
}
