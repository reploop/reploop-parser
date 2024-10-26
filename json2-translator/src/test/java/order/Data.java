package order;

import java.io.Serializable;
import java.util.List;
import order.data.Records;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object countId;

	private Integer current;

	private Object entity;

	private Boolean hitCount;

	private Object maxLimit;

	private Boolean optimizeCountSql;

	private List<Object> orders;

	private Integer pages;

	private List<Records> records;

	private Boolean searchCount;

	private Integer size;

	private Integer total;

	public Object getCountId() {
		return countId;
	}

	public void setCountId(Object countId) {
		this.countId = countId;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public Boolean getHitCount() {
		return hitCount;
	}

	public void setHitCount(Boolean hitCount) {
		this.hitCount = hitCount;
	}

	public Object getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Object maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Boolean getOptimizeCountSql() {
		return optimizeCountSql;
	}

	public void setOptimizeCountSql(Boolean optimizeCountSql) {
		this.optimizeCountSql = optimizeCountSql;
	}

	public List<Object> getOrders() {
		return orders;
	}

	public void setOrders(List<Object> orders) {
		this.orders = orders;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	public Boolean getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Boolean searchCount) {
		this.searchCount = searchCount;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("countId", getCountId())
			.add("current", getCurrent())
			.add("entity", getEntity())
			.add("hitCount", getHitCount())
			.add("maxLimit", getMaxLimit())
			.add("optimizeCountSql", getOptimizeCountSql())
			.add("orders", getOrders())
			.add("pages", getPages())
			.add("records", getRecords())
			.add("searchCount", getSearchCount())
			.add("size", getSize())
			.add("total", getTotal())
			.toString();
	}

	public static Builder newDataBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Data data = new Data();

		public Builder countId(Object countId) {
			data.setCountId(countId);
			return this;
		}

		public Builder current(Integer current) {
			data.setCurrent(current);
			return this;
		}

		public Builder entity(Object entity) {
			data.setEntity(entity);
			return this;
		}

		public Builder hitCount(Boolean hitCount) {
			data.setHitCount(hitCount);
			return this;
		}

		public Builder maxLimit(Object maxLimit) {
			data.setMaxLimit(maxLimit);
			return this;
		}

		public Builder optimizeCountSql(Boolean optimizeCountSql) {
			data.setOptimizeCountSql(optimizeCountSql);
			return this;
		}

		public Builder orders(List<Object> orders) {
			data.setOrders(orders);
			return this;
		}

		public Builder pages(Integer pages) {
			data.setPages(pages);
			return this;
		}

		public Builder records(List<Records> records) {
			data.setRecords(records);
			return this;
		}

		public Builder searchCount(Boolean searchCount) {
			data.setSearchCount(searchCount);
			return this;
		}

		public Builder size(Integer size) {
			data.setSize(size);
			return this;
		}

		public Builder total(Integer total) {
			data.setTotal(total);
			return this;
		}

		public Data build() {
			return data;
		}

	}

}
