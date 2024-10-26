package org.reploop.translator.json.support;

public class Rect {

	Point lt;

	Point rb;

	public Rect(Point lt, Point rb) {
		this.lt = lt;
		this.rb = rb;
	}

	@Override
	public String toString() {
		return String.format("[%s,%s]", lt.toString(), rb.toString());
	}

}
