package category.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ownerUser;
    private Integer revision;
    private Integer sheetCount;
    private String title;
    
    public Long getOwnerUser() {
        return ownerUser;
    }
    
    public void setOwnerUser(Long ownerUser) {
        this.ownerUser = ownerUser;
    }
    
    public Integer getRevision() {
        return revision;
    }
    
    public void setRevision(Integer revision) {
        this.revision = revision;
    }
    
    public Integer getSheetCount() {
        return sheetCount;
    }
    
    public void setSheetCount(Integer sheetCount) {
        this.sheetCount = sheetCount;
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
                .add("ownerUser", ownerUser)
                .add("revision", revision)
                .add("sheetCount", sheetCount)
                .add("title", title)
                .toString();
    }
    
}
