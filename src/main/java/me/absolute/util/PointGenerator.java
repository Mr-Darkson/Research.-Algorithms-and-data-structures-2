package me.absolute.util;

import me.absolute.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {
    public static List<Point> generatePoints(long n) {
        var arr = new ArrayList<Point>();
        long pX = 75254857;
        long pY = 40509479;
        for (long i = 0; i < n; i++) {
            long first = hashPoint(i, pX, n);
            long second = hashPoint(i, pY, n);
            arr.add(Point.of(first, second));
        }

        return arr;
    }

    private static long hashPoint(long i, long p, long n) {
        return (long) (Math.pow((i * p), 31) % (20 * n));
    }
}
