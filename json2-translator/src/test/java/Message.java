import message.Messages;
import message.Result;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Messages> messages;

	private Result result;

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("messages", getMessages()).add("result", getResult()).toString();
	}

	public static Builder newMessageBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Message data = new Message();

		public Builder messages(List<Messages> messages) {
			data.setMessages(messages);
			return this;
		}

		public Builder result(Result result) {
			data.setResult(result);
			return this;
		}

		public Message build() {
			return data;
		}

	}

}
