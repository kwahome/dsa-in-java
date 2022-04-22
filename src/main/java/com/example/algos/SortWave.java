package com.example.algos;

import java.util.Arrays;

public class SortWave {

    public static <T extends Comparable<T>> T[] sortInWave(T[] input) {
        // sort the array
        // merge sort O(n log n)
        Arrays.sort(input);

        for (int i = 0; i < input.length - 1; i += 2) {
            T temp = input[i];

            input[i] = input[i + 1];

            input[i + 1] = temp;
        }

        return input;
    }
}
