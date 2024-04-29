package me.absolute.algoritms;

import me.absolute.model.Pair;
import me.absolute.model.PersistSegmentTree;
import me.absolute.model.Point;
import me.absolute.model.Rectangle;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SegmentTreeAlgorithm {
    private List<Long> unicY;
    private List<Long> unicX;

    private List<Change> changes;

    private PersistSegmentTree tree;
    public void prepare(List<Rectangle> rectangles) {
        //Prepare UNIC X
        TreeSet sortedSetY = new TreeSet();
        rectangles.forEach(x ->  {
            sortedSetY.add(x.leftBottom().y());
            sortedSetY.add(x.rightTop().y());
        });
        this.unicY = sortedSetY.stream().toList();
        //Prepare UNIC Y
        TreeSet sortedSetX = new TreeSet();
        rectangles.forEach(x ->  {
            sortedSetX.add(x.leftBottom().x());
            sortedSetX.add(x.rightTop().x());
        });
        unicX = sortedSetX.stream().toList();
        //Prepare CHANGES
        changes = rectangles.stream()
                .flatMap(r -> Stream.of(
                        new Change(r.leftBottom().x(), r.getYRange(), 1),
                        new Change(r.rightTop().x(), r.getYRange(), -1)))
                .sorted()
                .toList();

        //Prepare TREE
        tree = new PersistSegmentTree(new long[unicY.size() - 1]);
        changes.forEach(this::applyChange);
    }


    private void applyChange(Change change) {
        tree.addToSegment(change.change, yIndex(change.yRange.first()), yIndex(change.yRange.second()), change.x);
    }

    public int xIndex(long x) {
        return binSearch(unicX, x);
    }

    public List<Long> consider(List<Point> points) {
        return points.stream().map(this::calculateForPoint).toList();
    }

    public long calculateForPoint(Point point) {
        toStateByX(point.x());
        int yIndex = yIndex(point.y());
        return tree.get(yIndex);
    }

    private void toStateByX(long x) {
        tree.switchState(xIndex(x));
    }

    public int yIndex(long y) {
        return binSearch(unicY, y);
    }

    private int binSearch(List<Long> list, long target) {
        int index = Collections.binarySearch(list, target);

        if (index >= 0) return index;
        return -(index + 2);
    }

    private static class Change implements Comparable<Change> {
        long x;
        Pair<Long, Long> yRange;
        long change;

        Change(long x, Pair<Long, Long> yRange, long change) {
            this.x = x;
            this.yRange = yRange;
            this.change = change;
        }

        @Override
        public int compareTo(Change o) {
            return x - o.x < 0 ? -1 : (x == o.x ? 0 : 1);
        }
    }
}
