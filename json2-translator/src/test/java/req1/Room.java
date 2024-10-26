package req1;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import req1.room.ListRoom;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ListRoom> list;

	public List<ListRoom> getList() {
		return list;
	}

	public void setList(List<ListRoom> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("list", getList()).toString();
	}

	public static Builder newRoomBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Room data = new Room();

		public Builder list(List<ListRoom> list) {
			data.setList(list);
			return this;
		}

		public Room build() {
			return data;
		}

	}

}
