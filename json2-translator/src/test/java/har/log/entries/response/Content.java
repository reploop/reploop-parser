package har.log.entries.response;

import har.log.entries.MimeTypeText;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content extends MimeTypeText implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer size;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("size", getSize())
			.add("text", getText())
			.add("mimeType", getMimeType())
			.toString();
	}

	public static Builder newContentBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Content data = new Content();

		public Builder size(Integer size) {
			data.setSize(size);
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

		public Content build() {
			return data;
		}

	}

}
