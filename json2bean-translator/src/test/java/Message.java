import message.Messages;
import message.Result;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<message.Messages> messages;
    private message.Result result;
    
    public List<message.Messages> getMessages() {
        return messages;
    }
    
    public void setMessages(List<message.Messages> messages) {
        this.messages = messages;
    }
    
    public message.Result getResult() {
        return result;
    }
    
    public void setResult(message.Result result) {
        this.result = result;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("messages", getMessages())
                .add("result", getResult())
                .toString();
    }
    
    public static Builder newMessageBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Message data = new Message();
        
        public Builder messages(List<message.Messages> messages) {
            data.setMessages(messages);
            return this;
        }
        
        public Builder result(message.Result result) {
            data.setResult(result);
            return this;
        }
        
        public Message build() {
            return data;
        }
        
    }
    
}
