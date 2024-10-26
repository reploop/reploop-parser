package org.reploop.translator.json.support;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MatrixTest {

	@Test
	public void sort() {
		int rows = 4;
		int columns = 4;
		Matrix matrix = Matrix.create(rows, columns);

		int total = rows * columns;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
				int r = ThreadLocalRandom.current().nextInt(0, total);
				if (r > total / 2) {
					matrix.set(i, j);
				}
			}
		}
		matrix.computeScore();
		matrix.sort((i, j) -> System.out.printf("Row: %d<->%d%n", i, j), (i, j) -> System.out.printf("Column: %d<->%d%n", i, j));
		matrix.print();

		matrix.maxArea();
	}

}