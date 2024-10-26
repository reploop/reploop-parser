package org.reploop.translator.json.support;

public enum Target {

	JAVA("java"), GO("go"), AVRO("avsc"), PROTO("proto"), THRIFT("thrift");

	private final String ext;

	Target(String ext) {
		this.ext = ext;
	}

	public String ext() {
		return ext;
	}

}
