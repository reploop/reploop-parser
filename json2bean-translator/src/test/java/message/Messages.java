package message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.Map; 
import message.messages.Mv; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private Map<String, String> labels;
    private Mv mv;
    private String roomID;
    private String sender;
    private Integer sequenceNO;
    private String timestamp;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Map<String, String> getLabels() {
        return labels;
    }
    
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
    
    public Mv getMv() {
        return mv;
    }
    
    public void setMv(Mv mv) {
        this.mv = mv;
    }
    
    public String getRoomID() {
        return roomID;
    }
    
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
    
    public String getSender() {
        return sender;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public Integer getSequenceNO() {
        return sequenceNO;
    }
    
    public void setSequenceNO(Integer sequenceNO) {
        this.sequenceNO = sequenceNO;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("labels", labels)
                .add("mv", mv)
                .add("roomID", roomID)
                .add("sender", sender)
                .add("sequenceNO", sequenceNO)
                .add("timestamp", timestamp)
                .toString();
    }
    
    public static Builder newMessagesBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Messages data = new Messages();
        
        public Builder id(String id) {
            data.setId(id);
            return this;
        }
        
        public Builder labels(Map<String, String> labels) {
            data.setLabels(labels);
            return this;
        }
        
        public Builder mv(Mv mv) {
            data.setMv(mv);
            return this;
        }
        
        public Builder roomID(String roomID) {
            data.setRoomID(roomID);
            return this;
        }
        
        public Builder sender(String sender) {
            data.setSender(sender);
            return this;
        }
        
        public Builder sequenceNO(Integer sequenceNO) {
            data.setSequenceNO(sequenceNO);
            return this;
        }
        
        public Builder timestamp(String timestamp) {
            data.setTimestamp(timestamp);
            return this;
        }
        
        public Messages build() {
            return data;
        }
        
    }
    
}
