package com.example.algos;

import java.util.Arrays;

public class MexicanWaveSort {

    public static <T extends Comparable<T>> T[] sort(T[] input) {
        // sort the array
        // merge sort O(n log n)
        Arrays.sort(input);

        for (int i = 1; i < input.length - 1; i += 2) {
            T temp = input[i];

            input[i] = input[i + 1];

            input[i + 1] = temp;
        }

        return input;
    }
}
