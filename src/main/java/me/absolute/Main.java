package me.absolute;

import me.absolute.algoritms.BruteforceAlgorithm;
import me.absolute.algoritms.MatrixAlgorithm;
import me.absolute.algoritms.SegmentTreeAlgorithm;
import me.absolute.model.Point;
import me.absolute.model.Rectangle;
import me.absolute.model.SegmentTreeNode;
import me.absolute.util.Generator;
import me.absolute.util.TimeCounter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        benchmark(10,10); // 10 25 50 100 200 400 600 800
        benchmark(25,25);
        benchmark(50,50);
        benchmark(100,100);
        benchmark(200,200);
        benchmark(400,400);
        benchmark(600,600);
        benchmark(800,800);

    }


    public static void benchmark(long countRecs, long countPoints) {
        List<Rectangle> rectangles = Generator.generateRectangles(countRecs);
        List<Point> points = Generator.generatePoints(countPoints);

        long[] bruteForceData = new long[3];
        String BRUTEFORCE_TEXT = "Bruteforse, время подготовки: %d, время исполнения: %d, общее время: %d\n";
        long[] matrixData = new long[3];
        String MATRIX_TEXT = "Matrix, время подготовки: %d, время исполнения: %d, общее время: %d\n";
        long[] segmentTreeData = new long[3];
        String SEGMENT_TREE_TEXT = "SegmentTree, время подготовки: %d, время исполнения: %d, общее время: %d\n";

        BruteforceAlgorithm bruteforceAlgorithm = new BruteforceAlgorithm();
        MatrixAlgorithm matrixAlgorithm = new MatrixAlgorithm();
        SegmentTreeAlgorithm segmentTreeAlgorithm = new SegmentTreeAlgorithm();
        List<Long> result;

        //BRUTEFORCE
        TimeCounter.start();
        bruteforceAlgorithm.prepare(rectangles);
        bruteForceData[0] = TimeCounter.finish();

        TimeCounter.start();
        result = bruteforceAlgorithm.consider(points);
        bruteForceData[1] = TimeCounter.finish();
        bruteForceData[2] = bruteForceData[0] + bruteForceData[1];



        //MATRIX
        TimeCounter.start();
        matrixAlgorithm.prepare(rectangles);
        matrixData[0] = TimeCounter.finish();

        TimeCounter.start();
        result = matrixAlgorithm.consider(points);
        matrixData[1] = TimeCounter.finish();
        matrixData[2] = matrixData[0] + matrixData[1];


        //SEGMENT-TREE
        TimeCounter.start();
        segmentTreeAlgorithm.prepare(rectangles);
        segmentTreeData[0] = TimeCounter.finish();

        TimeCounter.start();
        result = segmentTreeAlgorithm.consider(points);
        segmentTreeData[1] = TimeCounter.finish();
        segmentTreeData[2] = segmentTreeData[0] + segmentTreeData[1];

        System.out.printf(BRUTEFORCE_TEXT, bruteForceData[0], bruteForceData[1], bruteForceData[2]);
        System.out.printf(MATRIX_TEXT, matrixData[0], matrixData[1], matrixData[2]);
        System.out.printf(SEGMENT_TREE_TEXT, segmentTreeData[0], segmentTreeData[1], segmentTreeData[2]);


    }





}
