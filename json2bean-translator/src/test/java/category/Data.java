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
    private category.data.Properties properties;
    private List<category.data.Sheets> sheets;
    private String spreadsheetToken;
    
    public category.data.Properties getProperties() {
        return properties;
    }
    
    public void setProperties(category.data.Properties properties) {
        this.properties = properties;
    }
    
    public List<category.data.Sheets> getSheets() {
        return sheets;
    }
    
    public void setSheets(List<category.data.Sheets> sheets) {
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
        
        public Builder properties(category.data.Properties properties) {
            data.setProperties(properties);
            return this;
        }
        
        public Builder sheets(List<category.data.Sheets> sheets) {
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
