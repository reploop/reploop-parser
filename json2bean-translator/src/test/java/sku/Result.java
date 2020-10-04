package sku;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean addedFlag;
    private String createTime;
    private String goodsInfoId;
    private Boolean inStock;
    private Float marketPrice;
    private String sku;
    private Float unitValue;
    
    public Boolean getAddedFlag() {
        return addedFlag;
    }
    
    public void setAddedFlag(Boolean addedFlag) {
        this.addedFlag = addedFlag;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getGoodsInfoId() {
        return goodsInfoId;
    }
    
    public void setGoodsInfoId(String goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }
    
    public Boolean getInStock() {
        return inStock;
    }
    
    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
    
    public Float getMarketPrice() {
        return marketPrice;
    }
    
    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }
    
    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public Float getUnitValue() {
        return unitValue;
    }
    
    public void setUnitValue(Float unitValue) {
        this.unitValue = unitValue;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("addedFlag", addedFlag)
                .add("createTime", createTime)
                .add("goodsInfoId", goodsInfoId)
                .add("inStock", inStock)
                .add("marketPrice", marketPrice)
                .add("sku", sku)
                .add("unitValue", unitValue)
                .toString();
    }
    
}
