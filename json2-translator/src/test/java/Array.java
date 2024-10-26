import array.Data;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Array implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;

	private List<Data> data;

	private List<Object> empty;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public List<Object> getEmpty() {
		return empty;
	}

	public void setEmpty(List<Object> empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("code", getCode())
			.add("data", getData())
			.add("empty", getEmpty())
			.toString();
	}

	public static Builder newArrayBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Array data = new Array();

		public Builder code(String code) {
			data.setCode(code);
			return this;
		}

		public Builder data(List<Data> data) {
			this.data.setData(data);
			return this;
		}

		public Builder empty(List<Object> empty) {
			data.setEmpty(empty);
			return this;
		}

		public Array build() {
			return data;
		}

	}

}
