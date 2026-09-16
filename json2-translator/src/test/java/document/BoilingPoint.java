package document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoilingPoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private String units;
    private Double value;

    public static Builder newBoilingPointBuilder() {
        return new Builder();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("units", getUnits())
                .add("value", getValue())
                .toString();
    }

    public static class Builder {
        private final BoilingPoint data = new BoilingPoint();

        public Builder units(String units) {
            data.setUnits(units);
            return this;
        }

        public Builder value(Double value) {
            data.setValue(value);
            return this;
        }

        public BoilingPoint build() {
            return data;
        }

    }

}
