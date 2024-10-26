package org.reploop.translator.json.type;

public class NumberSpec {

	private boolean floating;

	private int bits;

	public NumberSpec(boolean floating, int bits) {
		this.floating = floating;
		this.bits = bits;
	}

	public boolean isFloating() {
		return floating;
	}

	public void setFloating(boolean floating) {
		this.floating = floating;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	@Override
	public String toString() {
		return "NumberSpec{" + "floating=" + floating + ", bits=" + bits + '}';
	}

}
