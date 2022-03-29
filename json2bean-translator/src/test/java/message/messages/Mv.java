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

        public Builder code(Code code) {
            data.setCode(code);
            return this;
        }

        public Builder headingCode(HeadingCode headingCode) {
            data.setHeadingCode(headingCode);
            return this;
        }

        public Builder items(Items items) {
            data.setItems(items);
            return this;
        }

        public Builder lifeCycle(LifeCycle lifeCycle) {
            data.setLifeCycle(lifeCycle);
            return this;
        }

        public Builder order(Order order) {
            data.setOrder(order);
            return this;
        }

        public Builder pickInfo(PickInfo pickInfo) {
            data.setPickInfo(pickInfo);
            return this;
        }

        public Builder states(States states) {
            data.setStates(states);
            return this;
        }

        public Builder uploadInfo(UploadInfo uploadInfo) {
            data.setUploadInfo(uploadInfo);
            return this;
        }

        public Mv build() {
            return data;
        }

    }

}
