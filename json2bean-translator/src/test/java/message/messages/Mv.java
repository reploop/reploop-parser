package message.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import message.messages.mv.Items; 
import message.messages.mv.Code; 
import message.messages.mv.Order; 
import message.messages.mv.States; 
import message.messages.mv.UploadInfo; 
import message.messages.mv.HeadingCode; 
import message.messages.mv.LifeCycle; 
import message.messages.mv.PickInfo; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mv implements Serializable {
    private static final long serialVersionUID = 1L;
    private Code code;
    private HeadingCode headingCode;
    private Items items;
    private LifeCycle lifeCycle;
    private Order order;
    private PickInfo pickInfo;
    private States states;
    private UploadInfo uploadInfo;
    
    public Code getCode() {
        return code;
    }
    
    public void setCode(Code code) {
        this.code = code;
    }
    
    public HeadingCode getHeadingCode() {
        return headingCode;
    }
    
    public void setHeadingCode(HeadingCode headingCode) {
        this.headingCode = headingCode;
    }
    
    public Items getItems() {
        return items;
    }
    
    public void setItems(Items items) {
        this.items = items;
    }
    
    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }
    
    public void setLifeCycle(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public PickInfo getPickInfo() {
        return pickInfo;
    }
    
    public void setPickInfo(PickInfo pickInfo) {
        this.pickInfo = pickInfo;
    }
    
    public States getStates() {
        return states;
    }
    
    public void setStates(States states) {
        this.states = states;
    }
    
    public UploadInfo getUploadInfo() {
        return uploadInfo;
    }
    
    public void setUploadInfo(UploadInfo uploadInfo) {
        this.uploadInfo = uploadInfo;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("headingCode", headingCode)
                .add("items", items)
                .add("lifeCycle", lifeCycle)
                .add("order", order)
                .add("pickInfo", pickInfo)
                .add("states", states)
                .add("uploadInfo", uploadInfo)
                .toString();
    }
    
}
