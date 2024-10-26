package message.messages.mv.order.m;

import message.messages.mv.order.m.states.L;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class States implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<L> l;

	public List<L> getL() {
		return l;
	}

	public void setL(List<L> l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("l", getL()).toString();
	}

	public static Builder newStatesBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final States data = new States();

		public Builder l(List<L> l) {
			data.setL(l);
			return this;
		}

		public States build() {
			return data;
		}

	}

}
