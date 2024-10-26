package org.reploop.translator.json;

public class Demo extends Foo {

	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Demo{" + "mobile='" + mobile + '\'' + '}';
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static class Builder {

		private final Demo demo = new Demo();

		public Builder setId(Long id) {
			demo.setId(id);
			return this;
		}

		public Builder setName(String name) {
			demo.setName(name);
			return this;
		}

		public Demo build() {
			return demo;
		}

	}

}
