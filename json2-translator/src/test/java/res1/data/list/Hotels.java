package res1.data.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import res1.data.list.hotels.AdditionalInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotels implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("additional_info")
	private AdditionalInfo additionalInfo;

	@JsonProperty("checkin")
	private String checkIn;

	private String checkout;

	@JsonProperty("coord")
	private String cOord;

	@JsonProperty("hotel_id")
	private String hotelId;

	private String name;

	@JsonProperty("name_en")
	private String nameEn;

	private Integer price;

	private Integer star;

	private List<String> tags;

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getCOord() {
		return cOord;
	}

	public void setCOord(String cOord) {
		this.cOord = cOord;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("additionalInfo", getAdditionalInfo())
			.add("checkIn", getCheckIn())
			.add("checkout", getCheckout())
			.add("cOord", getCOord())
			.add("hotelId", getHotelId())
			.add("name", getName())
			.add("nameEn", getNameEn())
			.add("price", getPrice())
			.add("star", getStar())
			.add("tags", getTags())
			.toString();
	}

	public static Builder newHotelsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Hotels data = new Hotels();

		public Builder additionalInfo(AdditionalInfo additionalInfo) {
			data.setAdditionalInfo(additionalInfo);
			return this;
		}

		public Builder checkIn(String checkIn) {
			data.setCheckIn(checkIn);
			return this;
		}

		public Builder checkout(String checkout) {
			data.setCheckout(checkout);
			return this;
		}

		public Builder cOord(String cOord) {
			data.setCOord(cOord);
			return this;
		}

		public Builder hotelId(String hotelId) {
			data.setHotelId(hotelId);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder nameEn(String nameEn) {
			data.setNameEn(nameEn);
			return this;
		}

		public Builder price(Integer price) {
			data.setPrice(price);
			return this;
		}

		public Builder star(Integer star) {
			data.setStar(star);
			return this;
		}

		public Builder tags(List<String> tags) {
			data.setTags(tags);
			return this;
		}

		public Hotels build() {
			return data;
		}

	}

}
