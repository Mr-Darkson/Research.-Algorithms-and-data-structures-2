package me.absolute.util;

import java.math.BigDecimal;

public class TimeCounter {
    private static long start;
    private static long finish;

    public static void start() {
        start = System.nanoTime();
    }
    public static long finish() {
        if(start == 0) {
            System.out.println("Отсчёт не был начат");
            return 0;
        }
        else {
            finish = System.nanoTime();
            long diff = (finish-start)/1000;
            start = 0;
            return diff;

        }
    }

}
