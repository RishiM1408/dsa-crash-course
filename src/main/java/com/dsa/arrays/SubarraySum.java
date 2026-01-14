package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic: Arrays & Hashing
 * Problem: Subarray Sum Equals K
 * LeetCode: 560
 * Complexity: O(n) Time | O(n) Space
 */
public class SubarraySum {

    /**
     * Finds the number of continuous subarrays whose sum equals k.
     * Uses Prefix Sum + HashMap strategy.
     * 
     * Logic:
     * sum(i, j) = sum(0, j) - sum(0, i-1)
     * We want sum(i, j) == k
     * Therefore: sum(0, i-1) = sum(0, j) - k
     * 
     * We iterate through the array, calculating currentSum (sum(0, j)).
     * We check if map contains (currentSum - k). If key exists, it means there are
     * 'value' number of previous indices (i-1) where the condition holds.
     */
    public int subarraySum(int[] nums, int k) {
        // Map stores <PrefixSum, Frequency>
        Map<Integer, Integer> map = new HashMap<>();

        // Base Case: A prefix sum of 0 exists once (before the array starts)
        // This handles cases where a subarray starting from index 0 equals k.
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Challenge: Check if there exists a prefix sum such that:
            // currentSum - prefixSum = k => prefixSum = currentSum - k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySum solver = new SubarraySum();

        // Test Case 1
        int[] nums1 = { 1, 1, 1 };
        int k1 = 2;
        System.out.println("Test 1: " + solver.subarraySum(nums1, k1)); // Output: 2

        // Test Case 2 (Negative numbers)
        int[] nums2 = { 1, -1, 0 };
        int k2 = 0;
        System.out.println("Test 2: " + solver.subarraySum(nums2, k2)); // Output: 3 ([1,-1], [0], [1,-1,0])
    }
}
