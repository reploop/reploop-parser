package org.reploop.translator.json.support;

public class Point {

	int x;

	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}

}
