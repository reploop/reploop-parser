package department.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("open_department_id")
	private String openDepartmentId;

	public String getOpenDepartmentId() {
		return openDepartmentId;
	}

	public void setOpenDepartmentId(String openDepartmentId) {
		this.openDepartmentId = openDepartmentId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("openDepartmentId", getOpenDepartmentId()).toString();
	}

	public static Builder newItemsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Items data = new Items();

		public Builder openDepartmentId(String openDepartmentId) {
			data.setOpenDepartmentId(openDepartmentId);
			return this;
		}

		public Items build() {
			return data;
		}

	}

}
