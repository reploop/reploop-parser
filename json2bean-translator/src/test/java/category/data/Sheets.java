package category.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import category.data.sheets.ColumnCountRowCount; 
import java.util.List; 
import category.data.sheets.Merges; 
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
                .add("frozenColCount", frozenColCount)
                .add("frozenRowCount", frozenRowCount)
                .add("index", index)
                .add("merges", merges)
                .add("sheetId", sheetId)
                .add("title", title)
                .toString();
    }
    
}
