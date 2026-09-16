package message.messages.mv.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.items.m.MM;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class M implements Serializable {
    private static final long serialVersionUID = 1L;
    private MM m;

    public static Builder newMBuilder() {
        return new Builder();
    }

    public MM getM() {
        return m;
    }

    public void setM(MM m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("m", getM())
                .toString();
    }

    public static class Builder {
        private final M data = new M();

        public Builder m(MM m) {
            data.setM(m);
            return this;
        }

        public M build() {
            return data;
        }

    }

}
