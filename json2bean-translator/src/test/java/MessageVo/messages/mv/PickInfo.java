package MessageVo.messages.mv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }
    
}
