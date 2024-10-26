package res1.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import res1.data.list.Hotels;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListData implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("city_id")
	private String cityId;

	private List<Hotels> hotels;

	@JsonProperty("max_price")
	private Integer maxPrice;

	@JsonProperty("min_price")
	private Integer minPrice;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public List<Hotels> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotels> hotels) {
		this.hotels = hotels;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("cityId", getCityId())
			.add("hotels", getHotels())
			.add("maxPrice", getMaxPrice())
			.add("minPrice", getMinPrice())
			.toString();
	}

	public static Builder newListDataBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final ListData data = new ListData();

		public Builder cityId(String cityId) {
			data.setCityId(cityId);
			return this;
		}

		public Builder hotels(List<Hotels> hotels) {
			data.setHotels(hotels);
			return this;
		}

		public Builder maxPrice(Integer maxPrice) {
			data.setMaxPrice(maxPrice);
			return this;
		}

		public Builder minPrice(Integer minPrice) {
			data.setMinPrice(minPrice);
			return this;
		}

		public ListData build() {
			return data;
		}

	}

}
