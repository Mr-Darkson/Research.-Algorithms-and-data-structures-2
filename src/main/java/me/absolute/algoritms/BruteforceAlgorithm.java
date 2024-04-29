package me.absolute.algoritms;

import me.absolute.model.Point;
import me.absolute.model.Rectangle;

import java.util.List;

public class BruteforceAlgorithm {

    private List<Rectangle> rectangles;


    public void prepare(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public List<Long> consider(List<Point> points) {
        return points.stream().map(this::solveForPoint).toList();
    }

    public long solveForPoint(Point point) {
        return rectangles.stream().
                filter(point::isInside)
                .count();
    }
}
