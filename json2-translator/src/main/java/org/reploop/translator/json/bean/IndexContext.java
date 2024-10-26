package org.reploop.translator.json.bean;

public class IndexContext {

	private Integer index;

	public IndexContext() {
		// Let's start with zero.
		this(0);
	}

	public IndexContext(Integer index) {
		this.index = index;
	}

	public Integer get() {
		return index;
	}

	public Integer getAndIncrement() {
		return getAndAdd(1);
	}

	public Integer getAndAdd(int delta) {
		Integer idx = index;
		index += delta;
		return idx;
	}

	public void index(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return String.valueOf(index);
	}

}
