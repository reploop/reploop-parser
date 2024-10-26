package detail;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float discount;

	private Float full;

	private String marketingDetailId;

	private Integer marketingId;

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getFull() {
		return full;
	}

	public void setFull(Float full) {
		this.full = full;
	}

	public String getMarketingDetailId() {
		return marketingDetailId;
	}

	public void setMarketingDetailId(String marketingDetailId) {
		this.marketingDetailId = marketingDetailId;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("discount", getDiscount())
			.add("full", getFull())
			.add("marketingDetailId", getMarketingDetailId())
			.add("marketingId", getMarketingId())
			.toString();
	}

	public static Builder newResultBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Result data = new Result();

		public Builder discount(Float discount) {
			data.setDiscount(discount);
			return this;
		}

		public Builder full(Float full) {
			data.setFull(full);
			return this;
		}

		public Builder marketingDetailId(String marketingDetailId) {
			data.setMarketingDetailId(marketingDetailId);
			return this;
		}

		public Builder marketingId(Integer marketingId) {
			data.setMarketingId(marketingId);
			return this;
		}

		public Result build() {
			return data;
		}

	}

}
