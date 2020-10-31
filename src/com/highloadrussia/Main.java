package com.highloadrussia;

import static com.highloadrussia.SortingAlgorithms.comparePerformanceOfSortingAlgorithms;

public class Main {

    private static final int ARRAY_LENGTH = 50_000;

    public static void main(String[] args) {

        comparePerformanceOfSortingAlgorithms(ARRAY_LENGTH);

    }

}