package org.reploop.translator.json.support;

import java.util.Optional;

public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
        init();
    }

    public static Matrix create(int rows, int columns) {
        return new Matrix(rows, columns);
    }

    private boolean isSet(int row, int column) {
        return matrix[row][column] == 1;
    }

    public void set(int row, int column) {
        matrix[row][column] = 1;
    }

    public void computeScore() {
        // score column index
        int scoreColumnIndex = columns - 1;
        // score row index
        int scoreRowIndex = rows - 1;

        // sum rows and columns
        for (int r = 0; r < scoreRowIndex; r++) {
            for (int c = 0; c < scoreColumnIndex; c++) {
                matrix[r][scoreColumnIndex] += matrix[r][c];
                matrix[scoreRowIndex][c] += matrix[r][c];
            }
        }
    }

    private void swapRow(int r1, int r2) {
        for (int i = 0; i < columns; i++) {
            int temp = matrix[r1][i];
            matrix[r1][i] = matrix[r2][i];
            matrix[r2][i] = temp;
        }
    }

    private void swapColumn(int c1, int c2) {
        for (int i = 0; i < rows; i++) {
            int temp = matrix[i][c1];
            matrix[i][c1] = matrix[i][c2];
            matrix[i][c2] = temp;
        }
    }

    /**
     * Bubble sort, order desc
     */
    public void sort(SwapListener rowSwapListener, SwapListener columnSwapListener) {
        int scoreRowIndex = rows - 1;
        int scoreColumnIndex = columns - 1;

        // rows, not include column score row
        for (int i = 0; i < scoreRowIndex; i++) {
            for (int j = 0; j < scoreRowIndex - 1 - i; j++) {
                int s1 = matrix[j][scoreColumnIndex];
                int jn = j + 1;
                int s2 = matrix[jn][scoreColumnIndex];
                if (s1 < s2) {
                    swapRow(j, jn);
                    rowSwapListener.swap(j, jn);
                }
            }
        }

        // columns, not include row score column
        for (int i = 0; i < scoreColumnIndex; i++) {
            for (int j = 0; j < scoreColumnIndex - i - 1; j++) {
                int s1 = matrix[scoreRowIndex][j];
                int jn = j + 1;
                int s2 = matrix[scoreRowIndex][jn];
                if (s1 < s2) {
                    swapColumn(j, jn);
                    columnSwapListener.swap(j, jn);
                }
            }
        }
    }

    public Point maxArea(int fs, int ms, int f, int m) {
        int maxArea = 0;
        int mf = 0;
        int mm = 0;
        for (int f1 = f; f1 < fs; f1++) {
            for (int m1 = m; m1 < ms; m1++) {
                if (maxRect(f, m, f1, m1)) {
                    int area = (f1 - f + 1) * (m1 - m + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        mf = f1;
                        mm = m1;
                    }
                }
            }
        }
        return new Point(mf, mm);
    }

    public Optional<Rect> maxArea() {
        // exclude score row
        int fs = rows - 1;
        // exclude score column
        int ms = columns - 1;
        return maxArea(fs, ms);
    }

    public Optional<Rect> maxArea(int fs, int ms) {
        int maxArea = 0;
        Point lt = new Point();
        Point rb = new Point();
        for (int f = 0; f < fs; f++) {
            for (int m = 0; m < ms; m++) {
                Point p = maxArea(fs, ms, f, m);
                if (p.x > 0 && p.y > 0) {
                    int area = (p.x - f + 1) * (p.y - m + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        lt.x = f;
                        lt.y = m;
                        rb.x = p.x;
                        rb.y = p.y;
                    }
                }
            }
        }
        System.out.printf("(%d,%d)-(%d,%d)=%d%n", lt.x, lt.y, rb.x, rb.y, maxArea);
        if (maxArea > 0) {
            return Optional.of(new Rect(lt, rb));
        }
        return Optional.empty();
    }

    private boolean maxRect(int f1, int m1, int f2, int m2) {
        int f = f1;
        for (; f <= f2; f++) {
            int m = m1;
            for (; m <= m2; m++) {
                if (!isSet(f, m)) {
                    break;
                }
            }
            if (m <= m2) {
                break;
            }
        }
        return f > f2;
    }

    /**
     * Init zero valued two dimension matrix.
     */
    private void init() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                matrix[r][c] = 0;
            }
        }
    }

    public void print() {
        System.out.printf("%3d", 0);
        for (int j = 0; j < columns; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < columns; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
