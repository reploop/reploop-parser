package res1.data.list.hotels.additional_info.room;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListRoom implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("age", getAge()).toString();
	}

	public static Builder newListRoomBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final ListRoom data = new ListRoom();

		public Builder age(Integer age) {
			data.setAge(age);
			return this;
		}

		public ListRoom build() {
			return data;
		}

	}

}
