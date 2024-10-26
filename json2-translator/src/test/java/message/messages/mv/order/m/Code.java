package message.messages.mv.order.m;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Code implements Serializable {

	private static final long serialVersionUID = 1L;

	private String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("s", getS()).toString();
	}

	public static Builder newCodeBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Code data = new Code();

		public Builder s(String s) {
			data.setS(s);
			return this;
		}

		public Code build() {
			return data;
		}

	}

}
