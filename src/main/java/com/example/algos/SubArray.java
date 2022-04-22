package com.example.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubArray {

    public static boolean hasSubarrayWithSum(Integer[] nums, int sum) {
        for (Integer[] subArray : getSubarrayWithSum(nums, sum)) {
            System.out.println(Arrays.toString(subArray));
        }

        // create an empty set to store the sum of elements of each
        // subarray `nums[0…i]`, where `0 <= i < nums.length`
        Set<Integer> set = new HashSet<>();

        // insert 0 into the set to handle the case when subarray with
        // k-sum starts from index 0
        set.add(sum);

        int subArraySum = 0;

        // traverse the given array
        for (int value : nums) {
            // sum of elements so far
            subArraySum += value;

            // if the sum is seen before, we have found a subarray with zero-sum
            if (set.contains(sum)) {
                return true;
            }

            // insert sum so far into the set
            set.add(subArraySum);
        }

        // we reach here when no subarray with zero-sum exists
        return false;
    }

    public static List<Integer[]> getSubarrayWithSum(Integer[] nums, int sum) {
        List<Integer[]> subArrays = new ArrayList<>();

        // create a map for storing the end index of all subarrays with
        // the sum of elements so far
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // To handle the case when the subarray with the given sum starts
        // from the 0th index
        hashMap.put(0, new ArrayList<Integer>());
        hashMap.get(0).add(-1);

        int currentSum = 0;

        // traverse the given array
        for (int index = 0; index < nums.length; index++) {
            // sum of elements so far
            currentSum += nums[index];

            // check if there exists at least one subarray with the given sum
            if (hashMap.containsKey(currentSum - sum)) {
                List<Integer> list = hashMap.get(currentSum - sum);

                for (Integer value : list) {
                    subArrays.add(Arrays.copyOfRange(nums, value + 1, index));
                }
            }

            // insert (target so far, current index) pair into the map
            hashMap.put(currentSum, new ArrayList<Integer>());
            hashMap.get(currentSum).add(index);
        }

        return subArrays;
    }
}
