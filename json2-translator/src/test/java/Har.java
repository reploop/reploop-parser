import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.Log;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Har implements Serializable {

	private static final long serialVersionUID = 1L;

	private Log log;

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("log", getLog()).toString();
	}

	public static Builder newHarBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Har data = new Har();

		public Builder log(Log log) {
			data.setLog(log);
			return this;
		}

		public Har build() {
			return data;
		}

	}

}
