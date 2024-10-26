package res1.data.list.hotels.additional_info;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import res1.data.list.hotels.additional_info.plan_prefer.Price;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanPrefer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Price price;

	private List<Integer> star;

	private List<String> tags;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<Integer> getStar() {
		return star;
	}

	public void setStar(List<Integer> star) {
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
			.add("price", getPrice())
			.add("star", getStar())
			.add("tags", getTags())
			.toString();
	}

	public static Builder newPlanPreferBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final PlanPrefer data = new PlanPrefer();

		public Builder price(Price price) {
			data.setPrice(price);
			return this;
		}

		public Builder star(List<Integer> star) {
			data.setStar(star);
			return this;
		}

		public Builder tags(List<String> tags) {
			data.setTags(tags);
			return this;
		}

		public PlanPrefer build() {
			return data;
		}

	}

}
