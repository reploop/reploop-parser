package bitBucketRepositories.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import bitBucketRepositories.values.owner.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("display_name")
	private String displayName;

	private Links links;

	private String type;

	@JsonProperty("username")
	private String userName;

	@JsonProperty("uuid")
	private String uUid;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUUid() {
		return uUid;
	}

	public void setUUid(String uUid) {
		this.uUid = uUid;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("displayName", getDisplayName())
			.add("links", getLinks())
			.add("type", getType())
			.add("userName", getUserName())
			.add("uUid", getUUid())
			.toString();
	}

	public static Builder newOwnerBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Owner data = new Owner();

		public Builder displayName(String displayName) {
			data.setDisplayName(displayName);
			return this;
		}

		public Builder links(Links links) {
			data.setLinks(links);
			return this;
		}

		public Builder type(String type) {
			data.setType(type);
			return this;
		}

		public Builder userName(String userName) {
			data.setUserName(userName);
			return this;
		}

		public Builder uUid(String uUid) {
			data.setUUid(uUid);
			return this;
		}

		public Owner build() {
			return data;
		}

	}

}
