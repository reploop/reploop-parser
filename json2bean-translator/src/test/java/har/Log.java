package har;

import com.google.common.base.MoreObjects;
import har.log.Entries;

import java.io.Serializable;
import java.util.List;

public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    private har.log.NameVersion browser;
    private har.log.NameVersion creator;
    private List<Entries> entries;
    private List<har.log.Pages> pages;
    private String version;

    public har.log.NameVersion getBrowser() {
        return browser;
    }

    public void setBrowser(har.log.NameVersion browser) {
        this.browser = browser;
    }

    public har.log.NameVersion getCreator() {
        return creator;
    }

    public void setCreator(har.log.NameVersion creator) {
        this.creator = creator;
    }

    public List<har.log.Entries> getEntries() {
        return entries;
    }

    public void setEntries(List<har.log.Entries> entries) {
        this.entries = entries;
    }

    public List<har.log.Pages> getPages() {
        return pages;
    }

    public void setPages(List<har.log.Pages> pages) {
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

    public static Builder newLogBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final Log data = new Log();

        public Builder browser(har.log.NameVersion browser) {
            data.setBrowser(browser);
            return this;
        }

        public Builder creator(har.log.NameVersion creator) {
            data.setCreator(creator);
            return this;
        }

        public Builder entries(List<har.log.Entries> entries) {
            data.setEntries(entries);
            return this;
        }

        public Builder pages(List<har.log.Pages> pages) {
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
