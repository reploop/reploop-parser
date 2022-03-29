package store;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
    private String company;
    private String createTime;
    @JsonProperty("descri")
    private String desCri;
    private Integer id;
    @JsonProperty("imgurl")
    private String imgUrl;
    private Object longitude;
    private String name;
    @JsonProperty("phonenumber")
    private String phoneNumber;
    private String sheng;
    private Integer sort;
    private String summary;
    private String typeName;
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getDesCri() {
        return desCri;
    }
    
    public void setDesCri(String desCri) {
        this.desCri = desCri;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getImgUrl() {
        return imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    public Object getLongitude() {
        return longitude;
    }
    
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getSheng() {
        return sheng;
    }
    
    public void setSheng(String sheng) {
        this.sheng = sheng;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("city", getCity())
                .add("company", getCompany())
                .add("createTime", getCreateTime())
                .add("desCri", getDesCri())
                .add("id", getId())
                .add("imgUrl", getImgUrl())
                .add("longitude", getLongitude())
                .add("name", getName())
                .add("phoneNumber", getPhoneNumber())
                .add("sheng", getSheng())
                .add("sort", getSort())
                .add("summary", getSummary())
                .add("typeName", getTypeName())
                .toString();
    }
    
    public static Builder newListStoreBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final ListStore data = new ListStore();
        
        public Builder city(String city) {
            data.setCity(city);
            return this;
        }
        
        public Builder company(String company) {
            data.setCompany(company);
            return this;
        }
        
        public Builder createTime(String createTime) {
            data.setCreateTime(createTime);
            return this;
        }
        
        public Builder desCri(String desCri) {
            data.setDesCri(desCri);
            return this;
        }
        
        public Builder id(Integer id) {
            data.setId(id);
            return this;
        }
        
        public Builder imgUrl(String imgUrl) {
            data.setImgUrl(imgUrl);
            return this;
        }
        
        public Builder longitude(Object longitude) {
            data.setLongitude(longitude);
            return this;
        }
        
        public Builder name(String name) {
            data.setName(name);
            return this;
        }
        
        public Builder phoneNumber(String phoneNumber) {
            data.setPhoneNumber(phoneNumber);
            return this;
        }
        
        public Builder sheng(String sheng) {
            data.setSheng(sheng);
            return this;
        }
        
        public Builder sort(Integer sort) {
            data.setSort(sort);
            return this;
        }
        
        public Builder summary(String summary) {
            data.setSummary(summary);
            return this;
        }
        
        public Builder typeName(String typeName) {
            data.setTypeName(typeName);
            return this;
        }
        
        public ListStore build() {
            return data;
        }
        
    }
    
}
