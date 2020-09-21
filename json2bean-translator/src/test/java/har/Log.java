package har;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import har.log.Creator;
import har.log.Entries;
import har.log.Pages;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private Creator browser;
    private Creator creator;
    private List<Entries> entries;
    private List<Pages> pages;
    private String version;

    public Creator getBrowser() {
        return browser;
    }

    public void setBrowser(Creator browser) {
        this.browser = browser;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
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

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Log data = new Log();

        public Builder browser(Creator browser) {
            data.setBrowser(browser);
            return this;
        }

        public Builder creator(Creator creator) {
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
