package me.absolute;

import me.absolute.algoritms.BruteforceAlgorithm;
import me.absolute.algoritms.MatrixAlgorithm;
import me.absolute.algoritms.SegmentTreeAlgorithm;
import me.absolute.model.Point;
import me.absolute.model.Rectangle;
import me.absolute.model.SegmentTreeNode;
import me.absolute.util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rectangle> rectangles = Generator.generateRectangles(5);
                /*new ArrayList<>();
        rectangles.add(new Rectangle(Point.of(2,2), Point.of(6,8)));
        rectangles.add(new Rectangle(Point.of(5,4), Point.of(9,10)));
        rectangles.add(new Rectangle(Point.of(4,0), Point.of(11,6)));
        rectangles.add(new Rectangle(Point.of(8,2), Point.of(12,12)));

                 */

        List<Point> points = Generator.generatePoints(10);
                /*new ArrayList<>();
        points.add(Point.of(2,2));
        points.add(Point.of(12,12));
        points.add(Point.of(10,4));
        points.add(Point.of(5,5));
        points.add(Point.of(2, 10));
        points.add(Point.of(2,8));

                 */

        BruteforceAlgorithm bruteforceAlgorithm = new BruteforceAlgorithm();
        bruteforceAlgorithm.prepare(rectangles);
        for(Long x : bruteforceAlgorithm.consider(points)) {
            System.out.print(x + " ");
        }
        System.out.println();

        MatrixAlgorithm matrixAlgorithm = new MatrixAlgorithm();
        matrixAlgorithm.prepare(rectangles);
        for(Long x : matrixAlgorithm.consider(points)) {
            System.out.print(x + " ");
        }
        System.out.println();

        SegmentTreeAlgorithm segmentTreeAlgorithm = new SegmentTreeAlgorithm();
        segmentTreeAlgorithm.prepare(rectangles);
        for(Long x : segmentTreeAlgorithm.consider(points)) {
            System.out.print(x + " ");
        }

    }






}