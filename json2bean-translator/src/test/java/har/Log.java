package har;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import har.log.NameVersion; 
import har.log.Entries; 
import java.util.List; 
import har.log.Pages; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private NameVersion browser;
    private NameVersion creator;
    private List<Entries> entries;
    private List<Pages> pages;
    private String version;
    
    public NameVersion getBrowser() {
        return browser;
    }
    
    public void setBrowser(NameVersion browser) {
        this.browser = browser;
    }
    
    public NameVersion getCreator() {
        return creator;
    }
    
    public void setCreator(NameVersion creator) {
        this.creator = creator;
    }
    
    public List<Entries> getEntries() {
        return entries;
    }
    
    public void setEntries(List<Entries> entries) {
        this.entries = entries;
    }
    
    public List<Pages> getPages() {
        return pages;
    }
    
    public void setPages(List<Pages> pages) {
        this.pages = pages;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("browser", browser)
                .add("creator", creator)
                .add("entries", entries)
                .add("pages", pages)
                .add("version", version)
                .toString();
    }
    
}
