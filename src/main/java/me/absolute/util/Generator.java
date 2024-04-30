package me.absolute.util;

import me.absolute.model.Point;
import me.absolute.model.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<Rectangle> generateRectangles(long n) {
        return RectangleGenerator.generateRectangles(n);
    }

    public static List<Point> generatePoints(long n) {
        return PointGenerator.generatePoints(n);
    }

}
