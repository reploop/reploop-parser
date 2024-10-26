package message.messages.mv;

import java.util.Map;
import java.io.Serializable;
import message.messages.mv.items.M;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<Integer, M> m;

	public Map<Integer, M> getM() {
		return m;
	}

	public void setM(Map<Integer, M> m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("m", getM()).toString();
	}

	public static Builder newItemsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Items data = new Items();

		public Builder m(Map<Integer, M> m) {
			data.setM(m);
			return this;
		}

		public Items build() {
			return data;
		}

	}

}
