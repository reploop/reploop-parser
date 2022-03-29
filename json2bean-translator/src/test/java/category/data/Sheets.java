package category.data;

import java.io.Serializable;
import category.data.sheets.ColumnCountRowCount;
import java.util.List;
import category.data.sheets.Merges;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sheets extends ColumnCountRowCount implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer frozenColCount;
    private Integer frozenRowCount;
    private Integer index;
    private List<Merges> merges;
    private String sheetId;
    private String title;
    
    public Integer getFrozenColCount() {
        return frozenColCount;
    }
    
    public void setFrozenColCount(Integer frozenColCount) {
        this.frozenColCount = frozenColCount;
    }
    
    public Integer getFrozenRowCount() {
        return frozenRowCount;
    }
    
    public void setFrozenRowCount(Integer frozenRowCount) {
        this.frozenRowCount = frozenRowCount;
    }
    
    public Integer getIndex() {
        return index;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public List<Merges> getMerges() {
        return merges;
    }
    
    public void setMerges(List<Merges> merges) {
        this.merges = merges;
    }
    
    public String getSheetId() {
        return sheetId;
    }
    
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
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
                .add("frozenColCount", getFrozenColCount())
                .add("frozenRowCount", getFrozenRowCount())
                .add("index", getIndex())
                .add("merges", getMerges())
                .add("sheetId", getSheetId())
                .add("title", getTitle())
                .add("rowCount", getRowCount())
                .add("columnCount", getColumnCount())
                .toString();
    }
    
    public static Builder newSheetsBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Sheets data = new Sheets();
        
        public Builder frozenColCount(Integer frozenColCount) {
            data.setFrozenColCount(frozenColCount);
            return this;
        }
        
        public Builder frozenRowCount(Integer frozenRowCount) {
            data.setFrozenRowCount(frozenRowCount);
            return this;
        }
        
        public Builder index(Integer index) {
            data.setIndex(index);
            return this;
        }
        
        public Builder merges(List<Merges> merges) {
            data.setMerges(merges);
            return this;
        }
        
        public Builder sheetId(String sheetId) {
            data.setSheetId(sheetId);
            return this;
        }
        
        public Builder title(String title) {
            data.setTitle(title);
            return this;
        }
        
        public Builder rowCount(Integer rowCount) {
            data.setRowCount(rowCount);
            return this;
        }
        
        public Builder columnCount(Integer columnCount) {
            data.setColumnCount(columnCount);
            return this;
        }
        
        public Sheets build() {
            return data;
        }
        
    }
    
}
