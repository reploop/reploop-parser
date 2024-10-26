package bitBucketRepositories;

import bitBucketRepositories.values.Workspace;
import bitBucketRepositories.values.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import bitBucketRepositories.values.Owner;
import java.io.Serializable;
import bitBucketRepositories.values.OverrideSettings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import bitBucketRepositories.values.Links;
import bitBucketRepositories.values.MainBranch;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Values implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("created_on")
	private String createdOn;

	private String description;

	@JsonProperty("fork_policy")
	private String forkPolicy;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("has_issues")
	private Boolean hasIssues;

	@JsonProperty("has_wiki")
	private Boolean hasWiki;

	@JsonProperty("is_private")
	private Boolean isPrivate;

	private String language;

	private Links links;

	@JsonProperty("mainbranch")
	private MainBranch mainBranch;

	private String name;

	@JsonProperty("override_settings")
	private OverrideSettings overrideSettings;

	private Owner owner;

	private Object parent;

	private Project project;

	private String scm;

	private Integer size;

	private String slug;

	private String type;

	@JsonProperty("updated_on")
	private String updatedOn;

	@JsonProperty("uuid")
	private String uUid;

	@JsonProperty("website")
	private Object webSite;

	private Workspace workspace;

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getForkPolicy() {
		return forkPolicy;
	}

	public void setForkPolicy(String forkPolicy) {
		this.forkPolicy = forkPolicy;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getHasIssues() {
		return hasIssues;
	}

	public void setHasIssues(Boolean hasIssues) {
		this.hasIssues = hasIssues;
	}

	public Boolean getHasWiki() {
		return hasWiki;
	}

	public void setHasWiki(Boolean hasWiki) {
		this.hasWiki = hasWiki;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public MainBranch getMainBranch() {
		return mainBranch;
	}

	public void setMainBranch(MainBranch mainBranch) {
		this.mainBranch = mainBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OverrideSettings getOverrideSettings() {
		return overrideSettings;
	}

	public void setOverrideSettings(OverrideSettings overrideSettings) {
		this.overrideSettings = overrideSettings;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getScm() {
		return scm;
	}

	public void setScm(String scm) {
		this.scm = scm;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUUid() {
		return uUid;
	}

	public void setUUid(String uUid) {
		this.uUid = uUid;
	}

	public Object getWebSite() {
		return webSite;
	}

	public void setWebSite(Object webSite) {
		this.webSite = webSite;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("createdOn", getCreatedOn())
			.add("description", getDescription())
			.add("forkPolicy", getForkPolicy())
			.add("fullName", getFullName())
			.add("hasIssues", getHasIssues())
			.add("hasWiki", getHasWiki())
			.add("isPrivate", getIsPrivate())
			.add("language", getLanguage())
			.add("links", getLinks())
			.add("mainBranch", getMainBranch())
			.add("name", getName())
			.add("overrideSettings", getOverrideSettings())
			.add("owner", getOwner())
			.add("parent", getParent())
			.add("project", getProject())
			.add("scm", getScm())
			.add("size", getSize())
			.add("slug", getSlug())
			.add("type", getType())
			.add("updatedOn", getUpdatedOn())
			.add("uUid", getUUid())
			.add("webSite", getWebSite())
			.add("workspace", getWorkspace())
			.toString();
	}

	public static Builder newValuesBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Values data = new Values();

		public Builder createdOn(String createdOn) {
			data.setCreatedOn(createdOn);
			return this;
		}

		public Builder description(String description) {
			data.setDescription(description);
			return this;
		}

		public Builder forkPolicy(String forkPolicy) {
			data.setForkPolicy(forkPolicy);
			return this;
		}

		public Builder fullName(String fullName) {
			data.setFullName(fullName);
			return this;
		}

		public Builder hasIssues(Boolean hasIssues) {
			data.setHasIssues(hasIssues);
			return this;
		}

		public Builder hasWiki(Boolean hasWiki) {
			data.setHasWiki(hasWiki);
			return this;
		}

		public Builder isPrivate(Boolean isPrivate) {
			data.setIsPrivate(isPrivate);
			return this;
		}

		public Builder language(String language) {
			data.setLanguage(language);
			return this;
		}

		public Builder links(Links links) {
			data.setLinks(links);
			return this;
		}

		public Builder mainBranch(MainBranch mainBranch) {
			data.setMainBranch(mainBranch);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder overrideSettings(OverrideSettings overrideSettings) {
			data.setOverrideSettings(overrideSettings);
			return this;
		}

		public Builder owner(Owner owner) {
			data.setOwner(owner);
			return this;
		}

		public Builder parent(Object parent) {
			data.setParent(parent);
			return this;
		}

		public Builder project(Project project) {
			data.setProject(project);
			return this;
		}

		public Builder scm(String scm) {
			data.setScm(scm);
			return this;
		}

		public Builder size(Integer size) {
			data.setSize(size);
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

		public Builder updatedOn(String updatedOn) {
			data.setUpdatedOn(updatedOn);
			return this;
		}

		public Builder uUid(String uUid) {
			data.setUUid(uUid);
			return this;
		}

		public Builder webSite(Object webSite) {
			data.setWebSite(webSite);
			return this;
		}

		public Builder workspace(Workspace workspace) {
			data.setWorkspace(workspace);
			return this;
		}

		public Values build() {
			return data;
		}

	}

}
