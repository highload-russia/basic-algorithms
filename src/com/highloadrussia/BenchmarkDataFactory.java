package com.highloadrussia;

import java.util.Random;

public class BenchmarkDataFactory {

    private static final Random rd = new Random();

    public static int[] getArrayOfRandomValues(int arrayLength) {

        if (arrayLength < 1) {
            throw new IllegalArgumentException("Benchmarking array lenght must be at least 1. Passed value: " + arrayLength);
        }

        int[] result = new int[arrayLength];

        // init unsorted array with random values
        for (int i = 0; i < result.length; i++) {
            result[i] = rd.nextInt(arrayLength);
        }

        return result;
    }

}
