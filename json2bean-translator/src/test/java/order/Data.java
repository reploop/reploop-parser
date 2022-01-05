package order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import order.data.Records; 
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
                .add("countId", countId)
                .add("current", current)
                .add("entity", entity)
                .add("hitCount", hitCount)
                .add("maxLimit", maxLimit)
                .add("optimizeCountSql", optimizeCountSql)
                .add("orders", orders)
                .add("pages", pages)
                .add("records", records)
                .add("searchCount", searchCount)
                .add("size", size)
                .add("total", total)
                .toString();
    }
    
}
