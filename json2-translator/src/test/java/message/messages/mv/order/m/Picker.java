package message.messages.mv.order.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.order.m.picker.M;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Picker implements Serializable {
    private static final long serialVersionUID = 1L;
    private M m;

    public static Builder newPickerBuilder() {
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
        private final Picker data = new Picker();

        public Builder m(M m) {
            data.setM(m);
            return this;
        }

        public Picker build() {
            return data;
        }

    }

}
