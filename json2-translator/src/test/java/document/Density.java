package document;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Density implements Serializable {

	private static final long serialVersionUID = 1L;

	private String units;

	private Float value;

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("units", getUnits()).add("value", getValue()).toString();
	}

	public static Builder newDensityBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Density data = new Density();

		public Builder units(String units) {
			data.setUnits(units);
			return this;
		}

		public Builder value(Float value) {
			data.setValue(value);
			return this;
		}

		public Density build() {
			return data;
		}

	}

}
