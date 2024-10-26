package har.log.entries;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RequestResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String httpVersion;

	private Integer bodySize;

	private List<NameValue> headers;

	private List<NameValue> cookies;

	private Integer headersSize;

	public String getHttpVersion() {
		return httpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}

	public Integer getBodySize() {
		return bodySize;
	}

	public void setBodySize(Integer bodySize) {
		this.bodySize = bodySize;
	}

	public List<NameValue> getHeaders() {
		return headers;
	}

	public void setHeaders(List<NameValue> headers) {
		this.headers = headers;
	}

	public List<NameValue> getCookies() {
		return cookies;
	}

	public void setCookies(List<NameValue> cookies) {
		this.cookies = cookies;
	}

	public Integer getHeadersSize() {
		return headersSize;
	}

	public void setHeadersSize(Integer headersSize) {
		this.headersSize = headersSize;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("httpVersion", getHttpVersion())
			.add("bodySize", getBodySize())
			.add("headers", getHeaders())
			.add("cookies", getCookies())
			.add("headersSize", getHeadersSize())
			.toString();
	}

}
