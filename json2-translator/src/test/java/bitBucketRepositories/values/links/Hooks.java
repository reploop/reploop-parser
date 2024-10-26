package bitBucketRepositories.values.links;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hooks implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("href")
	private String hreF;

	public String getHreF() {
		return hreF;
	}

	public void setHreF(String hreF) {
		this.hreF = hreF;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("hreF", getHreF()).toString();
	}

	public static Builder newHooksBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Hooks data = new Hooks();

		public Builder hreF(String hreF) {
			data.setHreF(hreF);
			return this;
		}

		public Hooks build() {
			return data;
		}

	}

}
