package me.absolute.algoritms;

import me.absolute.model.Point;
import me.absolute.model.Rectangle;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class MatrixAlgorithm {
    private List<Long> valuesX;
    private List<Long> valuesY;

    private long[][] matrix;


    public void prepare(List<Rectangle> rectangles) {
        prepareValuesX(rectangles);
        prepareValuesY(rectangles);
        int n = valuesX.size()-1;
        int m = valuesY.size()-1;
        matrix = new long[n][m];

        rectangles.forEach(this::writeRectangle);
    }

    private void prepareValuesX(List<Rectangle> rectangles) {
        TreeSet<Long> xUnicValue = new TreeSet<>();
        for(Rectangle rectangle : rectangles) {
            xUnicValue.add(rectangle.leftBottom().x());
            xUnicValue.add(rectangle.rightTop().x());
        }
        valuesX = xUnicValue.stream().toList();
    }
    private void prepareValuesY(List<Rectangle> rectangles) {
        TreeSet<Long> yUnicValue = new TreeSet<>();
        for(Rectangle rectangle : rectangles) {
            yUnicValue.add(rectangle.leftBottom().y());
            yUnicValue.add(rectangle.rightTop().y());
        }
        valuesY = yUnicValue.stream().toList();
    }


    private void writeRectangle(Rectangle r) {
        int minXInd = getIndexX(r.leftBottom().x());
        int maxXInd = getIndexX(r.rightTop().x());
        int minYInd = getIndexY(r.leftBottom().y());
        int maxYInd = getIndexY(r.rightTop().y());

        for (int y = minYInd; y < maxYInd; y++) {
            for(int x = minXInd; x < maxXInd; x++) {
                matrix[x][y]++;
            }
        }
    }

    private long solveForPoint(Point point) {
        int xIndex = getIndexX(point.x());
        int yIndex = getIndexY(point.y());

        return getByIndexes(xIndex, yIndex);
    }

    private long getByIndexes(int i, int j) {
        try {
            return matrix[i][j];
        } catch (Exception e) {
            return 0;
        }
    }

    private int getIndexX(long y) {
        return binSearch(valuesX, y);
    }

    private int getIndexY(long x) {
        return binSearch(valuesY, x);
    }

    private int binSearch(List<Long> list, long target) {
        int index = Collections.binarySearch(list, target);
        if (index >= 0) {
            return index;
        }

        return -(index + 2);
    }

    public List<Long> consider(List<Point> points) {
        return points.stream()
                .map(this::solveForPoint)
                .toList();
    }
}
