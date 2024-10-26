package jsonObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Array implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("count_yesterday")
	private Integer countYesterday;

	@JsonProperty("tv_id")
	private Long tvId;

	@JsonProperty("tv_name")
	private String tvName;

	@JsonProperty("vv_week")
	private Integer vvWeek;

	public Integer getCountYesterday() {
		return countYesterday;
	}

	public void setCountYesterday(Integer countYesterday) {
		this.countYesterday = countYesterday;
	}

	public Long getTvId() {
		return tvId;
	}

	public void setTvId(Long tvId) {
		this.tvId = tvId;
	}

	public String getTvName() {
		return tvName;
	}

	public void setTvName(String tvName) {
		this.tvName = tvName;
	}

	public Integer getVvWeek() {
		return vvWeek;
	}

	public void setVvWeek(Integer vvWeek) {
		this.vvWeek = vvWeek;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("countYesterday", getCountYesterday())
			.add("tvId", getTvId())
			.add("tvName", getTvName())
			.add("vvWeek", getVvWeek())
			.toString();
	}

	public static Builder newArrayBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Array data = new Array();

		public Builder countYesterday(Integer countYesterday) {
			data.setCountYesterday(countYesterday);
			return this;
		}

		public Builder tvId(Long tvId) {
			data.setTvId(tvId);
			return this;
		}

		public Builder tvName(String tvName) {
			data.setTvName(tvName);
			return this;
		}

		public Builder vvWeek(Integer vvWeek) {
			data.setVvWeek(vvWeek);
			return this;
		}

		public Array build() {
			return data;
		}

	}

}
