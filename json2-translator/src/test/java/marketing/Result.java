package marketing;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private String beginTime;

	private String createTime;

	private String endTime;

	private Integer marketingId;

	private String marketingName;

	private Integer marketingType;

	private Boolean pause;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(Integer marketingId) {
		this.marketingId = marketingId;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public Integer getMarketingType() {
		return marketingType;
	}

	public void setMarketingType(Integer marketingType) {
		this.marketingType = marketingType;
	}

	public Boolean getPause() {
		return pause;
	}

	public void setPause(Boolean pause) {
		this.pause = pause;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("beginTime", getBeginTime())
			.add("createTime", getCreateTime())
			.add("endTime", getEndTime())
			.add("marketingId", getMarketingId())
			.add("marketingName", getMarketingName())
			.add("marketingType", getMarketingType())
			.add("pause", getPause())
			.toString();
	}

	public static Builder newResultBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Result data = new Result();

		public Builder beginTime(String beginTime) {
			data.setBeginTime(beginTime);
			return this;
		}

		public Builder createTime(String createTime) {
			data.setCreateTime(createTime);
			return this;
		}

		public Builder endTime(String endTime) {
			data.setEndTime(endTime);
			return this;
		}

		public Builder marketingId(Integer marketingId) {
			data.setMarketingId(marketingId);
			return this;
		}

		public Builder marketingName(String marketingName) {
			data.setMarketingName(marketingName);
			return this;
		}

		public Builder marketingType(Integer marketingType) {
			data.setMarketingType(marketingType);
			return this;
		}

		public Builder pause(Boolean pause) {
			data.setPause(pause);
			return this;
		}

		public Result build() {
			return data;
		}

	}

}
