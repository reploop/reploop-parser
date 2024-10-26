package org.reploop.translator.json.util;

import java.util.Objects;

public class Range implements Comparable<Range> {

	private int start;

	private int end;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int distance() {
		return end - start;
	}

	@Override
	public String toString() {
		return "Range{" + "start=" + start + ", end=" + end + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Range range = (Range) o;
		return start == range.start && end == range.end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

	@Override
	public int compareTo(Range o) {
		return this.distance() - o.distance();
	}

}