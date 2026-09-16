package message.messages.mv.order.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.pickPoint.M;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PickPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private M m;

    public static Builder newPickPointBuilder() {
        return new Builder();
    }

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

    public static class Builder {
        private final PickPoint data = new PickPoint();

        public Builder m(M m) {
            data.setM(m);
            return this;
        }

        public PickPoint build() {
            return data;
        }

    }

}
