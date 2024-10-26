package bitBucketRepositories.values;

import bitBucketRepositories.values.links.Avatar;
import bitBucketRepositories.values.links.Forks;
import bitBucketRepositories.values.links.Watchers;
import bitBucketRepositories.values.links.Self;
import bitBucketRepositories.values.links.Source;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import bitBucketRepositories.values.links.Clone;
import bitBucketRepositories.values.links.PullRequests;
import bitBucketRepositories.values.links.Downloads;
import bitBucketRepositories.values.links.Commits;
import bitBucketRepositories.values.links.Hooks;
import bitBucketRepositories.values.links.Tags;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import bitBucketRepositories.values.links.Html;
import bitBucketRepositories.values.links.Branches;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links implements Serializable {

	private static final long serialVersionUID = 1L;

	private Avatar avatar;

	private Branches branches;

	private List<Clone> clone;

	private Commits commits;

	private Downloads downloads;

	private Forks forks;

	private Hooks hooks;

	private Html html;

	@JsonProperty("pullrequests")
	private PullRequests pullRequests;

	private Self self;

	private Source source;

	private Tags tags;

	private Watchers watchers;

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Branches getBranches() {
		return branches;
	}

	public void setBranches(Branches branches) {
		this.branches = branches;
	}

	public List<Clone> getClone() {
		return clone;
	}

	public void setClone(List<Clone> clone) {
		this.clone = clone;
	}

	public Commits getCommits() {
		return commits;
	}

	public void setCommits(Commits commits) {
		this.commits = commits;
	}

	public Downloads getDownloads() {
		return downloads;
	}

	public void setDownloads(Downloads downloads) {
		this.downloads = downloads;
	}

	public Forks getForks() {
		return forks;
	}

	public void setForks(Forks forks) {
		this.forks = forks;
	}

	public Hooks getHooks() {
		return hooks;
	}

	public void setHooks(Hooks hooks) {
		this.hooks = hooks;
	}

	public Html getHtml() {
		return html;
	}

	public void setHtml(Html html) {
		this.html = html;
	}

	public PullRequests getPullRequests() {
		return pullRequests;
	}

	public void setPullRequests(PullRequests pullRequests) {
		this.pullRequests = pullRequests;
	}

	public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	public Watchers getWatchers() {
		return watchers;
	}

	public void setWatchers(Watchers watchers) {
		this.watchers = watchers;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("avatar", getAvatar())
			.add("branches", getBranches())
			.add("clone", getClone())
			.add("commits", getCommits())
			.add("downloads", getDownloads())
			.add("forks", getForks())
			.add("hooks", getHooks())
			.add("html", getHtml())
			.add("pullRequests", getPullRequests())
			.add("self", getSelf())
			.add("source", getSource())
			.add("tags", getTags())
			.add("watchers", getWatchers())
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

		public Builder branches(Branches branches) {
			data.setBranches(branches);
			return this;
		}

		public Builder clone(List<Clone> clone) {
			data.setClone(clone);
			return this;
		}

		public Builder commits(Commits commits) {
			data.setCommits(commits);
			return this;
		}

		public Builder downloads(Downloads downloads) {
			data.setDownloads(downloads);
			return this;
		}

		public Builder forks(Forks forks) {
			data.setForks(forks);
			return this;
		}

		public Builder hooks(Hooks hooks) {
			data.setHooks(hooks);
			return this;
		}

		public Builder html(Html html) {
			data.setHtml(html);
			return this;
		}

		public Builder pullRequests(PullRequests pullRequests) {
			data.setPullRequests(pullRequests);
			return this;
		}

		public Builder self(Self self) {
			data.setSelf(self);
			return this;
		}

		public Builder source(Source source) {
			data.setSource(source);
			return this;
		}

		public Builder tags(Tags tags) {
			data.setTags(tags);
			return this;
		}

		public Builder watchers(Watchers watchers) {
			data.setWatchers(watchers);
			return this;
		}

		public Links build() {
			return data;
		}

	}

}
