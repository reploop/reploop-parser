import java.io.Serializable;
import java.util.List;
import body.CanShippedOrderParcelList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Body implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<body.CanShippedOrderParcelList> canShippedOrderParcelList;
    private Integer canShippedParcelNum;
    private Integer expiredParcelNum;
    private Integer notExpiredParcelNum;
    
    public List<body.CanShippedOrderParcelList> getCanShippedOrderParcelList() {
        return canShippedOrderParcelList;
    }
    
    public void setCanShippedOrderParcelList(List<body.CanShippedOrderParcelList> canShippedOrderParcelList) {
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
                .add("canShippedOrderParcelList", getCanShippedOrderParcelList())
                .add("canShippedParcelNum", getCanShippedParcelNum())
                .add("expiredParcelNum", getExpiredParcelNum())
                .add("notExpiredParcelNum", getNotExpiredParcelNum())
                .toString();
    }
    
    public static Builder newBodyBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Body data = new Body();
        
        public Builder canShippedOrderParcelList(List<body.CanShippedOrderParcelList> canShippedOrderParcelList) {
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
