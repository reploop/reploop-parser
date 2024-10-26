package category.data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ownerUser;

	private Integer revision;

	private Integer sheetCount;

	private String title;

	public Long getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(Long ownerUser) {
		this.ownerUser = ownerUser;
	}

	public Integer getRevision() {
		return revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	public Integer getSheetCount() {
		return sheetCount;
	}

	public void setSheetCount(Integer sheetCount) {
		this.sheetCount = sheetCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("ownerUser", getOwnerUser())
			.add("revision", getRevision())
			.add("sheetCount", getSheetCount())
			.add("title", getTitle())
			.toString();
	}

	public static Builder newPropertiesBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Properties data = new Properties();

		public Builder ownerUser(Long ownerUser) {
			data.setOwnerUser(ownerUser);
			return this;
		}

		public Builder revision(Integer revision) {
			data.setRevision(revision);
			return this;
		}

		public Builder sheetCount(Integer sheetCount) {
			data.setSheetCount(sheetCount);
			return this;
		}

		public Builder title(String title) {
			data.setTitle(title);
			return this;
		}

		public Properties build() {
			return data;
		}

	}

}
