package com.highloadrussia;

import java.util.Arrays;

import static com.highloadrussia.Utils.printArrayLimited;

public class SortingAlgorithms {

    public static void comparePerformanceOfSortingAlgorithms(int arrayLength) {

        long startTime;
        int[] arrayToSort = BenchmarkDataFactory.getArrayOfRandomValues(arrayLength);
        int[] sortedArray;
        int[] copyOfArrayToSort;

        System.out.println("Benchmarking array size: " + arrayLength);

        printArrayLimited("Unsorted array: ", arrayToSort);

        System.out.println("\n\nBubble sorting: ");
        System.out.println("===============");
        copyOfArrayToSort = Arrays.copyOf(arrayToSort, arrayToSort.length);
        startTime = System.currentTimeMillis();
        sortedArray = bubbleSort(copyOfArrayToSort);
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");

        printArrayLimited("Sorted array:   ", sortedArray);

        System.out.println("\n\nQuick sorting: ");
        System.out.println("==============");

        copyOfArrayToSort = Arrays.copyOf(arrayToSort, arrayToSort.length);
        startTime = System.currentTimeMillis();
        sortedArray = quickSort(copyOfArrayToSort);
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");

        printArrayLimited("Sorted array:   ", sortedArray);
    }

    public static int[] bubbleSort(int[] arrayToSort) {

        int indexOfSmallest;

        for (int i = 0; i < arrayToSort.length; i++) {
            indexOfSmallest = i;
            for (int j = i; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            if (indexOfSmallest != i) {
                int tmp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[indexOfSmallest];
                arrayToSort[indexOfSmallest] = tmp;
            }
        }

        return arrayToSort;
    }

    public static int[] quickSort(int[] arrayToSort) {

        int baseIndex;
        int baseValue;
        int leftArrayRealLength;
        int rightArrayRealLength;
        int[] arrayLeft;
        int[] arrayRight;
        int[] result;

        // check base conditions
        if (arrayToSort == null) {
            return null;
        } else if (arrayToSort.length == 1) {
            return arrayToSort;
        } else if (arrayToSort.length == 2) {
            if (arrayToSort[0] > arrayToSort[1]) {
                int tmp = arrayToSort[0];
                arrayToSort[0] = arrayToSort[1];
                arrayToSort[1] = tmp;
            }
            return arrayToSort;
        }

        baseIndex = arrayToSort.length / 2;
        baseValue = arrayToSort[baseIndex];
        arrayLeft = new int[arrayToSort.length - 1];
        arrayRight = new int[arrayToSort.length - 1];
        result = new int[arrayToSort.length];

        leftArrayRealLength = 0;
        rightArrayRealLength = 0;

        // fill arrays of lowest\greatest
        for (int i = 0; i < arrayToSort.length; i++) {

            if (i == baseIndex) {
                continue;
            }

            if (arrayToSort[i] <= baseValue) {
                arrayLeft[leftArrayRealLength++] = arrayToSort[i];
            } else {
                arrayRight[rightArrayRealLength++] = arrayToSort[i];
            }
        }

        // sort array of lowest
        if (leftArrayRealLength > 0) {
            arrayLeft = quickSort(Arrays.copyOfRange(arrayLeft, 0, leftArrayRealLength));
        }

        // sort array of greatest
        if (rightArrayRealLength > 0) {
            arrayRight = quickSort(Arrays.copyOfRange(arrayRight, 0, rightArrayRealLength));
        }

        // fill left part
        if (leftArrayRealLength > 0) {
            System.arraycopy(arrayLeft, 0, result, 0, leftArrayRealLength);
        }

        // fill base part
        result[leftArrayRealLength] = baseValue;

        // fill right part
        if (rightArrayRealLength > 0) {
            System.arraycopy(arrayRight, 0, result, leftArrayRealLength + 1, rightArrayRealLength);
        }

        return result;
    }

}
