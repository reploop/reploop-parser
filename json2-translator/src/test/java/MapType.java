import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String a;

	private Integer b;

	private String c;

	private Integer d;

	private String e;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("a", getA())
			.add("b", getB())
			.add("c", getC())
			.add("d", getD())
			.add("e", getE())
			.toString();
	}

	public static Builder newMapTypeBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final MapType data = new MapType();

		public Builder a(String a) {
			data.setA(a);
			return this;
		}

		public Builder b(Integer b) {
			data.setB(b);
			return this;
		}

		public Builder c(String c) {
			data.setC(c);
			return this;
		}

		public Builder d(Integer d) {
			data.setD(d);
			return this;
		}

		public Builder e(String e) {
			data.setE(e);
			return this;
		}

		public MapType build() {
			return data;
		}

	}

}
