import res1.Error;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import res1.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Res1 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Data data;

	private Error error;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("data", getData()).add("error", getError()).toString();
	}

	public static Builder newRes1Builder() {
		return new Builder();
	}

	public static class Builder {

		private final Res1 data = new Res1();

		public Builder data(Data data) {
			this.data.setData(data);
			return this;
		}

		public Builder error(Error error) {
			data.setError(error);
			return this;
		}

		public Res1 build() {
			return data;
		}

	}

}
