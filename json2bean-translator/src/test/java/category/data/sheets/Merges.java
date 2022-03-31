package category.data.sheets;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Merges extends ColumnCountRowCount implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer startColumnIndex;
    private Integer startRowIndex;
    
    public Integer getStartColumnIndex() {
        return startColumnIndex;
    }
    
    public void setStartColumnIndex(Integer startColumnIndex) {
        this.startColumnIndex = startColumnIndex;
    }
    
    public Integer getStartRowIndex() {
        return startRowIndex;
    }
    
    public void setStartRowIndex(Integer startRowIndex) {
        this.startRowIndex = startRowIndex;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("startColumnIndex", getStartColumnIndex())
                .add("startRowIndex", getStartRowIndex())
                .add("columnCount", getColumnCount())
                .add("rowCount", getRowCount())
                .toString();
    }
    
    public static Builder newMergesBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Merges data = new Merges();
        
        public Builder startColumnIndex(Integer startColumnIndex) {
            data.setStartColumnIndex(startColumnIndex);
            return this;
        }
        
        public Builder startRowIndex(Integer startRowIndex) {
            data.setStartRowIndex(startRowIndex);
            return this;
        }
        
        public Builder columnCount(Integer columnCount) {
            data.setColumnCount(columnCount);
            return this;
        }
        
        public Builder rowCount(Integer rowCount) {
            data.setRowCount(rowCount);
            return this;
        }
        
        public Merges build() {
            return data;
        }
        
    }
    
}
