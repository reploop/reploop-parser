package sku;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
			.add("addedFlag", getAddedFlag())
			.add("createTime", getCreateTime())
			.add("goodsInfoId", getGoodsInfoId())
			.add("inStock", getInStock())
			.add("marketPrice", getMarketPrice())
			.add("sku", getSku())
			.add("unitValue", getUnitValue())
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

		public Builder createTime(String createTime) {
			data.setCreateTime(createTime);
			return this;
		}

		public Builder goodsInfoId(String goodsInfoId) {
			data.setGoodsInfoId(goodsInfoId);
			return this;
		}

		public Builder inStock(Boolean inStock) {
			data.setInStock(inStock);
			return this;
		}

		public Builder marketPrice(Float marketPrice) {
			data.setMarketPrice(marketPrice);
			return this;
		}

		public Builder sku(String sku) {
			data.setSku(sku);
			return this;
		}

		public Builder unitValue(Float unitValue) {
			data.setUnitValue(unitValue);
			return this;
		}

		public Result build() {
			return data;
		}

	}

}
