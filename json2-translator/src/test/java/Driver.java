import driver.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;

	private Data data;

	@JsonProperty("errmsg")
	private String errMsg;

	@JsonProperty("errno")
	private Integer errNo;

	@JsonProperty("trace_id")
	private String traceId;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Integer getErrNo() {
		return errNo;
	}

	public void setErrNo(Integer errNo) {
		this.errNo = errNo;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("data", getData())
			.add("errMsg", getErrMsg())
			.add("errNo", getErrNo())
			.add("traceId", getTraceId())
			.toString();
	}

	public static Builder newDriverBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Driver data = new Driver();

		public Builder data(Data data) {
			this.data.setData(data);
			return this;
		}

		public Builder errMsg(String errMsg) {
			data.setErrMsg(errMsg);
			return this;
		}

		public Builder errNo(Integer errNo) {
			data.setErrNo(errNo);
			return this;
		}

		public Builder traceId(String traceId) {
			data.setTraceId(traceId);
			return this;
		}

		public Driver build() {
			return data;
		}

	}

}
