package message.messages.mv.order.m.picker.m;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    private String s;

    public static Builder newPhoneBuilder() {
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
        private final Phone data = new Phone();

        public Builder s(String s) {
            data.setS(s);
            return this;
        }

        public Phone build() {
            return data;
        }

    }

}
