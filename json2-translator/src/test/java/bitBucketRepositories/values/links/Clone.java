package bitBucketRepositories.values.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clone implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("href")
	private String hreF;

	private String name;

	public String getHreF() {
		return hreF;
	}

	public void setHreF(String hreF) {
		this.hreF = hreF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("hreF", getHreF()).add("name", getName()).toString();
	}

	public static Builder newCloneBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Clone data = new Clone();

		public Builder hreF(String hreF) {
			data.setHreF(hreF);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Clone build() {
			return data;
		}

	}

}
