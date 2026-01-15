package com.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525: Contiguous Array
 * Given a binary array nums, return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 *
 * Pattern: Prefix Sum + HashMap
 * Transform 0 to -1. Then the problem becomes finding the longest subarray with
 * sum 0.
 * We store the first occurrence of each prefix sum in a map.
 * If we see the same prefix sum again at index j, it means the subarray from
 * map.get(sum) + 1 to j has sum 0.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map stores <prefixSum, firstIndex>
        map.put(0, -1); // Base case: prefix sum 0 at index -1

        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as 1
            count += (nums[i] == 1 ? 1 : -1);

            if (map.containsKey(count)) {
                // If we have seen this count before, it means the subarray between the previous
                // index and current index has sum 0
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                // Store the first time we see this count
                map.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray solver = new ContiguousArray();

        // Test Case 1
        int[] nums1 = { 0, 1 };
        System.out.println("Test Case 1 ({0, 1}): " + (solver.findMaxLength(nums1) == 2 ? "PASS"
                : "FAIL (Expected 2, Got " + solver.findMaxLength(nums1) + ")"));

        // Test Case 2
        int[] nums2 = { 0, 1, 0 };
        System.out.println("Test Case 2 ({0, 1, 0}): " + (solver.findMaxLength(nums2) == 2 ? "PASS"
                : "FAIL (Expected 2, Got " + solver.findMaxLength(nums2) + ")"));

        // Test Case 3: Longer sequence
        int[] nums3 = { 0, 0, 1, 0, 0, 0, 1, 1 }; // sum: -1, -2, -1, -2, -3, -4, -3, -2. Indices where sum repeats.
        // 0->-1(-1), 1->-2(-2), 2->-1(0) [len 2-(-1)=3? no, index 2 is sum -1. prev -1
        // at index 0. len 2-0=2? Wait.
        // Let's trace manually.
        // i=-1, sum=0
        // i=0, v=0(-1), sum=-1. Map(-1, 0)
        // i=1, v=0(-1), sum=-2. Map(-2, 1)
        // i=2, v=1(+1), sum=-1. Seen -1 at 0. Len = 2-0=2. Max=2.
        // i=3, v=0(-1), sum=-2. Seen -2 at 1. Len = 3-1=2.
        // i=4, v=0(-1), sum=-3. Map(-3, 4)
        // i=5, v=0(-1), sum=-4. Map(-4, 5)
        // i=6, v=1(+1), sum=-3. Seen -3 at 4. Len = 6-4=2.
        // i=7, v=1(+1), sum=-2. Seen -2 at 1. Len = 7-1=6. Max=6.
        // Subarray: indices 2 to 7 -> {1, 0, 0, 0, 1, 1} -> 3 ones, 3 zeros. Length 6.
        // Correct.
        System.out.println("Test Case 3 ({0, 0, 1, 0, 0, 0, 1, 1}): " + (solver.findMaxLength(nums3) == 6 ? "PASS"
                : "FAIL (Expected 6, Got " + solver.findMaxLength(nums3) + ")"));

        // Test Case 4: No match
        int[] nums4 = { 1, 1, 1 };
        System.out.println("Test Case 4 ({1, 1, 1}): " + (solver.findMaxLength(nums4) == 0 ? "PASS"
                : "FAIL (Expected 0, Got " + solver.findMaxLength(nums4) + ")"));
    }
}
