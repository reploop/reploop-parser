package driver.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarData implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("annual_check_date")
    private String annualCheckDate;
    @JsonProperty("brand_desc")
    private String brandDesc;
    @JsonProperty("car_licence_front_url")
    private String carLicenceFrontUrl;
    private String color;
    @JsonProperty("fuel_id")
    private String fuelId;
    private Integer height;
    @JsonProperty("init_style_price")
    private Integer initStylePrice;
    @JsonProperty("ins_valid_date")
    private String insValidDate;
    private Integer length;
    private String model;
    private String owner;
    @JsonProperty("owner_address")
    private String ownerAddress;
    @JsonProperty("plate_no")
    private String plateNo;
    @JsonProperty("reg_date")
    private String regDate;
    @JsonProperty("seat_num")
    private Integer seatNum;
    private Integer wheelbases;
    private Integer width;
    
    public String getAnnualCheckDate() {
        return annualCheckDate;
    }
    
    public void setAnnualCheckDate(String annualCheckDate) {
        this.annualCheckDate = annualCheckDate;
    }
    
    public String getBrandDesc() {
        return brandDesc;
    }
    
    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }
    
    public String getCarLicenceFrontUrl() {
        return carLicenceFrontUrl;
    }
    
    public void setCarLicenceFrontUrl(String carLicenceFrontUrl) {
        this.carLicenceFrontUrl = carLicenceFrontUrl;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getFuelId() {
        return fuelId;
    }
    
    public void setFuelId(String fuelId) {
        this.fuelId = fuelId;
    }
    
    public Integer getHeight() {
        return height;
    }
    
    public void setHeight(Integer height) {
        this.height = height;
    }
    
    public Integer getInitStylePrice() {
        return initStylePrice;
    }
    
    public void setInitStylePrice(Integer initStylePrice) {
        this.initStylePrice = initStylePrice;
    }
    
    public String getInsValidDate() {
        return insValidDate;
    }
    
    public void setInsValidDate(String insValidDate) {
        this.insValidDate = insValidDate;
    }
    
    public Integer getLength() {
        return length;
    }
    
    public void setLength(Integer length) {
        this.length = length;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getOwnerAddress() {
        return ownerAddress;
    }
    
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
    
    public String getPlateNo() {
        return plateNo;
    }
    
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    
    public String getRegDate() {
        return regDate;
    }
    
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    
    public Integer getSeatNum() {
        return seatNum;
    }
    
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }
    
    public Integer getWheelbases() {
        return wheelbases;
    }
    
    public void setWheelbases(Integer wheelbases) {
        this.wheelbases = wheelbases;
    }
    
    public Integer getWidth() {
        return width;
    }
    
    public void setWidth(Integer width) {
        this.width = width;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("annualCheckDate", getAnnualCheckDate())
                .add("brandDesc", getBrandDesc())
                .add("carLicenceFrontUrl", getCarLicenceFrontUrl())
                .add("color", getColor())
                .add("fuelId", getFuelId())
                .add("height", getHeight())
                .add("initStylePrice", getInitStylePrice())
                .add("insValidDate", getInsValidDate())
                .add("length", getLength())
                .add("model", getModel())
                .add("owner", getOwner())
                .add("ownerAddress", getOwnerAddress())
                .add("plateNo", getPlateNo())
                .add("regDate", getRegDate())
                .add("seatNum", getSeatNum())
                .add("wheelbases", getWheelbases())
                .add("width", getWidth())
                .toString();
    }
    
    public static Builder newCarDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final CarData data = new CarData();
        
        public Builder annualCheckDate(String annualCheckDate) {
            data.setAnnualCheckDate(annualCheckDate);
            return this;
        }
        
        public Builder brandDesc(String brandDesc) {
            data.setBrandDesc(brandDesc);
            return this;
        }
        
        public Builder carLicenceFrontUrl(String carLicenceFrontUrl) {
            data.setCarLicenceFrontUrl(carLicenceFrontUrl);
            return this;
        }
        
        public Builder color(String color) {
            data.setColor(color);
            return this;
        }
        
        public Builder fuelId(String fuelId) {
            data.setFuelId(fuelId);
            return this;
        }
        
        public Builder height(Integer height) {
            data.setHeight(height);
            return this;
        }
        
        public Builder initStylePrice(Integer initStylePrice) {
            data.setInitStylePrice(initStylePrice);
            return this;
        }
        
        public Builder insValidDate(String insValidDate) {
            data.setInsValidDate(insValidDate);
            return this;
        }
        
        public Builder length(Integer length) {
            data.setLength(length);
            return this;
        }
        
        public Builder model(String model) {
            data.setModel(model);
            return this;
        }
        
        public Builder owner(String owner) {
            data.setOwner(owner);
            return this;
        }
        
        public Builder ownerAddress(String ownerAddress) {
            data.setOwnerAddress(ownerAddress);
            return this;
        }
        
        public Builder plateNo(String plateNo) {
            data.setPlateNo(plateNo);
            return this;
        }
        
        public Builder regDate(String regDate) {
            data.setRegDate(regDate);
            return this;
        }
        
        public Builder seatNum(Integer seatNum) {
            data.setSeatNum(seatNum);
            return this;
        }
        
        public Builder wheelbases(Integer wheelbases) {
            data.setWheelbases(wheelbases);
            return this;
        }
        
        public Builder width(Integer width) {
            data.setWidth(width);
            return this;
        }
        
        public CarData build() {
            return data;
        }
        
    }
    
}
