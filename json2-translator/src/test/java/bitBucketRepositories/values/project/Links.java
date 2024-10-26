package bitBucketRepositories.values.project;

import bitBucketRepositories.values.project.links.Html;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import bitBucketRepositories.values.project.links.Avatar;
import bitBucketRepositories.values.project.links.Self;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links implements Serializable {

	private static final long serialVersionUID = 1L;

	private Avatar avatar;

	private Html html;

	private Self self;

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Html getHtml() {
		return html;
	}

	public void setHtml(Html html) {
		this.html = html;
	}

	public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("avatar", getAvatar())
			.add("html", getHtml())
			.add("self", getSelf())
			.toString();
	}

	public static Builder newLinksBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Links data = new Links();

		public Builder avatar(Avatar avatar) {
			data.setAvatar(avatar);
			return this;
		}

		public Builder html(Html html) {
			data.setHtml(html);
			return this;
		}

		public Builder self(Self self) {
			data.setSelf(self);
			return this;
		}

		public Links build() {
			return data;
		}

	}

}
