package me.absolute.util;

import me.absolute.model.Point;
import me.absolute.model.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectangleGenerator {
    public static List<Rectangle> generateRectangles(long n) {
        var arr = new ArrayList<Rectangle>();
        for (long i = 0; i < n; i++) {
            arr.add(new Rectangle(Point.of(10 * i, 10 * i), Point.of(10 * (2 * n - i), 10 * (2 * n - i))));
        }
        return arr;
    }
}
