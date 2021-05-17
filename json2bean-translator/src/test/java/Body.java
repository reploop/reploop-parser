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
    
}
