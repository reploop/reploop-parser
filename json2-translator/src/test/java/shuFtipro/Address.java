package shuFtipro;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("address_fuzzy_match")
	private String addressFuzzyMatch;

	@JsonProperty("document_number")
	private String documentNumber;

	@JsonProperty("full_address")
	private String fullAddress;

	@JsonProperty("issue_date")
	private String issueDate;

	private String name;

	private String proof;

	@JsonProperty("supported_types")
	private List<String> supportedTypes;

	public String getAddressFuzzyMatch() {
		return addressFuzzyMatch;
	}

	public void setAddressFuzzyMatch(String addressFuzzyMatch) {
		this.addressFuzzyMatch = addressFuzzyMatch;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public List<String> getSupportedTypes() {
		return supportedTypes;
	}

	public void setSupportedTypes(List<String> supportedTypes) {
		this.supportedTypes = supportedTypes;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("addressFuzzyMatch", getAddressFuzzyMatch())
			.add("documentNumber", getDocumentNumber())
			.add("fullAddress", getFullAddress())
			.add("issueDate", getIssueDate())
			.add("name", getName())
			.add("proof", getProof())
			.add("supportedTypes", getSupportedTypes())
			.toString();
	}

	public static Builder newAddressBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Address data = new Address();

		public Builder addressFuzzyMatch(String addressFuzzyMatch) {
			data.setAddressFuzzyMatch(addressFuzzyMatch);
			return this;
		}

		public Builder documentNumber(String documentNumber) {
			data.setDocumentNumber(documentNumber);
			return this;
		}

		public Builder fullAddress(String fullAddress) {
			data.setFullAddress(fullAddress);
			return this;
		}

		public Builder issueDate(String issueDate) {
			data.setIssueDate(issueDate);
			return this;
		}

		public Builder name(String name) {
			data.setName(name);
			return this;
		}

		public Builder proof(String proof) {
			data.setProof(proof);
			return this;
		}

		public Builder supportedTypes(List<String> supportedTypes) {
			data.setSupportedTypes(supportedTypes);
			return this;
		}

		public Address build() {
			return data;
		}

	}

}
