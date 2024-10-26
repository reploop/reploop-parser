package har.log;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameVersion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", getName()).add("version", getVersion()).toString();
	}

	public static Builder newNameVersionBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final NameVersion data = new NameVersion();

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder version(String version) {
			data.setVersion(version);
			return this;
		}

		public NameVersion build() {
			return data;
		}

	}

}
