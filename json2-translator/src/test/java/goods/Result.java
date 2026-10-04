package goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean addedFlag;
    private Integer brandId;
    private Integer cateId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    private String goodsDetail;
    private String goodsImage;
    private String goodsName;
    private String goodsUnit;
    private Double linePrice;
    private String sku;
    
    public Boolean getAddedFlag() {
        return addedFlag;
    }
    
    public void setAddedFlag(Boolean addedFlag) {
        this.addedFlag = addedFlag;
    }
    
    public Integer getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
    
    public Integer getCateId() {
        return cateId;
    }
    
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public String getGoodsDetail() {
        return goodsDetail;
    }
    
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    
    public String getGoodsImage() {
        return goodsImage;
    }
    
    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }
    
    public String getGoodsName() {
        return goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    
    public String getGoodsUnit() {
        return goodsUnit;
    }
    
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }
    
    public Double getLinePrice() {
        return linePrice;
    }
    
    public void setLinePrice(Double linePrice) {
        this.linePrice = linePrice;
    }
    
    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("addedFlag", getAddedFlag())
                .add("brandId", getBrandId())
                .add("cateId", getCateId())
                .add("createTime", getCreateTime())
                .add("goodsDetail", getGoodsDetail())
                .add("goodsImage", getGoodsImage())
                .add("goodsName", getGoodsName())
                .add("goodsUnit", getGoodsUnit())
                .add("linePrice", getLinePrice())
                .add("sku", getSku())
                .toString();
    }
    
    public static Builder newResultBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Result data = new Result();
        
        public Builder addedFlag(Boolean addedFlag) {
            data.setAddedFlag(addedFlag);
            return this;
        }
        
        public Builder brandId(Integer brandId) {
            data.setBrandId(brandId);
            return this;
        }
        
        public Builder cateId(Integer cateId) {
            data.setCateId(cateId);
            return this;
        }
        
        public Builder createTime(LocalDateTime createTime) {
            data.setCreateTime(createTime);
            return this;
        }
        
        public Builder goodsDetail(String goodsDetail) {
            data.setGoodsDetail(goodsDetail);
            return this;
        }
        
        public Builder goodsImage(String goodsImage) {
            data.setGoodsImage(goodsImage);
            return this;
        }
        
        public Builder goodsName(String goodsName) {
            data.setGoodsName(goodsName);
            return this;
        }
        
        public Builder goodsUnit(String goodsUnit) {
            data.setGoodsUnit(goodsUnit);
            return this;
        }
        
        public Builder linePrice(Double linePrice) {
            data.setLinePrice(linePrice);
            return this;
        }
        
        public Builder sku(String sku) {
            data.setSku(sku);
            return this;
        }
        
        public Result build() {
            return data;
        }
        
    }
    
}
