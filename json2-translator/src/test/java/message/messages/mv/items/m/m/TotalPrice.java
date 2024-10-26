package message.messages.mv.items.m.m;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalPrice implements Serializable {

	private static final long serialVersionUID = 1L;

	private String n;

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("n", getN()).toString();
	}

	public static Builder newTotalPriceBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final TotalPrice data = new TotalPrice();

		public Builder n(String n) {
			data.setN(n);
			return this;
		}

		public TotalPrice build() {
			return data;
		}

	}

}
