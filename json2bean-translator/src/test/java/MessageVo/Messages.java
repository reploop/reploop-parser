package MessageVo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import MessageVo.messages.Mv; 
import java.util.Map; 
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
    
}
