package har.log.entries;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cache implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).toString();
	}

	public static Builder newCacheBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Cache data = new Cache();

		public Cache build() {
			return data;
		}

	}

}
