package category;

import category.data.Properties;
import category.data.Sheets;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	private Properties properties;

	private List<Sheets> sheets;

	private String spreadsheetToken;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Sheets> getSheets() {
		return sheets;
	}

	public void setSheets(List<Sheets> sheets) {
		this.sheets = sheets;
	}

	public String getSpreadsheetToken() {
		return spreadsheetToken;
	}

	public void setSpreadsheetToken(String spreadsheetToken) {
		this.spreadsheetToken = spreadsheetToken;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("properties", getProperties())
			.add("sheets", getSheets())
			.add("spreadsheetToken", getSpreadsheetToken())
			.toString();
	}

	public static Builder newDataBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Data data = new Data();

		public Builder properties(Properties properties) {
			data.setProperties(properties);
			return this;
		}

		public Builder sheets(List<Sheets> sheets) {
			data.setSheets(sheets);
			return this;
		}

		public Builder spreadsheetToken(String spreadsheetToken) {
			data.setSpreadsheetToken(spreadsheetToken);
			return this;
		}

		public Data build() {
			return data;
		}

	}

}
