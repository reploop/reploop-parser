package store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreList implements Serializable {
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
            .add("city", city)
            .add("company", company)
            .add("createTime", createTime)
            .add("desCri", desCri)
            .add("id", id)
            .add("imgUrl", imgUrl)
            .add("longitude", longitude)
            .add("name", name)
            .add("phoneNumber", phoneNumber)
            .add("sheng", sheng)
            .add("sort", sort)
            .add("summary", summary)
            .add("typeName", typeName)
            .toString();
    }

}
