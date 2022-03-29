package message.messages;

import message.messages.mv.Items;
import java.io.Serializable;
import message.messages.mv.Code;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import message.messages.mv.Order;
import message.messages.mv.States;
import message.messages.mv.UploadInfo;
import message.messages.mv.HeadingCode;
import message.messages.mv.LifeCycle;
import message.messages.mv.PickInfo;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mv implements Serializable {
    private static final long serialVersionUID = 1L;
    private message.messages.mv.Code code;
    private message.messages.mv.HeadingCode headingCode;
    private message.messages.mv.Items items;
    private message.messages.mv.LifeCycle lifeCycle;
    private message.messages.mv.Order order;
    private message.messages.mv.PickInfo pickInfo;
    private message.messages.mv.States states;
    private message.messages.mv.UploadInfo uploadInfo;
    
    public message.messages.mv.Code getCode() {
        return code;
    }
    
    public void setCode(message.messages.mv.Code code) {
        this.code = code;
    }
    
    public message.messages.mv.HeadingCode getHeadingCode() {
        return headingCode;
    }
    
    public void setHeadingCode(message.messages.mv.HeadingCode headingCode) {
        this.headingCode = headingCode;
    }
    
    public message.messages.mv.Items getItems() {
        return items;
    }
    
    public void setItems(message.messages.mv.Items items) {
        this.items = items;
    }
    
    public message.messages.mv.LifeCycle getLifeCycle() {
        return lifeCycle;
    }
    
    public void setLifeCycle(message.messages.mv.LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    
    public message.messages.mv.Order getOrder() {
        return order;
    }
    
    public void setOrder(message.messages.mv.Order order) {
        this.order = order;
    }
    
    public message.messages.mv.PickInfo getPickInfo() {
        return pickInfo;
    }
    
    public void setPickInfo(message.messages.mv.PickInfo pickInfo) {
        this.pickInfo = pickInfo;
    }
    
    public message.messages.mv.States getStates() {
        return states;
    }
    
    public void setStates(message.messages.mv.States states) {
        this.states = states;
    }
    
    public message.messages.mv.UploadInfo getUploadInfo() {
        return uploadInfo;
    }
    
    public void setUploadInfo(message.messages.mv.UploadInfo uploadInfo) {
        this.uploadInfo = uploadInfo;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("headingCode", getHeadingCode())
                .add("items", getItems())
                .add("lifeCycle", getLifeCycle())
                .add("order", getOrder())
                .add("pickInfo", getPickInfo())
                .add("states", getStates())
                .add("uploadInfo", getUploadInfo())
                .toString();
    }
    
    public static Builder newMvBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Mv data = new Mv();
        
        public Builder code(message.messages.mv.Code code) {
            data.setCode(code);
            return this;
        }
        
        public Builder headingCode(message.messages.mv.HeadingCode headingCode) {
            data.setHeadingCode(headingCode);
            return this;
        }
        
        public Builder items(message.messages.mv.Items items) {
            data.setItems(items);
            return this;
        }
        
        public Builder lifeCycle(message.messages.mv.LifeCycle lifeCycle) {
            data.setLifeCycle(lifeCycle);
            return this;
        }
        
        public Builder order(message.messages.mv.Order order) {
            data.setOrder(order);
            return this;
        }
        
        public Builder pickInfo(message.messages.mv.PickInfo pickInfo) {
            data.setPickInfo(pickInfo);
            return this;
        }
        
        public Builder states(message.messages.mv.States states) {
            data.setStates(states);
            return this;
        }
        
        public Builder uploadInfo(message.messages.mv.UploadInfo uploadInfo) {
            data.setUploadInfo(uploadInfo);
            return this;
        }
        
        public Mv build() {
            return data;
        }
        
    }
    
}
