package bitBucketRepositories.values;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OverrideSettings implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("branching_model")
	private Boolean branchingModel;

	@JsonProperty("default_merge_strategy")
	private Boolean defaultMergeStrategy;

	public Boolean getBranchingModel() {
		return branchingModel;
	}

	public void setBranchingModel(Boolean branchingModel) {
		this.branchingModel = branchingModel;
	}

	public Boolean getDefaultMergeStrategy() {
		return defaultMergeStrategy;
	}

	public void setDefaultMergeStrategy(Boolean defaultMergeStrategy) {
		this.defaultMergeStrategy = defaultMergeStrategy;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("branchingModel", getBranchingModel())
			.add("defaultMergeStrategy", getDefaultMergeStrategy())
			.toString();
	}

	public static Builder newOverrideSettingsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final OverrideSettings data = new OverrideSettings();

		public Builder branchingModel(Boolean branchingModel) {
			data.setBranchingModel(branchingModel);
			return this;
		}

		public Builder defaultMergeStrategy(Boolean defaultMergeStrategy) {
			data.setDefaultMergeStrategy(defaultMergeStrategy);
			return this;
		}

		public OverrideSettings build() {
			return data;
		}

	}

}
