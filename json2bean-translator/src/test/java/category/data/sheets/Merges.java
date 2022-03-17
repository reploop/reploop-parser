package category.data.sheets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
                .add("startColumnIndex", startColumnIndex)
                .add("startRowIndex", startRowIndex)
                .toString();
    }
    
}
