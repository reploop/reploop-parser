package har.log.entries;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameValue implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", getName()).add("value", getValue()).toString();
	}

	public static Builder newNameValueBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final NameValue data = new NameValue();

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder value(String value) {
			data.setValue(value);
			return this;
		}

		public NameValue build() {
			return data;
		}

	}

}
