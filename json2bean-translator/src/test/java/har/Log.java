package har;

import har.log.NameVersion;
import java.io.Serializable;
import har.log.Entries;
import java.util.List;
import har.log.Pages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
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
                .add("browser", getBrowser())
                .add("creator", getCreator())
                .add("entries", getEntries())
                .add("pages", getPages())
                .add("version", getVersion())
                .toString();
    }
    
    public static Builder newLogBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Log data = new Log();
        
        public Builder browser(NameVersion browser) {
            data.setBrowser(browser);
            return this;
        }
        
        public Builder creator(NameVersion creator) {
            data.setCreator(creator);
            return this;
        }
        
        public Builder entries(List<Entries> entries) {
            data.setEntries(entries);
            return this;
        }
        
        public Builder pages(List<Pages> pages) {
            data.setPages(pages);
            return this;
        }
        
        public Builder version(String version) {
            data.setVersion(version);
            return this;
        }
        
        public Log build() {
            return data;
        }
        
    }
    
}
