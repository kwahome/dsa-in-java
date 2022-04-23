package com.example.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArray {

    public static boolean hasSubarrayWithSum(Integer[] nums, int targetSum) {
        return !getSubarrayWithSum(nums, targetSum).isEmpty();
    }

    public static List<Integer[]> getSubarrayWithSum(Integer[] nums, int targetSum) {
        List<Integer[]> subArrays = new ArrayList<>();

        // create a map for storing the end index of all subarrays with
        // the sum of elements so far
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // To handle the case when the subarray with the given sum starts
        // from the 0th index
        putInMap(hashMap, 0, -1);

        int currentSum = 0;

        // traverse the given array
        for (int index = 0; index < nums.length; index++) {
            // sum of elements so far
            currentSum += nums[index];

            // check if there exists at least one subarray with the given sum
            if (hashMap.containsKey(currentSum - targetSum)) {
                List<Integer> list = hashMap.get(currentSum - targetSum);

                for (Integer value : list) {
                    subArrays.add(Arrays.copyOfRange(nums, value + 1, index + 1));
                }
            }

            // insert (target so far, current index) pair into the map
            putInMap(hashMap, currentSum, index);
        }

        return subArrays;
    }

    private static <K, V> void putInMap(Map<K, List<V>> hashMap, K key, V value) {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<V>());
        hashMap.get(key).add(value);
    }
}
