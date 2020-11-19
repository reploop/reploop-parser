import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.Log;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Har implements Serializable {
    private static final long serialVersionUID = 1L;
    private Log log;

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("log", log)
                .toString();
    }

}
