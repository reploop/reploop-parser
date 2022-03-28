import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import body.CanShippedOrderParcelList; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Body implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CanShippedOrderParcelList> canShippedOrderParcelList;
    private Integer canShippedParcelNum;
    private Integer expiredParcelNum;
    private Integer notExpiredParcelNum;
    
    public List<CanShippedOrderParcelList> getCanShippedOrderParcelList() {
        return canShippedOrderParcelList;
    }
    
    public void setCanShippedOrderParcelList(List<CanShippedOrderParcelList> canShippedOrderParcelList) {
        this.canShippedOrderParcelList = canShippedOrderParcelList;
    }
    
    public Integer getCanShippedParcelNum() {
        return canShippedParcelNum;
    }
    
    public void setCanShippedParcelNum(Integer canShippedParcelNum) {
        this.canShippedParcelNum = canShippedParcelNum;
    }
    
    public Integer getExpiredParcelNum() {
        return expiredParcelNum;
    }
    
    public void setExpiredParcelNum(Integer expiredParcelNum) {
        this.expiredParcelNum = expiredParcelNum;
    }
    
    public Integer getNotExpiredParcelNum() {
        return notExpiredParcelNum;
    }
    
    public void setNotExpiredParcelNum(Integer notExpiredParcelNum) {
        this.notExpiredParcelNum = notExpiredParcelNum;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("canShippedOrderParcelList", canShippedOrderParcelList)
                .add("canShippedParcelNum", canShippedParcelNum)
                .add("expiredParcelNum", expiredParcelNum)
                .add("notExpiredParcelNum", notExpiredParcelNum)
                .toString();
    }
    
    public static Builder newBodyBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Body data = new Body();
        
        public Builder canShippedOrderParcelList(List<CanShippedOrderParcelList> canShippedOrderParcelList) {
            data.setCanShippedOrderParcelList(canShippedOrderParcelList);
            return this;
        }
        
        public Builder canShippedParcelNum(Integer canShippedParcelNum) {
            data.setCanShippedParcelNum(canShippedParcelNum);
            return this;
        }
        
        public Builder expiredParcelNum(Integer expiredParcelNum) {
            data.setExpiredParcelNum(expiredParcelNum);
            return this;
        }
        
        public Builder notExpiredParcelNum(Integer notExpiredParcelNum) {
            data.setNotExpiredParcelNum(notExpiredParcelNum);
            return this;
        }
        
        public Body build() {
            return data;
        }
        
    }
    
}
