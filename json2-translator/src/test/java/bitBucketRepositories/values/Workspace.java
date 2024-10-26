package bitBucketRepositories.values;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import bitBucketRepositories.values.workspace.Links;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace extends ProjectWorkspace implements Serializable {

	private static final long serialVersionUID = 1L;

	private Links links;

	private String slug;

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("links", getLinks())
			.add("slug", getSlug())
			.add("type", getType())
			.add("name", getName())
			.add("uUid", getUUid())
			.toString();
	}

	public static Builder newWorkspaceBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Workspace data = new Workspace();

		public Builder links(Links links) {
			data.setLinks(links);
			return this;
		}

		public Builder slug(String slug) {
			data.setSlug(slug);
			return this;
		}

		public Builder type(String type) {
			data.setType(type);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder uUid(String uUid) {
			data.setUUid(uUid);
			return this;
		}

		public Workspace build() {
			return data;
		}

	}

}
