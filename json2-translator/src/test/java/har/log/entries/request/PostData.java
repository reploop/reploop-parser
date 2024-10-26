package har.log.entries.request;

import har.log.entries.MimeTypeText;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.entries.NameValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostData extends MimeTypeText implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<NameValue> params;

	public List<NameValue> getParams() {
		return params;
	}

	public void setParams(List<NameValue> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("params", getParams())
			.add("text", getText())
			.add("mimeType", getMimeType())
			.toString();
	}

	public static Builder newPostDataBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final PostData data = new PostData();

		public Builder params(List<NameValue> params) {
			data.setParams(params);
			return this;
		}

		public Builder text(String text) {
			data.setText(text);
			return this;
		}

		public Builder mimeType(String mimeType) {
			data.setMimeType(mimeType);
			return this;
		}

		public PostData build() {
			return data;
		}

	}

}
