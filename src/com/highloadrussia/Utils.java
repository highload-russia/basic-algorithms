package com.highloadrussia;

import java.util.Arrays;

public class Utils {

    private static final int LOGGING_LIMIT = 30;

    static void printArrayLimited(String header, int[] arrayToLog) {
        System.out.println("\n" + header);

        Arrays.stream(arrayToLog).limit(LOGGING_LIMIT).forEach(value -> System.out.print(value + " "));

        if (arrayToLog.length > LOGGING_LIMIT) {
            System.out.println("... (too many elements to logging)");
        }
    }

}
