package category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import category.data.Properties; 
import category.data.Sheets; 
import java.util.List; 
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
                .add("properties", properties)
                .add("sheets", sheets)
                .add("spreadsheetToken", spreadsheetToken)
                .toString();
    }
    
}
