package har.log.entries;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Timings implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer blocked;

	private Integer connect;

	private Integer dns;

	private Integer receive;

	private Integer send;

	private Integer ssl;

	private Integer wait;

	public Integer getBlocked() {
		return blocked;
	}

	public void setBlocked(Integer blocked) {
		this.blocked = blocked;
	}

	public Integer getConnect() {
		return connect;
	}

	public void setConnect(Integer connect) {
		this.connect = connect;
	}

	public Integer getDns() {
		return dns;
	}

	public void setDns(Integer dns) {
		this.dns = dns;
	}

	public Integer getReceive() {
		return receive;
	}

	public void setReceive(Integer receive) {
		this.receive = receive;
	}

	public Integer getSend() {
		return send;
	}

	public void setSend(Integer send) {
		this.send = send;
	}

	public Integer getSsl() {
		return ssl;
	}

	public void setSsl(Integer ssl) {
		this.ssl = ssl;
	}

	public Integer getWait() {
		return wait;
	}

	public void setWait(Integer wait) {
		this.wait = wait;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("blocked", getBlocked())
			.add("connect", getConnect())
			.add("dns", getDns())
			.add("receive", getReceive())
			.add("send", getSend())
			.add("ssl", getSsl())
			.add("wait", getWait())
			.toString();
	}

	public static Builder newTimingsBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Timings data = new Timings();

		public Builder blocked(Integer blocked) {
			data.setBlocked(blocked);
			return this;
		}

		public Builder connect(Integer connect) {
			data.setConnect(connect);
			return this;
		}

		public Builder dns(Integer dns) {
			data.setDns(dns);
			return this;
		}

		public Builder receive(Integer receive) {
			data.setReceive(receive);
			return this;
		}

		public Builder send(Integer send) {
			data.setSend(send);
			return this;
		}

		public Builder ssl(Integer ssl) {
			data.setSsl(ssl);
			return this;
		}

		public Builder wait(Integer wait) {
			data.setWait(wait);
			return this;
		}

		public Timings build() {
			return data;
		}

	}

}
