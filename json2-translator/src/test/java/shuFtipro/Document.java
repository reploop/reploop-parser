package shuFtipro;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("additional_proof")
	private String additionalProof;

	private String age;

	@JsonProperty("allow_offline")
	private String allowOffline;

	@JsonProperty("allow_online")
	private String allowOnline;

	private String dob;

	@JsonProperty("document_number")
	private String documentNumber;

	@JsonProperty("expiry_date")
	private String expiryDate;

	private String gender;

	@JsonProperty("issue_date")
	private String issueDate;

	private String name;

	private String proof;

	@JsonProperty("supported_types")
	private List<String> supportedTypes;

	public String getAdditionalProof() {
		return additionalProof;
	}

	public void setAdditionalProof(String additionalProof) {
		this.additionalProof = additionalProof;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAllowOffline() {
		return allowOffline;
	}

	public void setAllowOffline(String allowOffline) {
		this.allowOffline = allowOffline;
	}

	public String getAllowOnline() {
		return allowOnline;
	}

	public void setAllowOnline(String allowOnline) {
		this.allowOnline = allowOnline;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
			.add("additionalProof", getAdditionalProof())
			.add("age", getAge())
			.add("allowOffline", getAllowOffline())
			.add("allowOnline", getAllowOnline())
			.add("dob", getDob())
			.add("documentNumber", getDocumentNumber())
			.add("expiryDate", getExpiryDate())
			.add("gender", getGender())
			.add("issueDate", getIssueDate())
			.add("name", getName())
			.add("proof", getProof())
			.add("supportedTypes", getSupportedTypes())
			.toString();
	}

	public static Builder newDocumentBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Document data = new Document();

		public Builder additionalProof(String additionalProof) {
			data.setAdditionalProof(additionalProof);
			return this;
		}

		public Builder age(String age) {
			data.setAge(age);
			return this;
		}

		public Builder allowOffline(String allowOffline) {
			data.setAllowOffline(allowOffline);
			return this;
		}

		public Builder allowOnline(String allowOnline) {
			data.setAllowOnline(allowOnline);
			return this;
		}

		public Builder dob(String dob) {
			data.setDob(dob);
			return this;
		}

		public Builder documentNumber(String documentNumber) {
			data.setDocumentNumber(documentNumber);
			return this;
		}

		public Builder expiryDate(String expiryDate) {
			data.setExpiryDate(expiryDate);
			return this;
		}

		public Builder gender(String gender) {
			data.setGender(gender);
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

		public Document build() {
			return data;
		}

	}

}
