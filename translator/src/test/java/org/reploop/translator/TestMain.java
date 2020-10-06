package org.reploop.translator;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Integer.max;

public class TestMain {
    @Test
    public void test() {
        execute(1000, 80, 50);
    }

    public void execute(int views, int reg, int ratio) {
        int xMin = 1;
        int xMax = 100;

        int yMin = 1;
        int yMax = 1000;

        int m = 0;
        int n = 0;
        int t = 0;
        for (int r = 0; r < views; r++) {
            int p = t;
            int max = (n + 1) * 700 - t;
            int percent = ThreadLocalRandom.current().nextInt(100);
            boolean selected = percent < reg;
            if (selected) {
                int x = ThreadLocalRandom.current().nextInt(xMin, xMax);
                m++;
                t += floor(max, x, xMin);
            }
            percent = ThreadLocalRandom.current().nextInt(100);
            if (selected && percent < ratio) {
                int y = ThreadLocalRandom.current().nextInt(yMin, yMax);
                n++;
                t += floor(max, y, yMin);
            }
            System.out.printf("%6d,%6d,%6d%n", m, n, t - p);
        }
        System.out.printf("%6d,%6d,%6d%n", m, n, t);
    }

    private int floor(int max, int v, int lower) {
        if (max <= lower) {
            return lower;
        }
        while (v > max) {
            v /= 3;
        }
        return max(v, lower);
    }
}
