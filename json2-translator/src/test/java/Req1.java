import req1.CityList;
import com.fasterxml.jackson.annotation.JsonProperty;
import req1.Room;
import java.io.Serializable;
import req1.PlanPrefer;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Req1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("city_list")
	private List<CityList> cityList;

	@JsonProperty("plan_prefer")
	private PlanPrefer planPrefer;

	private List<Room> room;

	public List<CityList> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityList> cityList) {
		this.cityList = cityList;
	}

	public PlanPrefer getPlanPrefer() {
		return planPrefer;
	}

	public void setPlanPrefer(PlanPrefer planPrefer) {
		this.planPrefer = planPrefer;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("cityList", getCityList())
			.add("planPrefer", getPlanPrefer())
			.add("room", getRoom())
			.toString();
	}

	public static Builder newReq1Builder() {
		return new Builder();
	}

	public static class Builder {

		private final Req1 data = new Req1();

		public Builder cityList(List<CityList> cityList) {
			data.setCityList(cityList);
			return this;
		}

		public Builder planPrefer(PlanPrefer planPrefer) {
			data.setPlanPrefer(planPrefer);
			return this;
		}

		public Builder room(List<Room> room) {
			data.setRoom(room);
			return this;
		}

		public Req1 build() {
			return data;
		}

	}

}
