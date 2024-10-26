import drivers.Rows;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drivers implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String msg;

	private List<Rows> rows;

	private Integer total;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Rows> getRows() {
		return rows;
	}

	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("code", getCode())
			.add("msg", getMsg())
			.add("rows", getRows())
			.add("total", getTotal())
			.toString();
	}

	public static Builder newDriversBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Drivers data = new Drivers();

		public Builder code(Integer code) {
			data.setCode(code);
			return this;
		}

		public Builder msg(String msg) {
			data.setMsg(msg);
			return this;
		}

		public Builder rows(List<Rows> rows) {
			data.setRows(rows);
			return this;
		}

		public Builder total(Integer total) {
			data.setTotal(total);
			return this;
		}

		public Drivers build() {
			return data;
		}

	}

}
