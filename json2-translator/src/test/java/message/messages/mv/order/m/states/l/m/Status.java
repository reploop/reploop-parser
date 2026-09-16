package message.messages.mv.order.m.states.l.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    private String s;

    public static Builder newStatusBuilder() {
        return new Builder();
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("s", getS())
                .toString();
    }

    public static class Builder {
        private final Status data = new Status();

        public Builder s(String s) {
            data.setS(s);
            return this;
        }

        public Status build() {
            return data;
        }

    }

}
