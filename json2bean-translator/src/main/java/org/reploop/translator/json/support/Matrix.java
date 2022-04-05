package org.reploop.translator.json.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * A matrix mapping field and message relations.
 */
public class Matrix {
    private static final Logger LOG = LoggerFactory.getLogger(Matrix.class);
    private final int rows;
    private final int columns;
    private final int[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
        init();
    }

    /**
     * Create a matrix and initialize all cells' value as zero.
     *
     * @param rows    actually rows.
     * @param columns actually columns
     * @return the matrix
     */
    public static Matrix create(int rows, int columns) {
        return new Matrix(rows, columns);
    }

    /**
     * Test if a cell's value is 1.
     *
     * @param row    row index
     * @param column column index
     * @return true if it's value is 1.
     */
    private boolean isSet(int row, int column) {
        return matrix[row][column] == 1;
    }

    /**
     * Set a cell value as 1.
     *
     * @param row    row index
     * @param column column index
     */
    public void set(int row, int column) {
        matrix[row][column] = 1;
    }

    /**
     * Counts 1's
     */
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
     *
     * @param rowSwapListener    swap two rows
     * @param columnSwapListener swap two columns
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

        int rp = -1;
        // rows with same score
        for (int r = 0; r < scoreRowIndex - 1; rp = r, r++) {
            int s = matrix[r][scoreColumnIndex];
            int rn = r + 1;
            int sn = matrix[rn][scoreColumnIndex];
            if (s == sn) {
                boolean swap = false;
                for (int c = 0; c < scoreColumnIndex; c++) {
                    // increase 1's density
                    boolean hl = rp == -1 || matrix[rp][c] > matrix[r][c];
                    boolean lh = matrix[r][c] < matrix[rn][c];
                    if (hl && lh) {
                        swap = true;
                        break;
                    }
                }
                if (swap) {
                    swapRow(r, rn);
                    rowSwapListener.swap(r, rn);
                }
            }
        }

        int cp = -1;
        // columns with same score
        for (int c = 0; c < scoreColumnIndex - 1; cp = c, c++) {
            int s = matrix[scoreRowIndex][c];
            int cn = c + 1;
            int sn = matrix[scoreRowIndex][cn];
            if (s == sn) {
                boolean swap = false;
                for (int r = 0; r < scoreRowIndex - 1; r++) {
                    // increase 1's density
                    boolean hl = (cp == -1 || matrix[r][cp] > matrix[r][c]);
                    boolean lh = matrix[r][c] < matrix[r][cn];
                    if (hl && lh) {
                        swap = true;
                        break;
                    }
                }
                if (swap) {
                    swapColumn(c, cn);
                    columnSwapListener.swap(c, cn);
                }
            }
        }
    }

    /**
     * Compute max area rect from a given point.
     *
     * @param fs row count
     * @param ms column count
     * @param f  row index of the given point
     * @param m  column index of the given point
     * @return another point, let the given point (f,m) as the left top point, then this point right bottom point of a rect.
     */
    public Point maxArea(int fs, int ms, int f, int m) {
        int maxArea = 0;
        int mf = 0;
        int mm = 0;
        for (int f1 = f; f1 < fs; f1++) {
            for (int m1 = m; m1 < ms; m1++) {
                if (isRect(f, m, f1, m1)) {
                    int area = area(f, m, f1, m1);
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

    /**
     * Test if this rect cross at least 2 rows or 2 columns.
     *
     * @param p1 left top point
     * @param p2 right bottom point
     * @return true if this rect crosses at least 2 rows or 2 columns.
     */
    private boolean isNotLine(Point p1, Point p2) {
        return isNotLine(p1.x, p1.y, p2);
    }

    private boolean isNotLine(int x, int y, Point p2) {
        return y - p2.y != 0 && x - p2.x != 0;
    }

    private int area(int f1, int m1, int f2, int m2) {
        return (f2 - f1 + 1) * (m2 - m1 + 1);
    }

    private int area(int f, int m, Point p2) {
        return area(f, m, p2.x, p2.y);
    }

    private int area(Point p1, Point p2) {
        return area(p1.x, p1.y, p2);
    }

    /**
     * Compute max area.
     *
     * @param fs row count
     * @param ms column count
     * @return max area rect if any
     */
    public Optional<Rect> maxArea(int fs, int ms) {
        int maxArea = 0;
        Point lt = new Point();
        Point rb = new Point();
        for (int f = 0; f < fs; f++) {
            for (int m = 0; m < ms; m++) {
                Point p = maxArea(fs, ms, f, m);
                // Find a match
                if (p.x > 0 && p.y > 0) {
                    int area = area(f, m, p);
                    if (area > maxArea && isNotLine(f, m, p)) {
                        maxArea = area;
                        lt.x = f;
                        lt.y = m;
                        rb.x = p.x;
                        rb.y = p.y;
                    }
                }
            }
        }
        LOG.info("({},{})-({},{})={}", lt.x, lt.y, rb.x, rb.y, maxArea);
        if (maxArea > 0) {
            return Optional.of(new Rect(lt, rb));
        }
        return Optional.empty();
    }

    /**
     * Left top point (f1,m1), right bottom point (f2,m2). Test if all cells in this rect are set.
     *
     * @param f1 row index of left top point
     * @param m1 column index of left top point
     * @param f2 row index of right bottom point
     * @param m2 column index of right bottom point
     * @return true if all cells are set.
     */
    private boolean isRect(int f1, int m1, int f2, int m2) {
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

    /**
     * Print matrix for debug
     */
    public void print() {
        System.out.println("-------------------");
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
